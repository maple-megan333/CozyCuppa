package com.maplemegan.cozycuppa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;


public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findBydrinkCommentId(Integer drinkCommentId);
	List<Comment> findBycommentAuthorId(Integer commentAuthorId);
}
