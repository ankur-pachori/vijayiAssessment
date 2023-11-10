package com.example.vijayiAssessment.Repo;

import com.example.vijayiAssessment.Model.Commentdb;
import com.example.vijayiAssessment.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Commentdb,Long> {
    List<Commentdb> findAllByCommentTo(Users users);

}
