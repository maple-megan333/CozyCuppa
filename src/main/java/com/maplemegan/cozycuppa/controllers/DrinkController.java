package com.maplemegan.cozycuppa.controllers;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import com.maplemegan.cozy.services.CountryServices;
import com.maplemegan.cozy.services.DrinkService;
import com.maplemegan.cozy.services.IngredientServices;
import com.maplemegan.cozy.services.InstructionService;
import com.maplemegan.cozy.services.ReviewService;
import com.maplemegan.cozy.services.TryService;
import com.maplemegan.cozy.services.UserServices;
import com.maplemegan.cozycuppa.dto.DrinkDto;
import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.DrinkType;
import com.maplemegan.cozycuppa.entities.Ingredient;
import com.maplemegan.cozycuppa.entities.Instruction;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.models.AddDrinkModel;
import com.maplemegan.cozycuppa.models.ReviewModel;
import com.maplemegan.cozycuppa.repositories.CommentRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.DrinkTypeRepository;
import com.maplemegan.cozycuppa.repositories.IngredientRepository;
import com.maplemegan.cozycuppa.repositories.InstructionRepository;
import com.maplemegan.cozycuppa.repositories.ReviewRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;

import enums.TryType;

@Controller
@RequestMapping("/drinks")
public class DrinkController {
	
	@Autowired
	private DrinkService drinkService;
	@Autowired
	private ReviewService RevServ;
	@Autowired
	private TryService tryService;
	@Autowired
	private UserServices userServ;
	@Autowired
	private InstructionService instrServ;
	@Autowired
	private IngredientServices ingredServ;
	@Autowired
	private CountryServices countryServ;
	@Autowired
	private DrinkTypeRepository dTypeRepo;
	@Autowired 
	private CommentRepository commentRepo;
	@Autowired 
	private DrinkRepository drinkRepo;
	@Autowired 
	private IngredientRepository ingredientRepo;
	@Autowired 
	private InstructionRepository instructionRepo;
	
	private ReviewRepository revRepo;
	

	


	/*@GetMapping("/{userId}")
	public String getListofDrinksbyAuthor(@PathVariable Integer authorId, Model model){
		List<DrinkDto> authorDrinks=drinkService.findAllPostsById(authorId);
		model.addAttribute("authorDrinks", authorDrinks);
		return "/userId";
	}*/
	
	public DrinkController(DrinkService drinkService, ReviewService revServ, TryService tryService,
			UserServices userServ, InstructionService instrServ, IngredientServices ingredServ,
			CountryServices countryServ, DrinkTypeRepository dTypeRepo, CommentRepository commentRepo,
			DrinkRepository drinkRepo,IngredientRepository ingredientRepo,InstructionRepository instructionRepo,
			ReviewRepository revRepo) {

		this.drinkService = drinkService;
		this.revRepo=revRepo;
		this.tryService = tryService;
		this.userServ = userServ;
		this.instrServ = instrServ;
		this.ingredServ = ingredServ;
		this.countryServ = countryServ;
		this.dTypeRepo = dTypeRepo;
		this.commentRepo = commentRepo;
		this.drinkRepo = drinkRepo;
		this.ingredientRepo = ingredientRepo;
		this.instructionRepo = instructionRepo;
		this.RevServ=RevServ;
	}

