package com.task_management.task_management.controller;


import com.task_management.task_management.entity.Etudiant;
import com.task_management.task_management.entity.Examen;
import com.task_management.task_management.entity.Note;
import com.task_management.task_management.entity.Note_Key;
import com.task_management.task_management.request.NoteRequest;
import com.task_management.task_management.service.EtudiantService;
import com.task_management.task_management.service.ExamenService;
import com.task_management.task_management.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ExamenService examenService;

    @PostMapping
    public ResponseEntity<Note> createOrUpdateNote(@RequestBody NoteRequest noteRequest) {
        // Fetch Etudiant and Examen entities
        Etudiant etudiant = etudiantService.getEtudiantById(noteRequest.getEtudiantId());
        Examen examen = examenService.getExamenById(noteRequest.getExamenId());

        // Check if any of the fetched entities are null
        if (etudiant == null || examen == null) {
            return ResponseEntity.badRequest().build();
        }

        // Initialize Note_Key and Note entity
        Note_Key noteKey = new Note_Key(noteRequest.getEtudiantId(), noteRequest.getExamenId());
        Note note = new Note();
        note.setId(noteKey);
        note.setValeur(noteRequest.getValeur());
        note.setEtudiant(etudiant);
        note.setExamen(examen);

        // Save the Note entity
        Note createdNote = noteService.createOrUpdateNote(note);
        return ResponseEntity.ok(createdNote);
    }


    @GetMapping("/{etudiantId}/{examenId}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer etudiantId, @PathVariable Integer examenId) {
        Note_Key noteKey = new Note_Key(etudiantId, examenId);
        Optional<Note> note = noteService.getNoteById(noteKey);
        return note.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{etudiantId}/{examenId}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Integer etudiantId, @PathVariable Integer examenId) {
        Note_Key noteKey = new Note_Key(etudiantId, examenId);
        noteService.deleteNoteById(noteKey);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<Note>> getAllNotes() {
        Iterable<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}
