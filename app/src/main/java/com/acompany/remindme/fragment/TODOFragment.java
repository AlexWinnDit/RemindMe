package com.acompany.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acompany.remindme.R;

public class TODOFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_example;


    public static TODOFragment getInstance(Context context) {
        Bundle args = new Bundle();
        TODOFragment fragment = new TODOFragment();
        fragment.setArguments(args);
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_todo));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }


    public void setContext(Context context) {
        this.context = context;
    }


}
