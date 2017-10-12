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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (!user.equals(message1.user)) return false;
        if (!postDate.equals(message1.postDate)) return false;
        return message.equals(message1.message);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + postDate.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}
