package com.project.biblinarium.mvvm.views.ui.pages.exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.exchange.ExchangeFindBooksViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.SearchingLineElement;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.AnnouncementButtonFragment;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.ClubButtonFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumFragment;

import java.util.ArrayList;

public class ExchangeFindBooksFragment extends Fragment {

    Button createAnnouncement;

    ExchangeFindBooksViewModel findBooksViewModel;
    SearchingLineElement findBooksSearchingElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange_find_books, container, false);

        findBooksViewModel = new ViewModelProvider(this).get(ExchangeFindBooksViewModel.class);
        findBooksSearchingElement = new SearchingLineElement();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_fragment_exchange_findBooks_searchingPanel, findBooksSearchingElement)
                .commit();

        createAnnouncement = view.findViewById(R.id.button_fragment_exchange_createAnnouncement);

        ArrayList<Bundle> bundles = findBooksViewModel.getAnnouncementsBundles();
        for (Bundle bundle : bundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_exchange_findAnnouncements_announcementsButtons,
                            AnnouncementButtonFragment.class,
                            bundle)
                    .commit();
        }

        createAnnouncement.setOnClickListener(v -> {
            ExchangeFragment parentFragment = (ExchangeFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_exchange_mainPanel, parentFragment.createAnnouncementFragment)
                    .commit();
        });

        return view;
    }
}