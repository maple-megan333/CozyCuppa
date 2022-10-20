package com.maplemegan.cozycuppa.controllers;

import java.io.IOException;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.maplemegan.cozy.services.CountryServices;
import com.maplemegan.cozy.services.TryService;
import com.maplemegan.cozy.services.UserServices;
import com.maplemegan.cozycuppa.dto.UserDto;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.repositories.UserRepository;

import enums.TryType;


@Controller
@RequestMapping("/users")
public class UserController {
	private UserServices userServ;
	private UserRepository userRepo;
	private TryService tryServ;
	private CountryServices countryServ;
	
	public UserController(UserServices userServ, UserRepository userRepo, TryService tryServ,
			CountryServices countryServ) {
		this.userServ = userServ;
		this.userRepo = userRepo;
		this.tryServ = tryServ;
		this.countryServ = countryServ;
	}

	@GetMapping("/{userId}")
	public String viewUserProfile(@PathVariable("userId") Integer userId, Model model){
		User user = userServ.findByid(userId);
		Country userCountry= user.getUserCountry();
		Set<Drink> drinks = user.getUserMadeDrinks();
		Set<User> following = user.getFollows();
		Set<User> followedBy = user.getFollowers();
		List<Drink> wantsToTry = tryServ.getDrinksFromTryList(user.getUserTries(), TryType.TOTRY);
		List<Drink> hasTried = tryServ.getDrinksFromTryList(user.getUserTries(), TryType.TOTRY);
		model.addAttribute("user", user);
		model.addAttribute("userCountry", userCountry);
		model.addAttribute("tried", hasTried);
		model.addAttribute("toTry", wantsToTry);
		model.addAttribute("followedBy", followedBy);
		model.addAttribute("following", following);
		model.addAttribute("drinks", drinks);
		return "profilePage";
	}
	
	@GetMapping("/signUp")
	public String signUpform(Model model) {
		User user = new User();
		List<Country> countries = countryServ.findAll();
		Set<Drink> drinks = user.getUserMadeDrinks();
		Set<User> following = user.getFollows();
		Set<User> followedBy = user.getFollowers();
		List<Drink> wantsToTry = tryServ.getDrinksFromTryList(user.getUserTries(), TryType.TOTRY);
		List<Drink> hasTried = tryServ.getDrinksFromTryList(user.getUserTries(), TryType.TOTRY);
		model.addAttribute("user", user);
		model.addAttribute("countries", countries);
		model.addAttribute("tried", hasTried);
		model.addAttribute("toTry", wantsToTry);
		model.addAttribute("followedBy", followedBy);
		model.addAttribute("following", following);
		model.addAttribute("drinks", drinks);
		return "signUp";
	}
}
