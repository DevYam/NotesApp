package com.devyam.notesapp.service;

import com.devyam.notesapp.dto.NoteRequestDTO;
import com.devyam.notesapp.dto.NoteResponseDTO;
import com.devyam.notesapp.entity.Note;
import com.devyam.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteResponseDTO saveNote(Note note){
        Note savedNote = noteRepository.save(note);
        return new NoteResponseDTO(savedNote.getId(), savedNote.getTitle(), savedNote.getBody(), savedNote.getCreatedAt(), savedNote.getUpdatedAt());
    }

    public List<NoteResponseDTO> getAllNotes(){
        List<Note> allNotes = noteRepository.findAll();
        return allNotes.stream().map(note -> new NoteResponseDTO(note.getId(), note.getTitle(), note.getBody(), note.getCreatedAt(), note.getUpdatedAt())).toList();
    }


    public NoteResponseDTO getNoteById(UUID id){
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()){
            Note note = optionalNote.get();
            return new NoteResponseDTO(note.getId(), note.getTitle(), note.getBody(), note.getCreatedAt(), note.getUpdatedAt());
        } else {
            throw new RuntimeException("Note with id: " + id + " is not found");
        }
    }


    public String deleteNote(UUID id){
        noteRepository.deleteById(id);
        return "Note with Id: " + id + " deleted successfully";

    }


    public NoteResponseDTO updateNote(UUID id, NoteRequestDTO noteRequest){
            Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note with id: " + id + " is not found"));
            note.setTitle(noteRequest.title());
            note.setBody(noteRequest.body());
            noteRepository.save(note);
            return new NoteResponseDTO(note.getId(), note.getTitle(), note.getBody(), note.getCreatedAt(), note.getUpdatedAt());

    }
}
