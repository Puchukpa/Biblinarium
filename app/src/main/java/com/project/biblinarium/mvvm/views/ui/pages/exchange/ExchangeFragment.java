package com.project.biblinarium.mvvm.views.ui.pages.exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;

public class ExchangeFragment extends Fragment {

    ExchangeFindBooksFragment findBooksFragment;
    ExchangeCreateAnnouncementFragment createAnnouncementFragment;
    ExchangeAnnouncementPageFragment announcementPageFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange, container, false);

        findBooksFragment = new ExchangeFindBooksFragment();
        createAnnouncementFragment = new ExchangeCreateAnnouncementFragment();
        announcementPageFragment = new ExchangeAnnouncementPageFragment();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_exchange_mainPanel, findBooksFragment)
                .commit();

        return view;
    }
}