package com.maplemegan.cozycuppa.entities;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import enums.TryType;
import lombok.AllArgsConstructor;
import lombok.Builder;


//User information mapped to a table
@Builder
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private Integer userId;
	
	@Column(name="Email",unique=true, nullable=false)
	private String email;
	
	
	@Column(name="Password", nullable=false)
	private String password;
	
	@Column(name="Username",unique=true, nullable=false)
	private String userName;
	
	@ManyToOne
    @JoinColumn(name = "User_Country", referencedColumnName = "Country_Id")
	private Country userCountryId;
	
	@Column(name="User_DOB", nullable=false)
	private Date userDOB;
	
	@Column(name="User_Photo",unique=true)
	public String profilePhoto;
	
	@Column(name="User_Bio")
	private String bio;
	
	@CreationTimestamp
	@Column(name="User_Create_Date", nullable=false)
	private LocalDateTime userCreateDate;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Account_Active")
	private Boolean active;
	
	//Relationalmappinghere
	@ManyToMany
	@JoinTable(name="tbl_follows",
	 joinColumns=@JoinColumn(name="personId"),
	 inverseJoinColumns=@JoinColumn(name="followId")
	)
	private Set<User> follows;

	@ManyToMany
	@JoinTable(name="tbl_follows",
	 joinColumns=@JoinColumn(name="friendId"),
	 inverseJoinColumns=@JoinColumn(name="personId")
	)
	private Set<User> followers;
	
	@OneToMany(mappedBy = "authorId")
	private Set<Drink> userMadeDrinks;
	@OneToMany(mappedBy = "userTryId")
	private Set<Try> usersTries;
	@OneToMany(mappedBy = "commentAuthorId")
	private Set<Comment> usersComments;
	@OneToMany(mappedBy = "reviewUserId")
	private Set<Review> userReviews;
	
	public User() {
		
	}
	
	//Id getter and setters
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId() {
		return this.userId;
	}
	
	//Email Getter and Setters
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//Password Getter and Setters
	
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
	
	//Username Getter and Setters
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getUserName() {
		return this.userName;
	}
	
	//User_Country Getter and Setters
	public void setUserCountry(Country country) {
		this.userCountryId=country;
	}
	public Country getUserCountry() {
		return this.userCountryId;
	}
	
	//User_DOB Getter and Setters
	public void setUserDOB(Date userDOB) {
		this.userDOB=userDOB;
	}
	public Date getUserDOB() {
		return this.userDOB;
	}
	
	//profilePhoto Getter and setters
	public void setUserprofilePhoto(String photoUrl) {
		this.profilePhoto=photoUrl;
	}
	public String getUserpProfilePhoto() {
		return this.profilePhoto;
	}
	
	//bio Getter and setters
	public void setBio(String bio) {
		this.bio=bio;
	}
	public String getBio() {
		return this.bio;
	}
	
	//userCreateDate Getter and Setters
	public void setUserCreateDate(LocalDateTime userCreateDate) {
		this.userCreateDate=userCreateDate;
	}
	public LocalDateTime getUserCreateDate(){
		return this.userCreateDate;
	}
	
	//firstname getter and setters
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	
	
	//lastname getter and setters
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	//active getter and setters
	public void setActive(Boolean active) {
		this.active=active;
	}
	public Boolean getActive() {
		return this.active;
	}
	
	//getters and setters for Set<Connection> userConnections;
	public void setFollows(Set<User> follows) {
		this.follows=follows;
	}
	public Set<User> getFollows(){
		return this.follows;
	}
	
	public void setFollowers(Set<User> followers) {
		this.followers=followers;
	}
	public Set<User> getFollowers(){
		return this.followers;
	}
	
	//getters and setters for Set<Drink> userMadeDrinks;
	public void setUserMadeDrinks(Set<Drink> userMadeDrinks) {
		this.userMadeDrinks=userMadeDrinks;
	}
	public Set<Drink> getUserMadeDrinks() {
		return this.userMadeDrinks;
	}
	
	// getters and setters for Set<Try> usersTries;
	public void setUserTries(Set<Try> usersTries) {
		this.usersTries=usersTries;
	}
	public Set<Try> getUserTries(){
		return this.usersTries;
	}
	
	// getters and setters for Set<Comment> usersComments;
	public void setUserComments(Set<Comment> userComments) {
		this.usersComments=userComments;
	}
	public Set<Comment> getUserComments(){
		return this.usersComments;
	}
	
	// getters and setters for Set<Review> userReviews;
	public void setUserReviews(Set<Review> userReviews) {
		this.userReviews=userReviews;
	}
	public Set<Review> getUserReviews(){
		return this.userReviews;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", userName=" + userName
				+ ", userCountryId=" + userCountryId + ", userDOB=" + userDOB + ", profilePhoto=" + profilePhoto
				+ ", bio=" + bio + ", userCreateDate=" + userCreateDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", active=" + active + ", follows=" + follows + ", followers=" + followers
				+ ", userMadeDrinks=" + userMadeDrinks + ", usersTries=" + usersTries + ", usersComments="
				+ usersComments + ", userReviews=" + userReviews + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, bio, email, firstName, lastName, password, userDOB, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(active, other.active) && Objects.equals(bio, other.bio)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(userDOB, other.userDOB) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}
	
}
