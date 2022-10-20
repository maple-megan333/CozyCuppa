package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.UserDto;
import com.maplemegan.cozycuppa.entities.User;

public class UserMapper {
	public UserDto mapuserToDto(User user) {
		UserDto userdto = UserDto.builder()
				.userId(user.getUserId()).email(user.getEmail())
				.password(user.getPassword()).userName(user.getUserName())
				.userCountryId(user.getUserCountry()).userDOB(user.getUserDOB())
				.profilePhoto(user.getUserpProfilePhoto()).bio(user.getBio())
				.userCreateDate(user.getUserCreateDate()).firstName(user.getFirstName())
				.lastName(user.getLastName()).active(user.getActive()).follows(user.getFollows())
				.followers(user.getFollowers()).userMadeDrinks(user.getUserMadeDrinks())
				.usersTries(user.getUserTries()).usersComments(user.getUserComments())
				.userReviews(user.getUserReviews()).build();
		return userdto;
		
	}
	public static User mapuserDtotoEnt(UserDto user) {
		return User.builder()
				.userId(user.getUserId()).email(user.getEmail())
				.password(user.getPassword()).userName(user.getUserName())
				.userCountryId(user.getUserCountryId()).userDOB(user.getUserDOB())
				.profilePhoto(user.getProfilePhoto()).bio(user.getBio())
				.userCreateDate(user.getUserCreateDate()).firstName(user.getFirstName())
				.lastName(user.getLastName()).active(user.getActive()).follows(user.getFollows())
				.followers(user.getFollowers()).userMadeDrinks(user.getUserMadeDrinks())
				.usersTries(user.getUsersTries()).usersComments(user.getUsersComments())
				.userReviews(user.getUserReviews()).build();
	}
}
