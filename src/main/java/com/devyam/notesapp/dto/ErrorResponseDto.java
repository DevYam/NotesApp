package com.devyam.notesapp.dto;

import java.util.Date;

public record ErrorResponseDto (String message, String description, Date date){
}
