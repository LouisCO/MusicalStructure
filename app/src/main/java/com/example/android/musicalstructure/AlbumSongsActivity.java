package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_songs);

        // Find the View that shows the songs(MainActivity)
        TextView songs=findViewById(R.id.songs);
        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs text is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MainActivity}
                Intent songsIntent=new Intent(AlbumSongsActivity.this, MainActivity.class);
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
                Intent albumsIntent=new Intent(AlbumSongsActivity.this, AlbumsActivity.class);
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
                Intent playerIntent=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                // Start the new activity
                startActivity(playerIntent);
            }
        });

        Intent albumSongs = getIntent();
        String albumTitle = albumSongs.getStringExtra("album_title");
        String artistName = albumSongs.getStringExtra("artist_name");
        int albumImage = albumSongs.getIntExtra("album_image", 0);

        // Display album data & cover image
        ((TextView)findViewById(R.id.album_title)).setText(albumTitle);
        ((TextView)findViewById(R.id.album_artist)).setText(artistName);
        ((ImageView)findViewById(R.id.album_image)).setImageResource(albumImage);

        // Display songs from current album
        ListView listView=findViewById(R.id.album_listview);

        switch (albumTitle) {
            case "Some Nights":
                final ArrayList<MySongs> funAlbum=AlbumsInput.someNights();
                MySongsAdapter funAdapter=new MySongsAdapter(this, funAlbum);
                listView.setAdapter(funAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // Create a new intent to open the {@link PlayerActivity}
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=funAlbum.get(position);
                        // Pass song data
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        // Start the new activity
                        startActivity(songSongs);
                    }
                });
                break;
            case "AM":
                final ArrayList<MySongs> amAlbum=AlbumsInput.arcticMonkeys();
                MySongsAdapter amAdapter=new MySongsAdapter(this,amAlbum);
                listView.setAdapter(amAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=amAlbum.get(position);
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        startActivity(songSongs);
                    }
                });
                break;
            case "Viva La Vida":
                final ArrayList<MySongs> coldplayAlbum=AlbumsInput.coldplay();
                MySongsAdapter coldplayAdapter=new MySongsAdapter(this,coldplayAlbum);
                listView.setAdapter(coldplayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=coldplayAlbum.get(position);
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        startActivity(songSongs);
                    }
                });
                break;
            case "What The Toll Tells":
                final ArrayList<MySongs> gallantsAlbum=AlbumsInput.twoGallants();
                MySongsAdapter gallantsAdapter=new MySongsAdapter(this,gallantsAlbum);
                listView.setAdapter(gallantsAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=gallantsAlbum.get(position);
                        // Construct a bundle to pass album data
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        startActivity(songSongs);
                    }
                });
                break;
            case "Back To Black":
                final ArrayList<MySongs> winehouseAlbum=AlbumsInput.amyWinehouse();
                MySongsAdapter winehouseAdapter=new MySongsAdapter(this,winehouseAlbum);
                listView.setAdapter(winehouseAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=winehouseAlbum.get(position);
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        startActivity(songSongs);
                    }
                });
                break;
            case "This Is Acting":
                final ArrayList<MySongs> siaAlbum=AlbumsInput.sia();
                MySongsAdapter siaAdapter=new MySongsAdapter(this,siaAlbum);
                listView.setAdapter(siaAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent songSongs=new Intent(AlbumSongsActivity.this, PlayerActivity.class);
                        MySongs currentSong=siaAlbum.get(position);
                        songSongs.putExtra("song_title", currentSong.getSongTitle());
                        songSongs.putExtra("artist_name", currentSong.getArtistName());
                        songSongs.putExtra("album_image", currentSong.getImageResId());
                        startActivity(songSongs);
                    }
                });
                break;
        }

    }
}
