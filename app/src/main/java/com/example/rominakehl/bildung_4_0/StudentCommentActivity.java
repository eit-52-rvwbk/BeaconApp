package com.stundentcomments.stundentcomment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentCommentActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static int NUM_PAGES = 0;
    private ArrayList<Content> lContent;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        lContent = new ArrayList<>();
        FillContentList();
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager, true);
    }

    // In die ArrayListe wird der anzuzeigende Content eingefügt
    private void FillContentList()  {
        try {
            AddContent(getResString(R.string.comment1), R.drawable.pic_1);
            AddContent(getResString(R.string.comment2), R.drawable.pic_2);
            //AddContent("Test3", R.drawable.pic_1);
            NUM_PAGES = lContent.size();
        }
        catch (Exception e)
        {
            Log.e("Fill",e.getMessage());
        }
    }

    private String getResString(int iID)
    {
       return getResources().getString(iID);
    }

    private void AddContent(String sText, int iId)throws Exception {
        Content con = new Content(sText,iId);
        if (con.isValid())
            lContent.add(con);
        else
            throw new Exception("Content ist leer!");
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int contentNr) {
            Content content = lContent.get(contentNr);
            if (!content.isValid())
                return new ScreenSlidePageFragment();
            return ScreenSlidePageFragment.newInstance(content);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
