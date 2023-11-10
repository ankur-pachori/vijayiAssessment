package com.example.vijayiAssessment.Repo;

import com.example.vijayiAssessment.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername (String userName);
}
