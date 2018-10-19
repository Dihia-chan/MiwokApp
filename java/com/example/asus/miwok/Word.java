package com.example.asus.miwok;

public class Word {

    /** Default translation for the word **/
    private String mDefaultTranslation;
    /** Miwok translation for the word **/
    private String mMiwokTranslation;
    /**icon **/
    private int mImage = NO_IMAGE_PROVIDED ;

    private int mMedia ;

    private static final int NO_IMAGE_PROVIDED = -1 ;

    public Word(String defaultTranslation, String miwokTranslation , int media ){
        mMiwokTranslation = miwokTranslation ;
        mDefaultTranslation = defaultTranslation ;
        mMedia = media ;
    }

    public Word(String defaultTranslation, String miwokTranslation , int image ,  int media  ){
        mMiwokTranslation = miwokTranslation ;
        mDefaultTranslation = defaultTranslation ;
        mImage = image ;
        mMedia = media ;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImage() {
        return mImage;
    }

    public int getMedia(){
        return mMedia;
    }

    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImage=" + mImage +
                ", mMedia=" + mMedia +
                '}';
    }
}
