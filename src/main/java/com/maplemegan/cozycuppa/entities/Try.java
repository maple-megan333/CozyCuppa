package com.maplemegan.cozycuppa.entities;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import enums.TryType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Tries")
public class Try {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Try_Id")
	
	private Integer tryId;
	@ManyToOne
    @JoinColumn(name = "User_Trying", referencedColumnName = "User_Id")
	private User userTryId;
	@ManyToOne
    @JoinColumn(name = "Try_Drink", referencedColumnName = "Drink_Id")
	private Drink drinkTryId;
	
	@Column(name="Try_Type")
	@Enumerated(EnumType.STRING)
	private TryType tryType;
	
	public Try() {
		
	}

	public Integer getTryId() {
		return tryId;
	}

	public void setTryId(Integer tryId) {
		this.tryId = tryId;
	}

	public User getUserId() {
		return userTryId;
	}

	public void setUserId(User userId) {
		this.userTryId = userId;
	}

	public Drink getDrinkId() {
		return drinkTryId;
	}

	public void setDrinkId(Drink drinkId) {
		this.drinkTryId = drinkId;
	}

	public TryType getTryType() {
		return tryType;
	}

	public void setTryType(TryType tryType) {
		this.tryType = tryType;
	}

	@Override
	public String toString() {
		return "Try [tryId=" + tryId + ", userId=" + userTryId + ", drinkId=" + drinkTryId + ", tryType=" + tryType + "]";
	}
	
	
}
