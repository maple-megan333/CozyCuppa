package com.maplemegan.cozycuppa.dto;


import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;

import enums.TryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TryDto {
private Integer tryId;
private User userTryId;
private Drink drinkTryId;
private TryType tryType;

}
