package com.maplemegan.cozy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.TryDto;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.mapper.TryMapper;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.TryRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;
import com.maplemegan.cozycuppa.util.SecurityUtils;

import enums.TryType;

@Service
public class TryService {
	private UserRepository userRepo;
	private DrinkRepository drinkRepo;
	private TryRepository tryRepo;
	
	public TryService(UserRepository userRepo, DrinkRepository drinkRepo, TryRepository tryRepo) {
		this.userRepo = userRepo;
		this.drinkRepo = drinkRepo;
		this.tryRepo = tryRepo;
	}
	
	public void createTry(Integer drinkId, TryDto thisTry) {
		String thisUse = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepo.findByuserName(thisUse);
		Drink drink= drinkRepo.findById(drinkId).get();
		Try tryHere = TryMapper.maptoTry(thisTry);
		tryHere.setDrinkId(drink);
		tryHere.setUserId(user);
		tryRepo.save(tryHere);
	}
	
	public Boolean userTryInterest(Integer userId, Integer drinkId) {
		List<Try> drinkTries = tryRepo.findBydrinkTryId(drinkId);
		Boolean userInterest = false;
		for(Try t: drinkTries) {
			if(t.getDrinkId().getDrinkId()==drinkId) {
				userInterest=true;
				break;
			}
		}
		return userInterest;
	}
	
	public Try updateTry(Try thisTry) {
		if(thisTry.getTryType()==TryType.TOTRY) {
			thisTry.setTryType(TryType.HASTRIED);
		} else {
			thisTry.setTryType(TryType.TOTRY);
		}
		return tryRepo.save(thisTry);
	}
	
	public void toUpdateorToSave(Integer drink, TryDto thisTry) {
		String thisUse = SecurityUtils.getCurrentUser().getUsername();
		Integer user = userRepo.findByuserName(thisUse).getUserId();
		if(userTryInterest(user, drink)){
			List<Try> searchUserforTry = tryRepo.findByuserTryId(user);
			for(Try t: searchUserforTry) {
				if(t.getDrinkId().getDrinkId()==drink) {
					updateTry(t);
				}
			}
		} 
			 createTry(drink, thisTry);
	}
	
	public List<Try> findTryByDrink(Integer drinkId) {
		return tryRepo.findBydrinkTryId(drinkId);
	}
	
	public List<Try> findByUserId(Integer userId) {
		return tryRepo.findByuserTryId(userId);
	}
	
	public List<Try> findByCurrentUserId() {
		String thisUse = SecurityUtils.getCurrentUser().getUsername();
		Integer user = userRepo.findByuserName(thisUse).getUserId();
		return findByUserId(user);
	}
	public List<Try> tryTypy(Set<Try> allTries, TryType filteringType) {
		List<Try> filtered = new ArrayList<>();
		for(Try t: allTries) {
			if(t.getTryType()==filteringType) {
				filtered.add(t);
			}
		}
		return filtered;		
	}
	 
	public List<User> getUserFromTryList(Set<Try> someTry, TryType thisType){
		List<Try> filteredTries = tryTypy(someTry, thisType);
		List<User> users = new ArrayList<>();
		for(Try t: filteredTries) {
			users.add(t.getUserId());
		}
		return users;		
	}
	public List<Drink> getDrinksFromTryList(Set<Try> someTry, TryType thisType){
		List<Try> filteredTries = tryTypy(someTry, thisType);
		List<Drink> drinks = new ArrayList<>();
		for(Try t: filteredTries) {
			drinks.add(t.getDrinkId());
		}
		return drinks;		
	}
}
