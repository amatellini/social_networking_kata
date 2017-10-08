package it.andreamatellini.message;

import java.time.LocalDateTime;

public class Message {
    private String user;
    private LocalDateTime postDate;
    private String message;

    public Message(String user, LocalDateTime postDate, String message) {
        this.user = user;
        this.postDate = postDate;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public LocalDateTime getMessageDate() {
        return postDate;
    }

    public String getMessage() {
        return message;
    }
}
