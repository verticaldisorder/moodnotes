package ru.rmp.moodnotes.fragments;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.rmp.moodnotes.R;


public class MainFragment extends Fragment {
    FloatingActionButton addButton;
    FloatingActionButton noteButton;
    FloatingActionButton moodNoteButton;
    boolean isAllFabVisible;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addButton = view.findViewById(R.id.home_add_button);
        noteButton = view.findViewById(R.id.home_note_button);
        noteButton.setVisibility(View.GONE);
        moodNoteButton = view.findViewById(R.id.home_mood_note_button);
        moodNoteButton.setVisibility(View.GONE);
        isAllFabVisible = false;
        initButtons();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
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
}
