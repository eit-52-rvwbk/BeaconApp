package com.example.rominakehl.bildung_4_0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Einstieg_2 extends AppCompatActivity {

    Button buttonPrev, buttonNext;
    ViewFlipper viewFlipper;
    Animation slide_in_left, slide_out_right;
    private float initialX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstieg_2);

        buttonPrev = (Button) findViewById(R.id.btnPrev2);
        buttonNext = (Button) findViewById(R.id.btnNext2);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper2);

        slide_in_left = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        viewFlipper.setInAnimation(slide_in_left);
        viewFlipper.setOutAnimation(slide_out_right);

        TextView tView1 = (TextView)findViewById(R.id.txtKompetenzen);
        tView1.setText(getString(R.string.textKompetenzen));
        TextView tView2 = (TextView)findViewById(R.id.txtUebersicht);
        tView2.setText(getString(R.string.textUebersicht));

        buttonPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewFlipper.showPrevious();
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewFlipper.showNext();
            }
        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //Getting initial by event action down
                initialX = event.getX();
                break;

            case MotionEvent.ACTION_UP:

                //on action up the flipper will start and showing next item
                float finalX = event.getX();
                if(initialX > finalX) {

                    if(viewFlipper.getDisplayedChild() == 4)
                        break;

                    viewFlipper.showNext();
                }
                else {
                    if(viewFlipper.getDisplayedChild()==0)
                        break;
                    viewFlipper.showPrevious();
                }
        }
        return false;
    }
}