	@GetMapping("/{drinkId}")
	public String veiwDrink(@PathVariable("drinkId") Integer drinkId, Model model) {
		Drink drink = drinkService.findByDrinkId(drinkId);
		User user = drink.getAuthorId();
		Country country = drink.getDrinkCountry();
		List<User> wantsToTry = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.TOTRY);
		List<User> hasTried = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.HASTRIED);
		Set<Comment> drinkComments = drink.getDrinkComments();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = userServ.findByuserName(userName);
		Float drinkAvg = RevServ.thisDrinkAverage(drinkId);
		List<Review> thisDrinksRevs = RevServ.getallReviewsForThisDrink(drinkId);
		ReviewModel newReview = new ReviewModel();
		Comment newComment = new Comment();
		model.addAttribute("drinkId", drinkId);
		model.addAttribute("thisUser", thisUser);
		model.addAttribute("author", user);
		model.addAttribute("country", country);
		model.addAttribute("wants", wantsToTry);
		model.addAttribute("has", hasTried);
		model.addAttribute("comments", drinkComments);	
		model.addAttribute("drink", drink);
		model.addAttribute("newComment", newComment);
		model.addAttribute("reviewMods", newReview);
		model.addAttribute("drinkAvg", drinkAvg);
		model.addAttribute("thisDrinksRevs", thisDrinksRevs);
		
		return "drinkpg";
	}
	
	//@PostMapping("/{drinkId}")
	@RequestMapping(value="/{drinkId}", params={"submitRating"})
	public String veiwDrink(@PathVariable("drinkId") Integer drinkId, Model model, @ModelAttribute ReviewModel reviewMods) {
		Drink drink = drinkService.findByDrinkId(drinkId);
		User author = drink.getAuthorId();
		Country country = drink.getDrinkCountry();
		List<User> wantsToTry = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.TOTRY);
		List<User> hasTried = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.HASTRIED);
		Set<Comment> drinkComments = drink.getDrinkComments();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		User currnetUser = userServ.findByuserName(userName);
		
		model.addAttribute("drinkId", drinkId);
		model.addAttribute("thisUser", currnetUser);
		model.addAttribute("author", author);
		model.addAttribute("country", country);
		model.addAttribute("wants", wantsToTry);
		model.addAttribute("has", hasTried);
		model.addAttribute("comments", drinkComments);	
		model.addAttribute("drink", drink);
		model.addAttribute("newComment", new Comment());
		model.addAttribute("reviewMods", new ReviewModel());
		
		// Save Review
		Review review = new Review();
		review.setDrinkId(drink);
		review.setRating(reviewMods.getRating());
		review.setReviewUserId(currnetUser);
		review.setReviewDate(LocalDateTime.now());
		revRepo.save(review);
		
		List<Review> thisDrinksRevs = RevServ.getallReviewsForThisDrink(drinkId);
		Float drinkAvg = RevServ.thisDrinkAverage(drinkId);
		model.addAttribute("thisDrinksRevs", thisDrinksRevs);
		model.addAttribute("drinkAvg", drinkAvg);
		
		return "drinkpg";
	}
	
	//@PostMapping("/{drinkId}")
	@RequestMapping(value="/{drinkId}", params={"submitComment"})
	public String veiwDrink(@PathVariable("drinkId") Integer drinkId, Model model, @ModelAttribute Comment newComment) {
		Drink drink = drinkService.findByDrinkId(drinkId);
		User author = drink.getAuthorId();
		Country country = drink.getDrinkCountry();
		List<User> wantsToTry = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.TOTRY);
		List<User> hasTried = tryService.getUserFromTryList(drink.getDrinkTries(), TryType.HASTRIED);
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userServ.findByuserName(userName);
		List<Review> thisDrinksRevs = RevServ.getallReviewsForThisDrink(drinkId);
		Float drinkAvg = RevServ.thisDrinkAverage(drinkId);

		model.addAttribute("drinkId", drinkId);
		model.addAttribute("thisUser", currentUser);
		model.addAttribute("author", author);
		model.addAttribute("country", country);
		model.addAttribute("wants", wantsToTry);
		model.addAttribute("has", hasTried);
		model.addAttribute("thisDrinksRevs", thisDrinksRevs);
		model.addAttribute("drinkAvg", drinkAvg);
		model.addAttribute("drink", drink);
		model.addAttribute("newComment", new Comment());
		model.addAttribute("reviewMods", new ReviewModel());
		
		// Save Comment
		newComment.setCommentAuthorId(currentUser);
		newComment.setDrinkId(drink);
		newComment.setCommentDate(LocalDateTime.now());
		commentRepo.save(newComment);
		
		Set<Comment> drinkComments = drink.getDrinkComments();
		model.addAttribute("comments", drinkComments);	
		
		return "drinkpg";
	}
	
	@GetMapping("/AddDrink")
	public  String showDrinkForm(Model model) {
		List<DrinkType> alltypes = dTypeRepo.findAll();
		List<Country> countries = countryServ.findAll();
		model.addAttribute("countries", countries);
		model.addAttribute("alltypes", alltypes);
		AddDrinkModel addDrink = new AddDrinkModel();
		
		addDrink.setIngredients(new ArrayList<String>());
		addDrink.getIngredients().add("");
		
		addDrink.setInstructions(new ArrayList<String>());
		addDrink.getInstructions().add("");
		
		model.addAttribute("adddrink", addDrink);
		return "AddDrink";    
	}
	
	@PostMapping("/AddDrink")
	public  String showDrinkForm(@ModelAttribute AddDrinkModel addDrink, Model model, @RequestParam("image") MultipartFile file) {
		model.addAttribute("adddrink", addDrink);
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userServ.findByuserName(userName);
		
		Drink newDrink = new Drink();
		newDrink.setDrinkName(addDrink.getName());
		newDrink.setDrinkNotes(addDrink.getDrinkNotes());
		newDrink.setMakingNotes(addDrink.getAdditionalNotes());
		newDrink.setDateDrinkPublished(LocalDateTime.now());
		newDrink.setAuthorId(user);
		
		Country country = countryServ.findById(addDrink.getCountryId());
		newDrink.setdrinkCountryId(country);
		
		Set<DrinkType> drinkTypes = new HashSet<DrinkType>();
		for(String drinkTypeId : addDrink.getTypeIds()){
			Integer typeId = Integer.parseInt(drinkTypeId);
			DrinkType type = dTypeRepo.findById(typeId).get();
			drinkTypes.add(type);
		}
		newDrink.setDrinkType(drinkTypes);
	
		newDrink = drinkRepo.save(newDrink);
		
		if(addDrink.getIngredients() != null) {
			for(String s : addDrink.getIngredients()){
				Ingredient newIngredient = new Ingredient();
				newIngredient.setIngredient(s);
				newIngredient.setIngredientDrinkId(newDrink);
				ingredientRepo.save(newIngredient);
			}
		}
		
		if(addDrink.getInstructions() != null) {
			for(String s : addDrink.getInstructions()){
				Instruction newInstruction = new Instruction();
				newInstruction.setStep_instruction(s);
				newInstruction.setInstructionDrinkId(newDrink);
				instructionRepo.save(newInstruction);
			}
		}
		
		// Save Image
		String rootPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\media\\Drinks\\";
		String webPath = "/media/drinks/";
		String originalfileName = file.getOriginalFilename();
		String fileExtension = "";
		if(originalfileName.indexOf(".") > 0 && originalfileName.lastIndexOf(".") < originalfileName.length() - 1) 
		{
			fileExtension = originalfileName.substring(originalfileName.lastIndexOf(".") + 1);
		}
		
		List<String> validFileExtensions = Arrays.asList("jpg","jpeg","png","gif","bmp");
		if(validFileExtensions.contains(fileExtension)) {
			String newFileName = newDrink.getDrinkId().toString() + "." + fileExtension;
			Path fileNameAndPath = Paths.get(rootPath, newFileName);
	        try {
				Files.write(fileNameAndPath, file.getBytes());
				
				newDrink.setDrinkImg(webPath + newFileName);
				drinkRepo.save(newDrink);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/drinks/" + newDrink.getDrinkId();    
	}
	
	@ModelAttribute("allTypes")
	public List<DrinkType> alldrinktypes() {
	    return dTypeRepo.findAll();
	}
	    
	@ModelAttribute("allCountries")
	public List<Country> populateCountries() {
	    return countryServ.findAll();
	}
	
//	@PostMapping("{drinkId}")
//	public  String reviewFormForm(@PathVariable("drinkId") Integer drinkId, @ModelAttribute ReviewModel reviewMods, Model model) {
//		model.addAttribute("reviewMods", reviewMods);
//		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
//		User user = userServ.findByuserName(userName);
//		Drink drink = drinkService.findByDrinkId(drinkId);
//		Review rating = new Review();
//		
//		rating.setDrinkId(drink);
//		rating.setRating(reviewMods.getRating());
//		rating.setReviewUserId(user);
//		rating.setReviewDate(LocalDateTime.now());
//		revRepo.save(rating);
//		
//		return "drinkpg";
//	}
	
	
	
	
	    
	
}
