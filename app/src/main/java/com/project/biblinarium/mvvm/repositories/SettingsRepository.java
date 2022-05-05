package com.project.biblinarium.mvvm.repositories;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.project.biblinarium.R;

public class SettingsRepository {

    private final Integer[] fontSizes = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};

    public Integer[] getFontSizes() {
        return fontSizes;
    }
}
