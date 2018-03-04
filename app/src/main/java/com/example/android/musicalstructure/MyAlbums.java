package com.example.android.musicalstructure;

/**
 *  Created by Lenovo on 04/03/2018.
 */
class MyAlbums {
    private String mArtistName;
    private String mAlbumTitle;
    private int mImageResId;

    /**
     * Create a new MyAlbum object.
     *
     * @param artistName is the artist's name
     * @param albumTitle  is the album's title
     * @param imageResId is the album's cover image
     */
    MyAlbums(String artistName, String albumTitle, int imageResId) {
        mArtistName=artistName;
        mAlbumTitle=albumTitle;
        mImageResId=imageResId;
    }

    // Get the artist's name.
    String getArtistName() {
        return mArtistName;
    }

    // Get the album's title.
    String getAlbumTitle() {
        return mAlbumTitle;
    }

    // Get the cover image
    int getImageResId() {
        return mImageResId;
    }
}
