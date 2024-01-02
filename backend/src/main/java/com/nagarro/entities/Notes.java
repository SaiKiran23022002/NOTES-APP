package com.nagarro.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notes")

public class Notes {
	@Id
	private long id;
	private String userId;
	private String Content;
	@Column(length=500)
	private String Title;
	
	public Notes() {
		
	}
    
	public Notes(long id, String userId, String Content, String Title) {
		super();
		this.Title = Title;
		this.Content = Content;	
		this.id = id;
		this.userId= userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return Objects.equals(id, notes.id);
    }

}
