package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    String mSongTitle;
    String mArtistName;
    int mAlbumImage;
    int mCurrentPosition;
    ImageView playButton;
    ImageView prevButton;
    ImageView nextButton;
    boolean isPlaying;
    ArrayList<MySongs> current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playButton=findViewById(R.id.play_button);
        prevButton=findViewById(R.id.prev_button);
        nextButton=findViewById(R.id.next_button);
        isPlaying=true;

        // Find the View that shows the songs(MainActivity)
        TextView songs=findViewById(R.id.songs);
        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs text is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MainActivity}
                Intent songsIntent=new Intent(PlayerActivity.this, MainActivity.class);
                // Start the new activity
                startActivity(songsIntent);
            }
        });

        // Find the View that shows the albums category
        TextView albums=findViewById(R.id.albums);
        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent=new Intent(PlayerActivity.this, AlbumsActivity.class);
                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        Intent songSongs = getIntent();
        String songTitle = songSongs.getStringExtra("song_title");
        String artistName = songSongs.getStringExtra("artist_name");
        int albumImage = songSongs.getIntExtra("album_image", 0);
        final int currentPosition=songSongs.getIntExtra("position", 0);

        // Display album data & cover image
        ((TextView)findViewById(R.id.song_name)).setText(songTitle);
        ((TextView)findViewById(R.id.song_artist)).setText(artistName);
        ((ImageView)findViewById(R.id.song_img)).setImageResource(albumImage);

        mSongTitle=songTitle;
        mArtistName=artistName;
        mAlbumImage=albumImage;
        mCurrentPosition=currentPosition;
        current=(AlbumsInput.allSongs());


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(mCurrentPosition>0)) {
                    mCurrentPosition=(current.size()-1);
                }
                else {
                    mCurrentPosition--;
                }
                String mSongTitle = current.get(mCurrentPosition).getSongTitle();
                ((TextView)findViewById(R.id.song_name)).setText(mSongTitle);
                String mArtistName = current.get(mCurrentPosition).getArtistName();
                ((TextView)findViewById(R.id.song_artist)).setText(mArtistName);
                int mAlbumImage = current.get(mCurrentPosition).getImageResId();
                ((ImageView)findViewById(R.id.song_img)).setImageResource(mAlbumImage);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(!(mCurrentPosition<(current.size()-1))){
                        mCurrentPosition=0;
                    }
                    else {mCurrentPosition++;
                    }
                String mSongTitle = current.get(mCurrentPosition).getSongTitle();
                ((TextView)findViewById(R.id.song_name)).setText(mSongTitle);
                String mArtistName = current.get(mCurrentPosition).getArtistName();
                ((TextView)findViewById(R.id.song_artist)).setText(mArtistName);
                int mAlbumImage = current.get(mCurrentPosition).getImageResId();
                ((ImageView)findViewById(R.id.song_img)).setImageResource(mAlbumImage);
             }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    playButton.setImageResource(R.drawable.ic_pause);
                    isPlaying=false;
                    Toast.makeText(PlayerActivity.this, getString(R.string.pause_txt), Toast.LENGTH_LONG).show();
                }
                else {
                    playButton.setImageResource(R.drawable.ic_play_button);
                    Toast.makeText(PlayerActivity.this, current.get(mCurrentPosition).getSongTitle() + getString(R.string.play_txt), Toast.LENGTH_LONG).show();
                    isPlaying=true;
                }
            }
        });

    }
}
