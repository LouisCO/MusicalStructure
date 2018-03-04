package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_songs);

        Intent intent = getIntent();
        String albumTitle = intent.getStringExtra("album_title");
        String artistName = intent.getStringExtra("artist_name");
        int albumImage = intent.getIntExtra("album_image", 0);

        // Display album data & cover image
        ((ImageView)findViewById(R.id.album_image)).setImageResource(albumImage);
        ((TextView)findViewById(R.id.album_title)).setText(albumTitle);
        ((TextView)findViewById(R.id.album_artist)).setText(artistName);

        // Display songs from current album
        ListView listView=findViewById(R.id.album_listview);

        switch (albumTitle) {
            case "Some Nights":
                ArrayList<MySongs> funAlbum=AlbumsInput.someNights();
                MySongsAdapter funAdapter=new MySongsAdapter(this, funAlbum);
                listView.setAdapter(funAdapter);
                break;
            case "AM":
                ArrayList<MySongs> amAlbum=AlbumsInput.arcticMonkeys();
                MySongsAdapter amAdapter=new MySongsAdapter(this,amAlbum);
                listView.setAdapter(amAdapter);
                break;
            case "Viva La Vida":
                ArrayList<MySongs> coldplayAlbum=AlbumsInput.coldplay();
                MySongsAdapter coldplayAdapter=new MySongsAdapter(this,coldplayAlbum);
                listView.setAdapter(coldplayAdapter);
                break;
            case "What The Toll Tells":
                ArrayList<MySongs> gallantsAlbum=AlbumsInput.twoGallants();
                MySongsAdapter gallantsAdapter=new MySongsAdapter(this,gallantsAlbum);
                listView.setAdapter(gallantsAdapter);
                break;
            case "Back To Black":
                ArrayList<MySongs> winehouseAlbum=AlbumsInput.amyWinehouse();
                MySongsAdapter winehouseAdapter=new MySongsAdapter(this,winehouseAlbum);
                listView.setAdapter(winehouseAdapter);
                break;
            case "This Is Acting":
                ArrayList<MySongs> siaAlbum=AlbumsInput.sia();
                MySongsAdapter siaAdapter=new MySongsAdapter(this,siaAlbum);
                listView.setAdapter(siaAdapter);
                break;
        }
    }
}
