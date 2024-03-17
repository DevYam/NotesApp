package com.devyam.notesapp.controller;

import com.devyam.notesapp.dto.NoteRequestDTO;
import com.devyam.notesapp.dto.NoteResponseDTO;
import com.devyam.notesapp.entity.Note;
import com.devyam.notesapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponseDTO> saveNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable UUID id){
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable UUID id){
        return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable UUID id, @RequestBody NoteRequestDTO noteRequest){
        return new ResponseEntity<>(noteService.updateNote(id, noteRequest), HttpStatus.OK);
    }
}
