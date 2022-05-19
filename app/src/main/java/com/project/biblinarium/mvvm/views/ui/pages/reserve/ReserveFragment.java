package com.project.biblinarium.mvvm.views.ui.pages.reserve;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;

public class ReserveFragment extends Fragment {

    ReserveFindBooksFragment findBooksFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserve, container, false);

        findBooksFragment = new ReserveFindBooksFragment();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_reserve_mainPanel, findBooksFragment)
                .commit();

        return view;
    }
}