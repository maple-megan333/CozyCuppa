package com.maplemegan.cozycuppa.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maplemegan.cozy.services.CountryServices;
import com.maplemegan.cozy.services.DrinkService;
import com.maplemegan.cozy.services.TryService;
import com.maplemegan.cozy.services.UserServices;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.DrinkType;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.models.SearchModel;
import com.maplemegan.cozycuppa.models.SignUpModel;
import com.maplemegan.cozycuppa.repositories.CountryRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.DrinkTypeRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;
import com.maplemegan.cozycuppa.util.SecurityUtils;

import enums.TryType;

@Controller
@RequestMapping
public class BaseController {
	
	private UserServices userServ;
	private TryService tryServ;
	private UserRepository userRepo;
	private CountryServices countryService;
	private DrinkTypeRepository dTypeRepo;
	private PasswordEncoder passwordEncoder;
	private DrinkRepository drinkRepo;

	public BaseController(UserServices userServ, TryService tryServ, UserRepository userRepo,
			CountryServices countryService, DrinkTypeRepository dTypeRepo, 
			PasswordEncoder passwordEncoder, DrinkRepository drinkRepo) {
		this.userServ = userServ;
		this.tryServ = tryServ;
		this.userRepo = userRepo;
		this.countryService = countryService;
		this.dTypeRepo = dTypeRepo;
		this.passwordEncoder = passwordEncoder;
		this.drinkRepo = drinkRepo;
	}
	
	@RequestMapping({"/login"})   // either type '/' or index
	public String showlogin()
	{
		return "login";
	}
	
	@GetMapping("/findYourCozyCup")
	public String drinkPage(Model model) {
		List<DrinkType> types = dTypeRepo.findAll();
		model.addAttribute("types", types);
		
		List<Country> countriesWithDrinks = countryService.currentlyHasDrinks();
		StringBuilder sb = new StringBuilder();
		for (Country country : countriesWithDrinks) {
			sb.append(country.getCountryCode() + ",");
		}
		String countryListString = sb.toString();
		if(countryListString.length() > 0) countryListString = countryListString.substring(0, countryListString.length() -1);
		else countryListString = "";
		model.addAttribute("countryListString", countryListString);
		model.addAttribute("countryList", countriesWithDrinks);
		model.addAttribute("searchModel", new SearchModel());
		
		List<Drink> drinks = drinkRepo.findAll();
		model.addAttribute("drinks", drinks);
		
		return "findYourCozyCup";
	}
	
	@PostMapping("/findYourCozyCup")
	public String drinkPage(Model model, @ModelAttribute SearchModel searchModel) {
		model.addAttribute("searchModel", searchModel);
		List<DrinkType> types = dTypeRepo.findAll();
		model.addAttribute("types", types);
		
		List<Country> countriesWithDrinks = countryService.currentlyHasDrinks();
		StringBuilder sb = new StringBuilder();
		for (Country country : countriesWithDrinks) {
			sb.append(country.getCountryCode() + ",");
		}
		String countryListString = sb.toString();
		if(countryListString.length() > 0) countryListString = countryListString.substring(0, countryListString.length() -1);
		else countryListString = "";
		model.addAttribute("countryListString", countryListString);
		model.addAttribute("countryList", countriesWithDrinks);
		model.addAttribute("searchModel", new SearchModel());
		
		// Filter Search
		List<Integer> typeIds = new ArrayList<Integer>();
		for(String s : searchModel.getTypeIds()) typeIds.add(Integer.valueOf(s));
		List<Drink> drinks = drinkRepo.findForSearch(searchModel.getCountryId(), typeIds);
		model.addAttribute("drinks", drinks);
		
		return "findYourCozyCup";
	}
	
	@GetMapping("/userLanding")
	public String loginSuccess(Model model) {
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
			
			User user = userRepo.findByuserName(userName);
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
			return "userLanding";
	}
	
	@GetMapping({"/signUp"})   // either type '/' or index
	public String showSignUp(Model model)
	{
		List<Country> countries = countryService.findAll();
		model.addAttribute("countries", countries);
		model.addAttribute("signUp", new SignUpModel());
		return "signUp";
	}
	
	@PostMapping({"/signUp"})   // either type '/' or index
	public String showSignUp(Model model, @ModelAttribute SignUpModel signUp, @RequestParam("image") MultipartFile file)
	{
		List<Country> countries = countryService.findAll();
		model.addAttribute("countries", countries);
		model.addAttribute("signUp", signUp);
		
		User newUser = new User();
		newUser.setUserName(signUp.getUserName());
		newUser.setPassword(passwordEncoder.encode(signUp.getPassword()));
		newUser.setEmail(signUp.getEmail());
		newUser.setFirstName(signUp.getFirstName());
		newUser.setLastName(signUp.getLastName());
		newUser.setUserDOB(new java.sql.Date(signUp.getUserDOB().getTime()));
		newUser.setBio(signUp.getUserBio());
		Country country = countryService.findById(signUp.getCountryId());
		newUser.setUserCountry(country);
		newUser.setActive(true);
		newUser.setUserCreateDate(LocalDateTime.now());

		newUser = userRepo.save(newUser);
		
		// Save Image
		String rootPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\media\\Users\\";
		String webPath = "/media/users/";
		String originalfileName = file.getOriginalFilename();
		String fileExtension = "";
		if(originalfileName.indexOf(".") > 0 && originalfileName.lastIndexOf(".") < originalfileName.length() - 1) 
		{
			fileExtension = originalfileName.substring(originalfileName.lastIndexOf(".") + 1);
		}
		
		List<String> validFileExtensions = Arrays.asList("jpg","jpeg","png","gif","bmp");
		if(validFileExtensions.contains(fileExtension)) {
			String newFileName = newUser.getUserId().toString() + "." + fileExtension;
			Path fileNameAndPath = Paths.get(rootPath, newFileName);
	        try {
				Files.write(fileNameAndPath, file.getBytes());
				
				newUser.setUserprofilePhoto(webPath + newFileName);
				userRepo.save(newUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/userLanding";
	}

	@RequestMapping({"/index"})   // either type '/' or index
	   public String showHome()
	   {
	       return "index";
	   }
	
	
	@GetMapping("/loginFailure")
	public String loginFailure() {
		return "loginFailure";
	}
	
	
	
	
}
