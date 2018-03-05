package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MySongs> playlist;
    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the albums category
        TextView albums=findViewById(R.id.albums);
        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent=new Intent(MainActivity.this, AlbumsActivity.class);
                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        // Find the View that shows the player
        TextView player=findViewById(R.id.player);
        // Set a click listener on that View
        player.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the player is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlayerActivity}
                Intent playerIntent=new Intent(MainActivity.this, PlayerActivity.class);
                // Start the new activity
                startActivity(playerIntent);
            }
        });

        // Add albums to array list
        playlist=(AlbumsInput.allSongs());

        MySongsAdapter songsAdapter=new MySongsAdapter(this, playlist);
        ListView listView=findViewById(R.id.listview);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Create a new intent to open the {@link PlayerActivity}
                Intent songSongs=new Intent(MainActivity.this, PlayerActivity.class);
                MySongs currentSong=playlist.get(position);
                mPosition=position;

                // Pass song data
                songSongs.putExtra("song_title", currentSong.getSongTitle());
                songSongs.putExtra("artist_name", currentSong.getArtistName());
                songSongs.putExtra("album_image", currentSong.getImageResId());
                songSongs.putExtra("position", mPosition);

                // Start the new activity
                startActivity(songSongs);
            }
        });

    }

}
