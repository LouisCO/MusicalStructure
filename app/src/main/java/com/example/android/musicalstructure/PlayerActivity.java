package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

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
    }
}
