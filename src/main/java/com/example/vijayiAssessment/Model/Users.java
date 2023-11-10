package com.example.vijayiAssessment.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(name = "Users_seq",sequenceName = "Users_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Users_seq")
    private Long userId;

    private String username;

}
