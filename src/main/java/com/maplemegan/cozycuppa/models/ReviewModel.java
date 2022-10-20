package com.maplemegan.cozycuppa.models;

public class ReviewModel {
	private Integer rating;
	private Integer drinkReviewId;
	private Integer reviewUserId;
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getDrinkReviewId() {
		return drinkReviewId;
	}
	public void setDrinkReviewId(Integer drinkReviewId) {
		this.drinkReviewId = drinkReviewId;
	}
	public Integer getReviewUserId() {
		return reviewUserId;
	}
	public void setReviewUserId(Integer reviewUserId) {
		this.reviewUserId = reviewUserId;
	}
	
}
