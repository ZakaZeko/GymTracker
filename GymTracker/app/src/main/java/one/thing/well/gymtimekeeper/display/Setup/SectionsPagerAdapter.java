package one.thing.well.gymtimekeeper.display.Setup;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import one.thing.well.gymtimekeeper.display.mainPage.FirstPage;
import one.thing.well.gymtimekeeper.display.mapOfGym.SecondPage;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a First_Page (defined as a static inner class below).
        if (position == 0) {
            return FirstPage.newInstance();
        } else if (position == 1) {
            return SecondPage.newInstance();
        } else {
            return FirstPage.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}

