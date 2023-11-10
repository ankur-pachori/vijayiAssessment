package com.example.vijayiAssessment.DTO;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDto {
    private String message;
    private Timestamp commentDateTime;
    private String commentFrom;
    private String commentTo;
}
