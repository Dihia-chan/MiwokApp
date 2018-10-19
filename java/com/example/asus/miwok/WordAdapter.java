package com.example.asus.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mImgColor ;
    public WordAdapter(@NonNull Activity context, ArrayList<Word> word ,int colorID ) {
        super(context,0, word);
        mImgColor = colorID ;

    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_img, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MiwokText = (TextView) listItemView.findViewById(R.id.wordM);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MiwokText.setText(currentWord.getMiwokTranslation());
        MiwokText.setBackgroundResource(mImgColor);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultText = (TextView) listItemView.findViewById(R.id.wordE);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        DefaultText.setText(currentWord.getDefaultTranslation());
        DefaultText.setBackgroundResource(mImgColor);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        ImageView Image = (ImageView) listItemView.findViewById((R.id.img));

        if(currentWord.hasImage()) {
            Image.setImageResource(currentWord.getImage());
            //Make sur to set VISIBELIY of the view
            Image.setVisibility(View.VISIBLE);
        }else{
            //Hide the image view
            Image.setVisibility(View.GONE) ;
        }


        /** or
         * text_container id of linearLayout of words
         * // Set the theme color for the list item
         View textContainer = listItemView.findViewById(R.id.text_container);
         // Find the color that the resource ID maps to
         int color = ContextCompat.getColor(getContext(), mColorResourceId);
         *  textContainer.setBackgroundColor(color);
         */

        return listItemView;
    }
}
