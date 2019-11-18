package com.example.unittesting2.persistence;

import com.example.unittesting2.models.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Single;

@Dao
public interface NoteDao {

    @Insert
    Single<Long> insertNote(Note note) throws Exception;

    @Query("SELECT * FROM note")
    LiveData<List<Note>> getNotes();

    @Delete
    Single<Integer> deleteNote(Note note) throws Exception;

    @Update
    Single<Integer> updateNote(Note note) throws Exception;

}
