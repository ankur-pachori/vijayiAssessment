package com.example.vijayiAssessment.Controller;

import com.example.vijayiAssessment.DTO.ResponseComment;
import com.example.vijayiAssessment.DTO.CommentDto;
import com.example.vijayiAssessment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentsController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<?> getComments(@RequestParam (name = "userName") String userName){
        List<CommentDto> response =commentService.getComment(userName);
        return new ResponseEntity<List<CommentDto>>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addComments(@RequestBody CommentDto commentDto){
        ResponseComment dto =commentService.addComment(commentDto);
        return new ResponseEntity<ResponseComment>(dto,HttpStatus.OK);
    }
}
