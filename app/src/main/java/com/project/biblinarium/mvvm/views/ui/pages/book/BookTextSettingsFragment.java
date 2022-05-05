package com.project.biblinarium.mvvm.views.ui.pages.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.viewModels.BookTextSettingsViewModel;
import com.project.biblinarium.mvvm.viewModels.BookViewModel;
import com.project.biblinarium.mvvm.views.activities.BookActivity;

public class BookTextSettingsFragment extends Fragment {

    Spinner fontSpinner;
    Spinner fontSizeSpinner;
    ToggleButton nightMode;

    BookTextSettingsViewModel textSettingsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_text_settings, container, false);

        textSettingsViewModel = new ViewModelProvider(this).get(BookTextSettingsViewModel.class);

        fontSpinner = (Spinner) view.findViewById(R.id.spinner_fragment_textSettings_fontSpinner);
        fontSizeSpinner = (Spinner) view.findViewById(R.id.spinner_fragment_textSettings_sizeSpinner);
        nightMode = (ToggleButton) view.findViewById(R.id.toggleButton_fragment_textSettings_nightToggleButton);

        textSettingsViewModel.instantiateArrayAdapter(getActivity());
        fontSizeSpinner.setAdapter(textSettingsViewModel.getFontSizesAdapter());
        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                BookActivity bookActivity = (BookActivity) getActivity();
                BookViewModel bookViewModel = bookActivity.bookViewModel;
                bookViewModel.getFontSize().setValue(textSettingsViewModel.getFontSizes()[pos]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}