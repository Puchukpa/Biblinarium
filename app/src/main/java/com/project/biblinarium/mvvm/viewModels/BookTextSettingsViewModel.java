package com.project.biblinarium.mvvm.viewModels;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.repositories.SettingsRepository;

public class BookTextSettingsViewModel extends ViewModel {

    private SettingsRepository settingsRepository = new SettingsRepository();
    private ArrayAdapter<Integer> fontSizesAdapter;

    public void instantiateArrayAdapter(Context context) {
        fontSizesAdapter = new ArrayAdapter<Integer>(context, R.layout.list_element, settingsRepository.getFontSizes());
    }

    public ArrayAdapter<Integer> getFontSizesAdapter() {
        return fontSizesAdapter;
    }

    public Integer[] getFontSizes() {
        return settingsRepository.getFontSizes();
    }
}
