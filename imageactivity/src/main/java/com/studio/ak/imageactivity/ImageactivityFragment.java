package com.studio.ak.imageactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Amal Krishnan on 17-08-2016.
 */
public class ImageactivityFragment extends Fragment {
    public ImageactivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //String strtext = getArguments().getString("joke");
        View myInflatedView = inflater.inflate(R.layout.fragment_blank, container,false);
        Bundle bundle=getActivity().getIntent().getExtras();
        String strtext=bundle.getString(Intent.EXTRA_TEXT);
        Log.d("ImageactivityFragment", "onCreateView: strtext="+strtext);
        TextView textView=(TextView) myInflatedView.findViewById(R.id.libraryWelcomeTextView);
        textView.setText(strtext);
        //return inflater.inflate(R.layout.fragment_blank, container, false);
        return myInflatedView;
    }
}
