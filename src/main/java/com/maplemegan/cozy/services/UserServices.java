package com.maplemegan.cozy.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.UserDto;
import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.repositories.CommentRepository;
import com.maplemegan.cozycuppa.repositories.CountryRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.ReviewRepository;
import com.maplemegan.cozycuppa.repositories.TryRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;

@Service
public class UserServices {
	private UserRepository userRepo;
	private DrinkRepository drinkRepo;
	private CountryRepository countryRepo;
	private TryRepository tryRepo;
	private CommentRepository commentRepo;
	private ReviewRepository reviewRepo;
	private PasswordEncoder passwordEncoder;
	
	public UserServices(UserRepository userRepo, DrinkRepository drinkRepo, CountryRepository countryRepo,
			TryRepository tryRepo, CommentRepository commentRepo, ReviewRepository reviewRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.drinkRepo = drinkRepo;
		this.countryRepo = countryRepo;
		this.tryRepo = tryRepo;
		this.commentRepo = commentRepo;
		this.reviewRepo = reviewRepo;
		this.passwordEncoder=passwordEncoder;
	}
	
	public void followUser(User userOne, User userTwo) {
		Set<User> toFollow = userOne.getFollows();
		Set<User> toFollowedBy = userTwo.getFollowers();
		
		toFollow.add(userTwo);
		toFollowedBy.add(userOne);
		userOne.setFollows(toFollow);
		userTwo.setFollowers(toFollowedBy);
		userRepo.save(userOne);
		userRepo.save(userTwo);
	}
	
	
	public boolean alreadyassigned(Integer userId, Set<User> follows) {
		boolean assigned=false;
		
		for(User u: follows){
			if(u.getUserId()==userId) {
				assigned=true;
				break;
			}
		}
		return assigned;
	}
	
	public void unfollow(User userOne, User userTwo) {
		Set<User> toFollow = userOne.getFollows();
		Set<User> toFollowedBy = userTwo.getFollowers();
		
		toFollow.remove(userTwo);
		toFollowedBy.remove(userOne);
		userOne.setFollows(toFollow);
		userTwo.setFollowers(toFollowedBy);
		userRepo.save(userOne);
		userRepo.save(userTwo);
	}
	
	public void saveUser(UserDto user) {
		User newUser = new User();
		newUser.setUserId(user.getUserId());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setUserName(user.getUserName());
		newUser.setUserCountry(user.getUserCountryId());
		newUser.setUserDOB(user.getUserDOB());
		newUser.setUserprofilePhoto(user.getProfilePhoto());
		newUser.setBio(user.getBio());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setActive(true);
		newUser.setFollows(user.getFollows());
		newUser.setFollowers(user.getFollowers());
		newUser.setUserMadeDrinks(user.getUserMadeDrinks());
		newUser.setUserTries(user.getUsersTries());
		newUser.setUserComments(user.getUsersComments());
		newUser.setUserReviews(user.getUserReviews());
		userRepo.save(newUser);
	}
	
	public User findByid(Integer Id) {
		return userRepo.findById(Id).get();
	}
	
	public User findByuserName(String username) {
		return userRepo.findByuserName(username);
	}
	
}
