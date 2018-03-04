package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // Find the View that shows the songs(MainActivity)
        TextView songs=findViewById(R.id.songs);
        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs text is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MainActivity}
                Intent songsIntent=new Intent(AlbumsActivity.this, MainActivity.class);
                // Start the new activity
                startActivity(songsIntent);
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
                Intent playerIntent=new Intent(AlbumsActivity.this, PlayerActivity.class);
                // Start the new activity
                startActivity(playerIntent);
            }
        });
        final ArrayList<MyAlbums> albums=new ArrayList<>();
        albums.add(new MyAlbums("Fun.", "Some Nights", R.drawable.some_nights));
        albums.add(new MyAlbums("Arctic Monkeys", "AM", R.drawable.am));
        albums.add(new MyAlbums("Coldplay", "Viva La Vida", R.drawable.viva_la_vida));
        albums.add(new MyAlbums("Two Gallants", "What The Toll Tells", R.drawable.two_gallants));
        albums.add(new MyAlbums("Amy Winehouse", "Back To Black", R.drawable.amy));
        albums.add(new MyAlbums("Sia", "This Is Acting", R.drawable.sia));

        MyAlbumsAdapter albumsAdapter=new MyAlbumsAdapter(this, albums);
        GridView gridView=findViewById(R.id.gridview);
        gridView.setAdapter(albumsAdapter);

        // Set a click listener on the albums in the grid
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long lon) {

                // Create a new intent to open the {@link AlbumSongsActivity}
                Intent albumSongs=new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                MyAlbums currentMyAlbums=albums.get(position);

                // Construct a bundle to pass album data
                Bundle alBundle=new Bundle();
                alBundle.putString("album_title", currentMyAlbums.getAlbumTitle());
                alBundle.putString("artist_name", currentMyAlbums.getArtistName());
                alBundle.putInt("album_image", currentMyAlbums.getImageResId());
                albumSongs.putExtras(alBundle);
                // Start the new activity
                startActivity(albumSongs);
            }
        });
    }
}
