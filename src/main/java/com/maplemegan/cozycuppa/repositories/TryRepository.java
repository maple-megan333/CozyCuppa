package com.maplemegan.cozycuppa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maplemegan.cozycuppa.entities.Try;
import enums.TryType;

public interface TryRepository extends JpaRepository<Try, Integer> {
	List<Try> findByuserTryId(Integer userTryId);
	List<Try> findBydrinkTryId(Integer drinkTryId);
	List<Try> findBytryType(TryType tryType);
}
