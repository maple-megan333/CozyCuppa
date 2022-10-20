package com.maplemegan.cozy.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.CommentDto;
import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.mapper.CommentMapper;
import com.maplemegan.cozycuppa.repositories.CommentRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;
import com.maplemegan.cozycuppa.util.SecurityUtils;


@Service
public class CommentService {
	private UserRepository userRepo;
	private DrinkRepository drinkRepo;
	private CommentRepository commentRepo;

	public Comment createNewComment(Drink drinkId, CommentDto commentdto) {
		String userName = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepo.findByuserName(userName);
		Comment newComment = CommentMapper.commentDtotoEnt(commentdto);
		newComment.setCommentAuthorId(user);
		newComment.setDrinkId(drinkId);
		newComment.setCommentDate(LocalDateTime.now());
		return commentRepo.save(newComment);
	}
	
	public void deleteComment(Integer commentId) {
		commentRepo.deleteById(commentId);
	}
	
	public void canDelete(Integer commentId) {
		String userName = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepo.findByuserName(userName);
		Comment thisComment = commentRepo.findById(commentId).get();
		if(user.getUserId()==thisComment.getCommentAuthorId().getUserId()) {
			deleteComment(commentId);
		}
	}
	
	public List<Comment> getCommentsByDrinkId(Integer drinkId){
		return commentRepo.findBydrinkCommentId(drinkId);
	}
}
