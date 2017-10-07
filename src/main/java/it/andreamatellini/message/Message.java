package it.andreamatellini.message;

import java.util.Date;

public class Message {
    private String user;
    private Date postDate;
    private String message;

    public Message(String user, Date postDate, String message) {
        this.user = user;
        this.postDate = postDate;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public Date getMessageDate() {
        return postDate;
    }

    public String getMessage() {
        return message;
    }
}
