package ru.rmp.moodnotes.fragments;

import android.app.ActionBar;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import ru.rmp.moodnotes.R;


public class MainFragment extends Fragment {
    DrawerLayout layout;
    FloatingActionButton addButton;
    FloatingActionButton noteButton;
    FloatingActionButton moodNoteButton;
    MaterialToolbar topAppBar;
    NavigationView navigationView;
    boolean isAllFabVisible;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        layout = view.findViewById(R.id.drawer_layout);
//        layout.closeDrawer(Gravity.LEFT);
//        topAppBar = view.findViewById(R.id.toolbar);
//        navigationView = view.findViewById(R.id.navigation_view);
//        addButton = view.findViewById(R.id.home_add_button);
//        noteButton = view.findViewById(R.id.home_note_button);
//        noteButton.setVisibility(View.GONE);
//        moodNoteButton = view.findViewById(R.id.home_mood_note_button);
//        moodNoteButton.setVisibility(View.GONE);
//        isAllFabVisible = false;
//        initNavigationDrawer();
//        initButtons();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_fragment, container, false);
    }

    private void initButtons() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAllFabVisible) {
                    noteButton.show();
                    moodNoteButton.show();
                    noteButton.setVisibility(View.VISIBLE);
                    moodNoteButton.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        noteButton.setTooltipText("заметка");
                    }

                    addButton.setImageResource(R.drawable.ic_close);

                    isAllFabVisible = true;
                } else {
                    noteButton.hide();
                    moodNoteButton.hide();
                    noteButton.setVisibility(View.GONE);
                    moodNoteButton.setVisibility(View.GONE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        moodNoteButton.setTooltipText("запись в трекер");
                    }

                    addButton.setImageResource(R.drawable.ic_add);

                    isAllFabVisible = false;
                }
            }
        });
    }

    private void initNavigationDrawer() {
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               layout.open();
            }
        });
    }
}
