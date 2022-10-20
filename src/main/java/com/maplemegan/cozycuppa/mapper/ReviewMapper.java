package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.ReviewDto;
import com.maplemegan.cozycuppa.entities.Review;

public class ReviewMapper {
	public ReviewDto mapReviewEntToDto(Review review) {
		ReviewDto reviewDto = ReviewDto.builder()
				.reviewId(review.getReviewId()).drinkReviewId(review.getDrinkId())
				.reviewUserId(review.getReviewUserId()).rating(review.getRating())
				.reviewDate(review.getReviewDate()).build();
		return reviewDto;
	}
	
	public static Review mapReviewDtotoEnt(ReviewDto review) {
		return Review.builder()
				.reviewId(review.getReviewId()).drinkReviewId(review.getDrinkReviewId())
				.reviewUserId(review.getReviewUserId()).rating(review.getRating())
				.reviewDate(review.getReviewDate()).build();
	}
}
