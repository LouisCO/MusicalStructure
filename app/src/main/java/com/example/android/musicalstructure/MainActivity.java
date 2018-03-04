package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


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

        // Add albums to array list and display them randomly
        ArrayList<MySongs> songs=new ArrayList<>();
        songs.addAll(AlbumsInput.arcticMonkeys());
        songs.addAll(AlbumsInput.someNights());
        songs.addAll(AlbumsInput.coldplay());
        songs.addAll(AlbumsInput.amyWinehouse());
        songs.addAll(AlbumsInput.sia());
        songs.addAll(AlbumsInput.twoGallants());
        Collections.shuffle(songs);

        MySongsAdapter songsAdapter=new MySongsAdapter(this, songs);
        ((ListView) findViewById(R.id.listview)).setAdapter(songsAdapter);

    }

}
