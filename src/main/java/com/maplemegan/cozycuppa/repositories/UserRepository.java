package com.maplemegan.cozycuppa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maplemegan.cozycuppa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByemail(String email);
	User findByuserName(String userName);
	List<User> findByuserCountryId(Integer userCountryId);
}
