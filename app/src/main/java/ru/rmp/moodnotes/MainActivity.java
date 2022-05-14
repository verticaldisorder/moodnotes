package ru.rmp.moodnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.rmp.moodnotes.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_main_activity, MainFragment.class, null)
                .commit();
    }
}