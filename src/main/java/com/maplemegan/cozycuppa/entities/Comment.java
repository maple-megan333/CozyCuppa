package com.maplemegan.cozycuppa.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Comments")
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Comment_Id")
	private Integer commentId;
	
	@ManyToOne
    @JoinColumn(name = "Comment_Drink", referencedColumnName = "Drink_Id")
	private Drink drinkCommentId;
	
	@ManyToOne
    @JoinColumn(name = "Comment_Author", referencedColumnName = "User_Id")
	private User commentAuthorId;
	
	@CreationTimestamp
	@Column(name="Comment_Date")
	private LocalDateTime commentDate;
	
	@Column(name="Comment_Body")
	private String commentText;
	
	public Comment() {
		
	}
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Drink getDrinkId() {
		return drinkCommentId;
	}
	public void setDrinkId(Drink drinkId) {
		this.drinkCommentId = drinkId;
	}
	public User getCommentAuthorId() {
		return commentAuthorId;
	}
	public void setCommentAuthorId(User commentAuthorId) {
		this.commentAuthorId = commentAuthorId;
	}
	public LocalDateTime getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", drinkId=" + drinkCommentId + ", commentAuthorId=" + commentAuthorId
				+ ", commentDate=" + commentDate + ", CommentText=" + commentText + "]";
	}

	//getters and setters for  commentId;
	// getters and setters for drinkId;
	// getters and setters for commentAuthorId;
	// getters and setters for commentDate;
	// getters and setters for CommentText;
	
	/*
	 * Additional class attributes for future features
	 * private Integer parentComment;
	 * private String commentImg;
	 * private Boolean commentRead;
	 */
	
	
}
