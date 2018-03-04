package com.example.android.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class MySongsAdapter extends ArrayAdapter<MySongs> {

    /**
     * This is custom constructor
     *
     * @param context Current context
     * @param songs   List of albums
     */
    MySongsAdapter(@NonNull Activity context, ArrayList<MySongs> songs) {
        super(context, 0, songs);
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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView=convertView;
        if (listItemView == null) {
            listItemView=LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link MyAlbums} object located at this position in the list
        MySongs currentMySongs=getItem(position);
        // Find the TextView in the list_item.xml layout with the ID album_title
        // Get the title from the current MyAlbum object and
        // set this text on the name TextView
        ((TextView) listItemView.findViewById(R.id.title)).setText(currentMySongs.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID album_artist
        // Get the artist's name from the current MyAlbum object and
        // set this text on the name TextView
        ((TextView) listItemView.findViewById(R.id.artist)).setText(currentMySongs.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID album_image
        // Get the image resource ID from the current MyAlbum object and
        // set the image to iconView
        ((ImageView) listItemView.findViewById(R.id.play_icon)).setImageResource(currentMySongs.getImageResourceId());
        ((ImageView) listItemView.findViewById(R.id.cover_img)).setImageResource(currentMySongs.getImageResId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
