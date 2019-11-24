package com.example.unittesting2.repository;

import com.example.unittesting2.persistence.NoteDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NoteRepositoryTest {

    private NoteRepository noteRepository;

    private NoteDao noteDao;

    @BeforeEach
    private void initEach(){
        noteDao = mock(NoteDao.class);
        noteRepository = new NoteRepository(noteDao);
    }

    @Test
    void dummTest() {
        Assertions.assertNotNull(noteDao);
        Assertions.assertNotNull(noteRepository);
    }
}
