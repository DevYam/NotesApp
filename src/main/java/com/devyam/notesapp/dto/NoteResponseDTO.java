package com.devyam.notesapp.dto;

import java.util.Date;
import java.util.UUID;

public record NoteResponseDTO(UUID id, String title, String body, Date createdAt, Date updatedAt) {
}
