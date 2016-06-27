package com.example.android.miwok;

/**
 * Created by Jung on 6/25/2016.
 */
public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceID = -1;

    public Word (String defaultTranslation, String miwokTranslation, int imageResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
    }
    public Word (String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID () {
        return mImageResourceID;
    }

    public boolean hasImage() {
        return mImageResourceID != -1;
    }
}
