package com.acompany.remindme.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.acompany.remindme.dto.RemindDTO;
import com.acompany.remindme.fragment.AbstractTabFragment;
import com.acompany.remindme.fragment.BirthdayFragment;
import com.acompany.remindme.fragment.HistoryFragment;
import com.acompany.remindme.fragment.IdeasFragment;
import com.acompany.remindme.fragment.TODOFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private Map<Integer, AbstractTabFragment> tabs;

    private List<RemindDTO> data;

    private HistoryFragment historyFragment;


    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();
        initTabsMap(context);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int i) {
        return tabs.get(i);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs = new HashMap<>();
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TODOFragment.getInstance(context));
        tabs.put(3, BirthdayFragment.getInstance(context));
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
        historyFragment.refreshData(data);
    }
}
