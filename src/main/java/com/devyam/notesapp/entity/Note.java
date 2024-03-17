package com.devyam.notesapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        private String title;
        String body;

        @Temporal(TemporalType.TIMESTAMP)
        @CreationTimestamp
        private Date createdAt;

        @Temporal(TemporalType.TIMESTAMP)
        @UpdateTimestamp
        private Date updatedAt;


}
