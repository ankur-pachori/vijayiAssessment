package com.example.vijayiAssessment.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.annotation.Target;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table
public class Commentdb {

    @Id
    @SequenceGenerator(name = "CommentDb_seq",sequenceName = "CommentDb_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CommentDb_seq")
    private Long commentId;
    private Timestamp commentDateTime;
    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users commentFrom;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users commentTo;
}
