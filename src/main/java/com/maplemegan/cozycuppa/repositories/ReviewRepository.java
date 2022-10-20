package com.maplemegan.cozycuppa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.maplemegan.cozycuppa.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query( value = "select * from reviews r " +
            "where r.review_drink = :drinkReviewId", 
            nativeQuery = true)
	List<Review> findBydrinkReviewId(@Param("drinkReviewId")Integer drinkReviewId);
}
