package ru.rmp.moodnotes.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.rmp.moodnotes.R;
import ru.rmp.moodnotes.adapters.NoteAdapter;
import ru.rmp.moodnotes.databinding.NotesFragmentBinding;
import ru.rmp.moodnotes.models.Note;

public class NotesFragment extends Fragment {
    NotesFragmentBinding binding;
    private static final String NOTES = "notes";
    private List<Note> notes = new ArrayList<>();
    private SharedPreferences savedNotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.notes_fragment);
        return inflater.inflate(R.layout.notes_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setNotesToRecyclerView();
        initSendButton();

    }

    private void setNotesToRecyclerView() {
        try {
            setNotesIntoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NoteAdapter adapter = new NoteAdapter(this.getContext(), notes);
        binding.notesRecyclerView.setAdapter(adapter);
    }

    private void initSendButton() {
        binding.noteDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.noteTextEditText.getText().toString().equals("")) {
                    SharedPreferences.Editor editor = savedNotes.edit();
                    editor.putString(new Date().toString(), binding.noteTextEditText.getText().toString());
                    editor.apply();
                }
            }
        });
    }

    private void setNotesIntoList() throws Exception {
        savedNotes = getContext().getSharedPreferences(NOTES, Context.MODE_PRIVATE);

        Map<String, ?> keys = savedNotes.getAll();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("hh:mm dd:MM");
        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            notes.add(new Note(
                    format.parse(entry.getKey()),
                    entry.getValue().toString()
            ));
        }
    }
}
