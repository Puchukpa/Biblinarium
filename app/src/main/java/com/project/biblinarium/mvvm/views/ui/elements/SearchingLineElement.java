package com.project.biblinarium.mvvm.views.ui.elements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.SearchingLineViewModel;

public class SearchingLineElement extends Fragment {

    EditText searchingLine;

    SearchingLineViewModel searchingLineViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_searching_line, container, false);

        searchingLineViewModel = new ViewModelProvider(this).get(SearchingLineViewModel.class);

        searchingLine = (EditText) view.findViewById(R.id.editText_searchingLine);

        return view;
    }
}