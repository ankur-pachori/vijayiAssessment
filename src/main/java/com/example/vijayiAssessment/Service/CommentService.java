package com.example.vijayiAssessment.Service;

import com.example.vijayiAssessment.DTO.ResponseComment;
import com.example.vijayiAssessment.DTO.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<CommentDto> getComment(String userName);
    ResponseComment addComment(CommentDto commentDto);
}
