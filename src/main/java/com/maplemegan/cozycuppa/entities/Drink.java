package com.maplemegan.cozycuppa.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Drinks")
public class Drink {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Drink_Id")
	private Integer drinkId;
	
	@ManyToOne
	@JoinColumn(name = "Drink_Author", referencedColumnName = "User_Id")
	private User authorId;
	 
	@Column(name="Drink_name", nullable=false)
	public String drinkName;
	
	@Column(name="Drink_img_url")
	private String drinkImg;
	
	
	@Column(name="Drink_Notes")
	private String drinkNotes;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name="Assigned_Drink_Types",
    joinColumns={@JoinColumn(name="Drink", referencedColumnName="Drink_Id")},
    inverseJoinColumns={@JoinColumn(name="Type", referencedColumnName="Type_Id")})
	private Set<DrinkType> drinkType;
	
	@OneToMany(mappedBy = "ingredientDrinkId")
	@Column(name="Ingredients")
	private Set<Ingredient> ingredients;
	
	@OneToMany(mappedBy = "instructionDrinkId")
	@Column(name="Instructions")
	private Set<Instruction> instructions;
	
	@Lob
	@Column(name="Making_Notes")
	private String makingNotes;
	
	/* this will be put in for the later ability to have related drinks
	private Integer	RelatedDrink;
	*/
	
	@CreationTimestamp
	@Column(name="Date_Published")
	public LocalDateTime dateDrinkPublished;
	
	@ManyToOne
    @JoinColumn(name = "Drink_Country", referencedColumnName = "Country_Id")
	public Country	drinkCountryId;
	
	//relational mapping 
	
	@OneToMany(mappedBy = "drinkTryId")
	public Set<Try> drinkTries;
	
	@OneToMany(mappedBy = "drinkCommentId")
	private Set<Comment> drinkComments;
	
	@OneToMany(mappedBy = "drinkReviewId")
	private Set<Review> drinkReviews;
	
	public Drink() {
		
	}
	
	//Getters and setters for drinkId
	public void setDrinkId(Integer drinkId) {
		this.drinkId=drinkId;
	}
	public Integer getDrinkId() {
		return this.drinkId;
	}
	
	//getters and setters for authorid
	public void setAuthorId(User authorId) {
		this.authorId=authorId;
	}
	public User getAuthorId() {
		return this.authorId;
	}
	
	
	//getters and setters for drinkName
	public void setDrinkName(String drinkName) {
		this.drinkName=drinkName;
	}
	public String getDrinkName()
	{
		return this.drinkName;
	}
	
	// getters and setters for drinkImg
	public void setDrinkImg(String drinkImg) {
		this.drinkImg=drinkImg;
	}
	public String getDrinkImg() {
		return this.drinkImg;
	}
	//Getters and setters for drinkNotes
	public void setDrinkNotes(String drinkNotes) {
		this.drinkNotes=drinkNotes;
	}
	public String getDrinkNotes() {
		return this.drinkNotes;
	}
	
	// gettrs and setters for drinkType
	public void setDrinkType(Set<DrinkType> drinkType) {
		this.drinkType=drinkType;
	}
	public Set<DrinkType> getDrinkType() {
		return this.drinkType;
	}
	
	// getters and setters for ingredients
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients=ingredients;
	}
	public Set<Ingredient> getIngredients() {
		return this.ingredients;
	}
	//getters and setters for instructions
	public void setInstructions(Set<Instruction> instructions) {
		this.instructions=instructions;
	}
	public Set<Instruction> getInstructions() {
		return this.instructions;
	}
	
	// getters and setters for makingNotes
	public void setMakingNotes(String makingNotes) {
		this.makingNotes=makingNotes;
	}
	public String getMakingNotes() {
		return this.makingNotes;
	}
	
	// getters and setters for parentDrink
	//these will come with expansion
	// getters and setters for  dateDrinkPublished
	public void setDateDrinkPublished(LocalDateTime date) {
		this.dateDrinkPublished=date;
	}
	public LocalDateTime getDateDrinkPublished() {
		return this.dateDrinkPublished;
	}
	
	// getters and setters for drinkCountryId
	public void setdrinkCountryId(Country country) {
		this.drinkCountryId=country;
	}
	public Country getDrinkCountry() {
		return this.drinkCountryId;
	}
	
	//these are sets for now (mayend up as lists)
	//getters and setters for drinkTries
	public void setDrinkTries(Set<Try> tries) {
		this.drinkTries=tries;
	}
	public Set<Try> getDrinkTries(){
		return this.drinkTries;
	}
	
	//getters and setters for drinkComments
	public void setDrinkComments(Set<Comment> comments) {
		this.drinkComments=comments;
	}
	public Set<Comment> getDrinkComments(){
		return this.drinkComments;
	}
	//getters and setters for drinkReviews
	public void setDrinkReviews(Set<Review> reviews) {
		this.drinkReviews=reviews;
	}
	public Set<Review> getDrinkReviews(){
		return this.drinkReviews;
	}

	@Override
	public String toString() {
		return "Drink [drinkId=" + drinkId + ", authorId=" + authorId + ", drinkName=" + drinkName + ", drinkImg="
				+ drinkImg + ", drinkNotes=" + drinkNotes + ", drinkType=" + drinkType + ", ingredients=" + ingredients
				+ ", instructions=" + instructions + ", makingNotes=" + makingNotes + ", dateDrinkPublished="
				+ dateDrinkPublished + ", drinkCountryId=" + drinkCountryId + ", drinkTries=" + drinkTries
				+ ", drinkComments=" + drinkComments + ", drinkReviews=" + drinkReviews + "]";
	}
	
	
}
