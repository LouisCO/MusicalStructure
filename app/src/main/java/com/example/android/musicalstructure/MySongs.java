package com.example.android.musicalstructure;

/**
 * Created by Lenovo on 04/03/2018.
 * {@link MySongs} represents a song showed in the playlist.
 * It contains the title and the performing artist.
 */
class MySongs {
    private String mArtistName;
    private String mSongTitle;
    private int mImageResourceId;
    private int mImageResId;

    /**
     * Create a new MyAlbum object.
     *
     * @param artistName      is the artist's name
     * @param songTitle       is the song's title
     * @param imageResourceId is the play icon
     * @param imageResId      is the album's cover image
     */
    MySongs(String artistName, String songTitle, int imageResourceId, int imageResId) {
        mArtistName=artistName;
        mSongTitle=songTitle;
        mImageResourceId=imageResourceId;
        mImageResId=imageResId;
    }

    // Get the artist's name.
    String getArtistName() {
        return mArtistName;
    }

    // Get the song's title.
    String getSongTitle() {
        return mSongTitle;
    }

    // Get the icon image
    int getImageResourceId() {
        return mImageResourceId;
    }

    // Get the album cover image
    int getImageResId() {
        return mImageResId;
    }
}