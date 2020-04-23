package com.example.quran.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class tabaccess_save extends FragmentPagerAdapter {
    public tabaccess_save(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                azkarFragment_save askarFragment = new azkarFragment_save();
                return askarFragment;

            case 1:
                quranFragment_save quranFragment = new quranFragment_save();
                return quranFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "الأذكار";

            case 1:
                return "القرأن";
            default:
                return null;

        }
    }
}
