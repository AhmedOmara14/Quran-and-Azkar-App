package com.example.quran.ui.main;

import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.quran.R;

public class tabaccess extends FragmentPagerAdapter {
    public tabaccess(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 2:
                askarFragment askarFragment=new askarFragment();
                return askarFragment;

            case 1:
                quranFragment quranFragment=new quranFragment();
                return quranFragment;

            case 0:
                saveFragment saveFragment=new saveFragment();
                return saveFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 2:
                return "الأذكار";

            case 1:
                return "القرأن";
            case 0:
                return "محفوظ";

            default:
                return null;

        }
    }
}
