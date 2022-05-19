package com.project.biblinarium.mvvm.views.ui.pages.reserve;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.reserve.ReserveFindBooksViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.SearchingLineElement;

public class ReserveFindBooksFragment extends Fragment {

    Button chooseLibrary;
    FloatingActionButton mapZoomIn;
    FloatingActionButton mapZoomOut;
    FloatingActionButton mapMyLocation;

    ReserveFindBooksViewModel findBooksViewModel;
    SearchingLineElement reserveFindBooksSearchingLineElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserve_find_books, container, false);

        chooseLibrary = view.findViewById(R.id.button_fragment_reserve_findBooks_chooseLibrary);
        mapZoomIn = view.findViewById(R.id.floatingActionButton_fragment_reserve_map_plus);
        mapZoomOut = view.findViewById(R.id.floatingActionButton_fragment_reserve_map_minus);
        mapMyLocation = view.findViewById(R.id.floatingActionButton_fragment_reserve_map_flag);

        findBooksViewModel = new ViewModelProvider(this).get(ReserveFindBooksViewModel.class);
        reserveFindBooksSearchingLineElement = new SearchingLineElement();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_fragment_reserve_findBooks_searchingPanel, reserveFindBooksSearchingLineElement)
                .commit();

        return view;
    }
}