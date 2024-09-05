package com.task_management.task_management.service;

import com.task_management.task_management.entity.Note;
import com.task_management.task_management.entity.Note_Key;
import com.task_management.task_management.repo.NoteRepository;
import com.task_management.task_management.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImplementation implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getNoteById(Note_Key id) {
        return noteRepository.findById(id);
    }

    @Override
    public void deleteNoteById(Note_Key id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}