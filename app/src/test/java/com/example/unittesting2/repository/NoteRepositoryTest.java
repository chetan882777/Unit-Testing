package com.example.unittesting2.repository;

import com.example.unittesting2.models.Note;
import com.example.unittesting2.persistence.NoteDao;
import com.example.unittesting2.ui.Resource;
import com.example.unittesting2.util.TestUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import io.reactivex.Single;

import static com.example.unittesting2.repository.NoteRepository.INSERT_FAILURE;
import static com.example.unittesting2.repository.NoteRepository.INSERT_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NoteRepositoryTest {

    private NoteRepository noteRepository;

    private NoteDao noteDao;

    private static final Note NOTE1 = new Note(TestUtil.TEST_NOTE_1);

    @BeforeEach
    private void initEach(){
        noteDao = mock(NoteDao.class);
        noteRepository = new NoteRepository(noteDao);
    }
 /*
        insert note
        verify the correct method is called
        confirm observer is triggered
        confirm new rows inserted
     */


    @Test
        void insertNote_returnRow () throws Exception {
            // Arrange
            final long insertedRow = 1L;
            final Single<Long> returnedData = Single.just(insertedRow);

            when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);

            //Act
            final Resource<Integer> returnedValue = noteRepository.insertNote(NOTE1).blockingFirst();

           // Assert
            verify(noteDao).insertNote(any(Note.class));
            verifyNoMoreInteractions(noteDao);

            System.out.println("Returned Value: " + returnedValue.data );

            assertEquals(Resource.success(1, INSERT_SUCCESS), returnedValue);
        }
    /*
        Insert note
        Failure (return -1)
     */

        @Test
        void insertNote_returnFailure () throws Exception {
            // Arrange
            final Long failedInsert = -1L;
            final Single<Long> returnedData = Single.just(failedInsert);
            when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);


            // Act
            final Resource<Integer> returnedValue = noteRepository.insertNote(NOTE1).blockingFirst();


            // Assert
            verify(noteDao).insertNote(any(Note.class));
            verifyNoMoreInteractions(noteDao);

            assertEquals(Resource.error(null, INSERT_FAILURE), returnedValue);
        }


    /*
        insert note
        null title
        confirm throw exception
     */

        @Test
        void insertNote_nullTitle_throwException () throws Exception {

            assertThrows(Exception.class, new Executable() {
                @Override
                public void execute() throws Throwable {
                    final Note note  = new Note(TestUtil.TEST_NOTE_1);
                    note.setTitle(null);
                    noteRepository.insertNote(note);
                }
            });
        }
}
