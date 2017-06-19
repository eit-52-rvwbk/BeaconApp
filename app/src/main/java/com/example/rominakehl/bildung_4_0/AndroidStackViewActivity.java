package com.example.rominakehl.bildung_4_0;

import android.app.Activity;
import android.os.Bundle;
import android.widget.StackView;

import java.util.ArrayList;

public class AndroidStackViewActivity extends Activity {


    private static StackView stackView;
    private static ArrayList<StackItems> list;

    private static final Integer[] icons = {R.drawable.measuring, R.drawable.lesson2,
            R.drawable.lesson4, R.drawable.lesson5, R.drawable.lesson6, R.drawable.workpieces, R.drawable.workpiecesandtasks};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stackview);

        stackView = (StackView) findViewById(R.id.stack_view);
        list = new ArrayList<StackItems>();

        for (int i = 0; i < icons.length; i++) {
            list.add(new StackItems("Item " + i, icons[i]));
        }
        StackAdapter adapter = new StackAdapter(AndroidStackViewActivity.this, list);
        stackView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}

