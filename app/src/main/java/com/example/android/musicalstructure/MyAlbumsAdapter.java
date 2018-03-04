package com.example.android.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *  Created by Lenovo on 04/03/2018.
 */
public class MyAlbumsAdapter extends ArrayAdapter<MyAlbums> {

    /**
     * Custom constructor
     *
     * @param context Current context
     * @param albums  List of albums
     */
    MyAlbumsAdapter(Activity context, ArrayList<MyAlbums> albums) {
        super(context, 0, albums);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView=convertView;
        if (gridItemView == null) {
            gridItemView=LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }
        // Get the {@link MyAlbums} object located at this position in the list
        MyAlbums currentAlbum=getItem(position);
        // Find the TextView in the grid_item.xml layout with the ID album_title
        // Get the title from the current MyAlbum object and
        // set this text on the name TextView
        ((TextView) gridItemView.findViewById(R.id.album_title)).setText(currentAlbum.getAlbumTitle());

        // Find the TextView in the grid_item.xml layout with the ID album_artist
        // Get the artist's name from the current MyAlbum object and
        // set this text on the name TextView
        ((TextView) gridItemView.findViewById(R.id.album_artist)).setText(currentAlbum.getArtistName());

        // Find the ImageView in the grid_item.xml layout with the ID album_image
        // Get the image resource ID from the current MyAlbum object and
        // set the image to iconView
        ((ImageView) gridItemView.findViewById(R.id.album_image)).setImageResource(currentAlbum.getImageResId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return gridItemView;
    }
}
