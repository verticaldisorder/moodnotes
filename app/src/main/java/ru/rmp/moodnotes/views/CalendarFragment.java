package ru.rmp.moodnotes.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import ru.rmp.moodnotes.R;
import ru.rmp.moodnotes.databinding.CalendarFragmentBinding;

public class CalendarFragment extends Fragment {
    CalendarFragmentBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.calendar_fragment);
        return inflater.inflate(R.layout.calendar_fragment, container, false);
    }


}
