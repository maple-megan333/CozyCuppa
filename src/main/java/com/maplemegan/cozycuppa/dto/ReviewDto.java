package com.maplemegan.cozycuppa.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
	private Integer reviewId;
	private Drink drinkReviewId;
	private User reviewUserId;
	private Integer rating;
	private LocalDateTime reviewDate;
}
