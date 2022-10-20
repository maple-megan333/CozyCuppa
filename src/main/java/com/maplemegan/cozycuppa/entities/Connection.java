package com.maplemegan.cozycuppa.entities;

import javax.persistence.*;

import enums.ConnectionType;

/*
 * This methodology was proving too complicated so I am going to just set it aside for now
 * @Entity
@Table(name="Connections")
public class Connection {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer connectionId;
	
	@ManyToOne
    @JoinColumn(name = "Making_Connection", referencedColumnName = "User_Id")
	private User connectedUser;
	
	@ManyToOne
    @JoinColumn(name = "ConnectedTo", referencedColumnName = "User_Id")
	private User connectedToUser;
	
	@Column(name="Connection_type",nullable=false)
	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;
	
	public Connection() {
		
	}
	
	//Getter and setters for connectionId;
	public void setConnectionId(Integer id) {
		this.connectionId=id;
	}
	public Integer getConnectionId() {
		return this.connectionId;
	}
	
	// Getter and setters commentAuthor;
	public void getConnetedUser(User connectedUser) {
		this.connectedUser=connectedUser;
	}
	public User getConnectedUser() {
		return this.connectedUser;
	}
	
	// getter and setters connectedToUserId;
	public void getConnetedToUser(User connectedToUser) {
		this.connectedToUser=connectedToUser;
	}
	public User getConnectedToUser() {
		return this.connectedToUser;
	}
	// getters and setters for  connectionType;
	public void setConnectionType(ConnectionType type) {
		this.connectionType=type;
	}
	public ConnectionType getConnectionType() {
		return this.connectionType;
	}
	
	

}
*/
