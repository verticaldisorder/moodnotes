package ru.rmp.moodnotes.views;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import ru.rmp.moodnotes.R;
import ru.rmp.moodnotes.databinding.HomeFragmentBinding;


public class MainFragment extends Fragment {
    HomeFragmentBinding binding;

    boolean isAllFabVisible;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNavigationDrawer();
        initButtons();
        initClickableCards();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.home_fragment);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    private void initButtons() {
        binding.homeNoteButton.setVisibility(View.GONE);

        binding.homeMoodNoteButton.setVisibility(View.GONE);
        isAllFabVisible = false;

        binding.homeAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAllFabVisible) {
                    binding.homeNoteButton.show();
                    binding.homeMoodNoteButton.show();
                    binding.homeNoteButton.setVisibility(View.VISIBLE);
                    binding.homeMoodNoteButton.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        binding.homeNoteButton.setTooltipText("заметка");
                    }

                    binding.homeAddButton.setImageResource(R.drawable.ic_close);

                    isAllFabVisible = true;
                } else {
                    binding.homeNoteButton.hide();
                    binding.homeMoodNoteButton.hide();
                    binding.homeNoteButton.setVisibility(View.GONE);
                    binding.homeMoodNoteButton.setVisibility(View.GONE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        binding.homeMoodNoteButton.setTooltipText("запись в трекер");
                    }

                    binding.homeAddButton.setImageResource(R.drawable.ic_add);

                    isAllFabVisible = false;
                }
            }
        });
    }

    private void initNavigationDrawer() {
        binding.drawerLayout.closeDrawer(Gravity.LEFT);
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.open();
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                binding.navigationView.setCheckedItem(item);
                switch (item.getItemId()) {
                    case R.id.home_item:
                        binding.drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent intentHome = new Intent(getContext(), MainFragment.class);
                        startActivity(intentHome);
                        break;
                    case R.id.diary_item:
                        binding.drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent intentDiary = new Intent(getContext(), DiaryFragment.class);
                        startActivity(intentDiary);
                        break;
                    case R.id.notes_item:
                        binding.drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent intentNotes = new Intent(getContext(), NotesFragment.class);
                        startActivity(intentNotes);
                        break;
                    case R.id.tracker_item:
                        binding.drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent intentTracker = new Intent(getContext(), TrackerFragment.class);
                        startActivity(intentTracker);
                        break;
                }
            return true;
            }
        });
    }

    private void initClickableCards() {
        binding.homeDateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO переход на фрагмент календаря
            }
        });
    }
}
