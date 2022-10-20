package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.CommentDto;
import com.maplemegan.cozycuppa.entities.Comment;

public class CommentMapper {
	
	public CommentDto commentEntToDto(Comment comment) {
		CommentDto cdto= CommentDto.builder()
				.commentId(comment.getCommentId()).drinkCommentId(comment.getDrinkId())
				.commentAuthorId(comment.getCommentAuthorId()).commentAuthorId(comment.getCommentAuthorId())
				.commentText(comment.getCommentText()).build();
		return cdto;
	}
	
	public static Comment commentDtotoEnt(CommentDto comment) {
		return Comment.builder()
				.commentId(comment.getCommentId()).drinkCommentId(comment.getDrinkCommentId())
				.commentAuthorId(comment.getCommentAuthorId()).commentAuthorId(comment.getCommentAuthorId())
				.commentText(comment.getCommentText()).build();
	}
}
