package com.example.unittesting2.ui.note;

import com.example.unittesting2.models.Note;
import com.example.unittesting2.repository.NoteRepository;
import com.example.unittesting2.ui.Resource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static com.example.unittesting2.repository.NoteRepository.NOTE_TITLE_NULL;

public class NoteViewModel extends ViewModel {

    private static final String TAG = "NoteViewModel";

    private final NoteRepository noteRepository;

    private MutableLiveData<Note> note  = new MutableLiveData<>();

    @Inject
    public NoteViewModel(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public LiveData<Resource<Integer>> insertNote() throws Exception{
        return LiveDataReactiveStreams.fromPublisher(
                noteRepository.insertNote(note.getValue())
        );
    }

    public LiveData<Note> observeNote(){
        return note;
    }

    public void setNote(Note note) throws Exception{
        if(note.getTitle() == null || note.getTitle().equals("")){
            throw new Exception(NOTE_TITLE_NULL);
        }
        this.note.setValue(note);
    }
}
