package com.maplemegan.cozycuppa.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	private Integer userId;
	private String email;
	private String password;
	private String userName;
	private Country userCountryId;
	private Date userDOB;
	private String profilePhoto;
	private String bio;
	private LocalDateTime userCreateDate;
	private String firstName;
	private String lastName;
	private Boolean active;
	private Set<User> follows;
	private Set<User> followers;
	private Set<Drink> userMadeDrinks;
	private Set<Try> usersTries;
	private Set<Comment> usersComments;
	private Set<Review> userReviews;


}
