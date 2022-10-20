package com.maplemegan.cozycuppa.dto;

import java.time.LocalDateTime;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
	private Integer commentId;
	private Drink drinkCommentId;
	private User commentAuthorId;
	private LocalDateTime commentDate;
	private String commentText;
}
