package com.example.unittesting2.ui.noteList;

import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.unittesting2.R;
import com.example.unittesting2.repository.NoteRepository;

import javax.inject.Inject;

public class NoteListActivity extends DaggerAppCompatActivity {

    private static final String TAG = "NotesListActivity";

    @Inject
    NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Log.d(TAG, "onCreate: " + noteRepository);
    }
}
