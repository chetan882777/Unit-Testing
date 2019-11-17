package com.example.unittesting2.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteTest {

    public static final String TIMESTAMP_1 = "11-2019";
    public static final String TIMESTAMP_2 = "10-2019";

    /*
    Compare two equal Notes
     */
    @Test
    void isNoteEquals_IdenticalNotes_returnsTrue() throws Exception {
        Note note1 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);
        Note note2 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);

        Assertions.assertEquals(note1, note2);
        System.out.println("Notes are equal");
    }


    /*
    Compare Notes with 2 different ids
     */
    @Test
    void isNoteEquals_differentIds_returnsFalse() throws Exception {
        Note note1 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);
        Note note2 = new Note(2, "Note 1", "This is note 1", TIMESTAMP_1);

        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are not equal as they have different Ids");
    }


    /*
    Compare notes with 2 different titles
     */

    @Test
    void isNoteEquals_differentTitles_returnsFalse() throws Exception {
        Note note1 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);
        Note note2 = new Note(1, "Note 2", "This is note 1", TIMESTAMP_1);

        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are not equal as they have different Titles");
    }

    /*
    Compare notes with 2 different content
     */
    @Test
    void isNoteEquals_differentContent_returnsFalse() throws Exception {
        Note note1 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);
        Note note2 = new Note(1, "Note 1", "This is note 2", TIMESTAMP_1);

        Assertions.assertNotEquals(note1, note2);
        System.out.println("Notes are equal as they have different Content");
    }

    /*
    Compare notes with 2 different time stamp
     */
    @Test
    void isNoteEquals_differentTimeStamp_returnsTrue() throws Exception {
        Note note1 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_1);
        Note note2 = new Note(1, "Note 1", "This is note 1", TIMESTAMP_2);

        Assertions.assertEquals(note1, note2);
        System.out.println("Notes are equal but they have different Content");
    }
}
