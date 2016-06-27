package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jung on 6/25/2016.
 */
public class WordAdapter extends ArrayAdapter<Word>{

    private int mBackGroundColorID;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mBackGroundColorID = backgroundColor;
    }
    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being resused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);


        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_image);
        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResourceID());
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            iconView.setVisibility(View.GONE);
        }
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Version Name from the current AndroidFlavor object and set this text on the vNameTextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the Version Number from the current AndroidFlavor object and set this text on the vNumberTextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        View containerView = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mBackGroundColorID);
        containerView.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the Image Resource ID from the current AndroidFlavor object and set the image to iconView
        //iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView) so that it can be shown in the ListView
        return listItemView;
    }
}
