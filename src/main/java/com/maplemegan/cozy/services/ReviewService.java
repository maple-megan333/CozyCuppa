package com.maplemegan.cozy.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.maplemegan.cozycuppa.dto.ReviewDto;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.mapper.ReviewMapper;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.ReviewRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;
import com.maplemegan.cozycuppa.util.SecurityUtils;

@Service
public class ReviewService {
	private UserRepository userRepo;
	private DrinkRepository drinkRepo;
	private ReviewRepository reviewRepo;
	
	public ReviewService(UserRepository userRepo, DrinkRepository drinkRepo, ReviewRepository reviewRepo) {
		this.userRepo = userRepo;
		this.drinkRepo = drinkRepo;
		this.reviewRepo = reviewRepo;
	}
	
	
	
	public List<Review> getallReviewsForThisDrink( Integer drinkId) {
		return reviewRepo.findBydrinkReviewId(drinkId);
	}
	
	public Float thisDrinkAverage(Integer drinkId){
		List<Review> drinksReviews = getallReviewsForThisDrink(drinkId);
		if(drinksReviews.isEmpty()) {
			return null;
		}
		Integer count = 0;
		Integer allRevSum= 0;
		for(Review r: drinksReviews) {
			count +=1;
			allRevSum += r.getRating();
		}
		return (float) ((float)allRevSum/(float)count);
	}



	public Boolean userHasReviewed(Integer userId, Integer drinkId) {
		Boolean hasReviewed=false;
		List<Review> drinkReviews = reviewRepo.findBydrinkReviewId(drinkId);
		for(Review r: drinkReviews) {
			if(r.getReviewUserId().getUserId()==userId) {
				hasReviewed=true;
				break;
			}
		}
		
		return hasReviewed;
		}
	
}
