package com.maplemegan.cozycuppa.controllers;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.repositories.CommentRepository;



@RestController
@RequestMapping("/comments")
public class CommentController {
	private CommentRepository commentRepo;
	 
	public CommentController(CommentRepository commentRepo) {
		this.commentRepo=commentRepo;
	}
	
	
}
