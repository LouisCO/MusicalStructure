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
                        // Construct a bundle to pass album data
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
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
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
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
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
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
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
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
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
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
                        Bundle sBundle=new Bundle();
                        sBundle.putString("song_title", currentSong.getSongTitle());
                        sBundle.putString("artist_name", currentSong.getArtistName());
                        sBundle.putInt("album_image", currentSong.getImageResId());
                        songSongs.putExtras(sBundle);
                        startActivity(songSongs);
                    }
                });
                break;
        }

    }
}
