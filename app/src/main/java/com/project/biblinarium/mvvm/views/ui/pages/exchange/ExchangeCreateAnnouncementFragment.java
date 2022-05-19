package com.project.biblinarium.mvvm.views.ui.pages.exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.exchange.ExchangeCreateAnnouncementViewModel;

public class ExchangeCreateAnnouncementFragment extends Fragment {

    EditText announcementNameEnter;
    EditText announcementTagsEnter;
    EditText announcementAddressEnter;
    EditText announcementDescriptionEnter;
    EditText announcementContactsEnter;
    Button back;
    Button doneAnnouncementCreation;

    ExchangeCreateAnnouncementViewModel createAnnouncementViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange_create_announcement, container, false);

        announcementNameEnter = view.findViewById(R.id.editText_fragment_exchange_setAnnouncementName);
        announcementTagsEnter = view.findViewById(R.id.editText_fragment_exchange_setAnnouncementTags);
        announcementAddressEnter = view.findViewById(R.id.editText_fragment_exchange_setAnnouncementAddress);
        announcementDescriptionEnter = view.findViewById(R.id.editText_fragment_exchange_setAnnouncementDescription);
        announcementContactsEnter = view.findViewById(R.id.editText_fragment_exchange_setAnnouncementContacts);
        back = view.findViewById(R.id.button_fragment_exchange_back);
        doneAnnouncementCreation = view.findViewById(R.id.button_fragment_exchange_doneCreateAnnouncement);

        createAnnouncementViewModel = new ViewModelProvider(this).get(ExchangeCreateAnnouncementViewModel.class);

        back.setOnClickListener(v -> {
            ExchangeFragment parentFragment = (ExchangeFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_exchange_mainPanel, parentFragment.findBooksFragment)
                    .commit();
        });

        doneAnnouncementCreation.setOnClickListener(v -> {
            String name = announcementNameEnter.getText().toString();
            String tags = announcementTagsEnter.getText().toString();
            String address = announcementAddressEnter.getText().toString();
            String contacts = announcementContactsEnter.getText().toString();
            String description = announcementDescriptionEnter.getText().toString();
            createAnnouncementViewModel.createAnnouncement(name, tags, address, contacts, description);

            ExchangeFragment parentFragment = (ExchangeFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_exchange_mainPanel, parentFragment.findBooksFragment)
                    .commit();
        });

        return view;
    }
}