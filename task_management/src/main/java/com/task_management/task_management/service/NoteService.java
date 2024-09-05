package com.task_management.task_management.service;

import com.task_management.task_management.entity.Note;
import com.task_management.task_management.entity.Note_Key;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    Note createOrUpdateNote(Note note);
    Optional<Note> getNoteById(Note_Key id);
    void deleteNoteById(Note_Key id);
    Iterable<Note> getAllNotes();


}
