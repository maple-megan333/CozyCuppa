package com.maplemegan.cozycuppa.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Reviews")
public class Review {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Review_Id")
	private Integer reviewId;
	
	@ManyToOne
    @JoinColumn(name = "Review_Drink", referencedColumnName = "Drink_Id")
	private Drink drinkReviewId;
	
	@ManyToOne
    @JoinColumn(name = "Review_Author", referencedColumnName = "User_Id")
	private User reviewUserId;
	
	@Column(name="Rating")
	private Integer rating;
	
	@CreationTimestamp
	@Column(name="Review_Date")
	private LocalDateTime reviewDate;
	
	public Review() {
		
	}
	
	//getters and setters for reviewId
	public void setReviewId(Integer id) {
		this.reviewId=id;
	}
	public Integer getReviewId() {
		return this.reviewId;
	}
	
	// getters and setters for drinkId
	public void setDrinkId(Drink id) {
		this.drinkReviewId=id;
	}
	public Drink getDrinkId() {
		return this.drinkReviewId;
	}

	//getters and setters for reviewUserId;
	public void setReviewUserId(User id) {
		this.reviewUserId=id;
	}
	public User getReviewUserId() {
		return this.reviewUserId;
	}
	//getters and setters for rating
	public void setRating(Integer rating) {
		this.rating=rating;
	}
	public Integer getRating() {
		return this.rating;
	}
	//getters and setters for reviewDate
	public void setReviewDate(LocalDateTime localDateTime) {
		this.reviewDate=localDateTime;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", drinkId=" + drinkReviewId + ", reviewUserId=" + reviewUserId + ", rating="
				+ rating + ", reviewDate=" + reviewDate + "]";
	}
	
	
	/*
	 * Additional class attributes for future features
	 * private String reviewText;
	 * private String reviewImg;
	 * private Boolean reviewRead;
	 */
	
}
