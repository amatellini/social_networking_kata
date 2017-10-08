package it.andreamatellini.utils;

import it.andreamatellini.message.Message;

import java.time.LocalDateTime;
import java.util.Comparator;

public class PostDateComparator implements Comparator<Message> {
    @Override
    public int compare(Message p1, Message p2) {
        LocalDateTime date1 = p1.getMessageDate();
        LocalDateTime date2 = p2.getMessageDate();
        return date1.compareTo(date2);
    }
}
