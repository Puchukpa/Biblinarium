package com.project.biblinarium.mvvm.views.ui.pages.exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.exchange.ExchangeAnnouncementPageViewModel;

public class ExchangeAnnouncementPageFragment extends Fragment {

    TextView announcementTheme;
    TextView announcementUser;
    TextView announcementTags;
    TextView announcementContacts;
    TextView announcementAddress;
    TextView announcementDescription;
    FloatingActionButton back;

    ExchangeAnnouncementPageViewModel announcementPageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange_announcement_page, container, false);

        announcementTheme = view.findViewById(R.id.textView_fragment_exchange_announcementName);
        announcementUser = view.findViewById(R.id.textView_fragment_exchange_announcementPage_announcementUser);
        announcementTags = view.findViewById(R.id.textView_fragment_exchange_announcementPage_announcementTags);
        announcementContacts = view.findViewById(R.id.textView_fragment_exchange_announcementPage_announcementContacts);
        announcementAddress = view.findViewById(R.id.textView_fragment_exchange_announcementPage_announcementAddress);
        announcementDescription = view.findViewById(R.id.textView_fragment_exchange_announcementPage_announcementDescription);
        back = view.findViewById(R.id.floatingActionButton_fragment_exchange_announcementPage_back);

        announcementPageViewModel = new ViewModelProvider(this).get(ExchangeAnnouncementPageViewModel.class);

        announcementPageViewModel.setBundle(requireArguments());

        announcementTheme.setText(announcementPageViewModel.getAnnouncementName());
        announcementUser.setText(announcementPageViewModel.getAnnouncementUser());
        announcementTags.setText(announcementPageViewModel.getAnnouncementTags());
        announcementContacts.setText(announcementPageViewModel.getAnnouncementContacts());
        announcementAddress.setText(announcementPageViewModel.getAnnouncementAddress());
        announcementDescription.setText(announcementPageViewModel.getAnnouncementDescription());

        back.setOnClickListener(v -> {
            ExchangeFragment parentFragment = (ExchangeFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_exchange_mainPanel, parentFragment.findBooksFragment)
                    .commit();
        });

        return view;
    }
}