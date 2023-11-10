package com.example.vijayiAssessment.Service;

import com.example.vijayiAssessment.DTO.ResponseComment;
import com.example.vijayiAssessment.DTO.CommentDto;
import com.example.vijayiAssessment.Model.Commentdb;
import com.example.vijayiAssessment.Model.Users;
import com.example.vijayiAssessment.Repo.CommentRepo;
import com.example.vijayiAssessment.Repo.UsersRepo;
import com.example.vijayiAssessment.advice.CommentNotFoundException;
import com.example.vijayiAssessment.advice.InvalidUserException;
import com.example.vijayiAssessment.advice.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    CommentRepo commentRepo;
    private static Timestamp getDate() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    @Override
    public List<CommentDto> getComment(String userName) {
        Optional<Users> optionalUsers = usersRepo.findByUsername(userName);

        if (optionalUsers.isEmpty()) {
            throw new UserNotFoundException("Invalid user", "404");
        }

        List<Commentdb> list = commentRepo.findAllByCommentTo(optionalUsers.get());

        if (list.isEmpty()) {
            throw new CommentNotFoundException("No comments found", "404");
        }

        List<CommentDto> commentDto = new ArrayList<>();

        list.forEach(o -> {
            CommentDto cDto = new CommentDto();
            cDto.setCommentTo(o.getCommentTo().getUsername());
            cDto.setCommentFrom(o.getCommentFrom().getUsername());
            cDto.setCommentDateTime(o.getCommentDateTime());
            cDto.setMessage(o.getMessage());
            commentDto.add(cDto);
        });

        return commentDto;

    }

    @Override @Transactional
    public ResponseComment addComment(CommentDto commentDto) {
        if (usersRepo.findByUsername(commentDto.getCommentFrom()).isEmpty()) {
            throw new UserNotFoundException(commentDto.getCommentFrom() + " Not found", "404");
        }

        if (usersRepo.findByUsername(commentDto.getCommentTo()).isEmpty()) {
            if (!isValidUserName(commentDto.getCommentTo())) {
                throw new InvalidUserException("Invalid Request", "");
            }

            Users users = new Users();
            users.setUsername(commentDto.getCommentTo());
            usersRepo.save(users);

        }


        Commentdb commentdb = new Commentdb();
        commentdb.setMessage(commentDto.getMessage());
        commentdb.setCommentFrom(usersRepo.findByUsername(commentDto.getCommentFrom()).get());
        commentdb.setCommentTo(usersRepo.findByUsername(commentDto.getCommentTo()).get());
        commentdb.setCommentDateTime(getDate());

        commentRepo.save(commentdb);
        commentDto.setCommentDateTime(getDate());

        ResponseComment comment = new ResponseComment();
        comment.setCommentDto(commentDto);
        comment.setResponse("Comment added successfully");

        return comment;
    }

    private Boolean isValidUserName(String userName) {
        if (userName.isEmpty()) {
            return false;
        }

            Pattern pattern = Pattern.compile("[@_!#$%^&*()<>?/|}{~:]");
        Matcher matcher = pattern.matcher(userName);
        if (matcher.find()) {
            return false;
        }

//        if (usersRepo.findByUsername(userName).isPresent()) {
//            return false;
//        }

        return true;
    }
}
