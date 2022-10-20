package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.TryDto;
import com.maplemegan.cozycuppa.entities.Try;

public class TryMapper {
	//map try to trydto
	public TryDto maptoTryDto(Try tryThis) {
		TryDto thisTry = TryDto.builder()
				.tryId(tryThis.getTryId()).userTryId(tryThis.getUserId())
				.drinkTryId(tryThis.getDrinkId()).tryType(tryThis.getTryType()).build();
		return thisTry;
	}
	//map trydto to try
	public static Try maptoTry(TryDto tryThis) {
		return Try.builder().tryId(tryThis.getTryId()).userTryId(tryThis.getUserTryId())
				.drinkTryId(tryThis.getDrinkTryId()).tryType(tryThis.getTryType()).build();
	}
	
}
