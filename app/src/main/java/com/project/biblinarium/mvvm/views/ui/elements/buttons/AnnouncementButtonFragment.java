package com.project.biblinarium.mvvm.views.ui.elements.buttons;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.exchange.ExchangeAnnouncementButtonViewModel;
import com.project.biblinarium.mvvm.viewModels.exchange.ExchangeFindBooksViewModel;
import com.project.biblinarium.mvvm.views.ui.pages.exchange.ExchangeAnnouncementPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.exchange.ExchangeFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumClubPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.forum.ForumFragment;

public class AnnouncementButtonFragment extends Fragment {
    
    TextView announcementTheme;
    TextView announcementUser;
    TextView announcementTags;
    Button announcementButton;
    
    ExchangeAnnouncementButtonViewModel findBooksViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_button_announcement_button, container, false);
        
        announcementTheme = view.findViewById(R.id.textView_element_buttons_announcementName);
        announcementUser = view.findViewById(R.id.textView_element_buttons_announcementUser);
        announcementTags = view.findViewById(R.id.textView_element_buttons_announcementTags);
        announcementButton = view.findViewById(R.id.button_fragment_exchange_button);
        
        findBooksViewModel = new ViewModelProvider(this).get(ExchangeAnnouncementButtonViewModel.class);

        findBooksViewModel.setBundle(requireArguments());

        announcementTheme.setText(findBooksViewModel.getAnnouncementName());
        announcementUser.setText(findBooksViewModel.getAnnouncementUser());
        announcementTags.setText(findBooksViewModel.getAnnouncementTags());
        
        announcementButton.setOnClickListener(v -> {
            Bundle bundle = findBooksViewModel.getBundle();

            ExchangeFragment parentFragment = (ExchangeFragment) getParentFragment().getParentFragment();
            parentFragment
                    .getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_exchange_mainPanel, ExchangeAnnouncementPageFragment.class, bundle)
                    .commit();
        });
        
        return view;
    }
}