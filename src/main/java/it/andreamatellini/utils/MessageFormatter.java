package it.andreamatellini.utils;

import it.andreamatellini.message.Message;

import java.time.Duration;
import java.time.LocalDateTime;

public class MessageFormatter {
    public static String formatMessage(Message message, LocalDateTime systemTime) {
        Duration diff = Duration.between(message.getMessageDate(), systemTime);
        String formattedDiff = DurationFormatter.format(diff);
        return String.format("%s - %s (%s)", message.getUser(), message.getMessage(), formattedDiff);
    }
}
