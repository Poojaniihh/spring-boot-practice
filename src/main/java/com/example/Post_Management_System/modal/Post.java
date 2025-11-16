package com.example.Post_Management_System.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    private String content;

    @NotBlank(message = "privacy is required")
    @Pattern(regexp = "PUBLIC|PRIVATE|PROTECTED", message = "privacy must be : PUBLIC, PRIVATE or PROTECTED")
    private String privacy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
}
