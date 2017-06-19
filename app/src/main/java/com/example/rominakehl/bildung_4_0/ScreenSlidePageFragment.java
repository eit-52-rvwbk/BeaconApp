package com.stundentcomments.stundentcomment;

/**
 * Created by yannick.mickler on 02.06.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Set;

public class ScreenSlidePageFragment extends Fragment {
    private TextView tv;
    private ImageView iv;

    // Argumente für Bild und Text übergeben
    public static ScreenSlidePageFragment newInstance(Content content)
    {
        ScreenSlidePageFragment f = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt("contentPic",content.getPicId());
        args.putString("contentComment",content.getComment());
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.student_comment_activity, container, false);
        // Referenzierung der Views
        tv = (TextView) rootView.findViewById(R.id.textview_student_comment);
        iv = (ImageView) rootView.findViewById(R.id.imageview_stundent_pic);
        setContent();
        return rootView;
    }

    // Bild und Text setzen
    private void setContent()
    {
        Bundle args = getArguments();
        tv.setText(args.getString("contentComment"));
        iv.setImageResource(args.getInt("contentPic"));
    }

}