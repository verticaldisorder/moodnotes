package ru.rmp.moodnotes.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ru.rmp.moodnotes.R;
import ru.rmp.moodnotes.databinding.DiaryFragmentBinding;

public class DiaryFragment extends Fragment {
    DiaryFragmentBinding binding;
    SharedPreferences diary;
    private final static String DIARY = "diary";
    private @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd:MM");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.diary_fragment);
        return inflater.inflate(R.layout.diary_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setTextChangedListener();

        binding.diaryDateTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(diary.contains(format.format(new Date()))) {
                    setDiaryNoteIntoTextView();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setTextChangedListener();
            }
        });
    }

    private void setTextChangedListener() {
        diary = getContext().getSharedPreferences(DIARY, Context.MODE_PRIVATE);

        Map<String, ?> keys = diary.getAll();

        SharedPreferences.Editor editor = diary.edit();
        editor.putString(new Date().toString(), binding.diaryTextTextview.getText().toString());
        editor.apply();

    }

    private void setDiaryNoteIntoTextView() {
        diary = getContext().getSharedPreferences(DIARY, Context.MODE_PRIVATE);

        Map<String, ?> keys = diary.getAll();

        if(keys.containsKey(format.format(new Date()))) {
            binding.diaryDateTextview.setText(format.format(new Date()));
            binding.diaryTextTextview.setText(keys.get(format.format(new Date())).toString());
        }
    }
}
