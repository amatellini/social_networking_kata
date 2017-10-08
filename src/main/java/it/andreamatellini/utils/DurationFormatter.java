package it.andreamatellini.utils;

import java.time.Duration;

public class DurationFormatter {
    public static String format(Duration duration) {
        if(duration.getSeconds() < 60) {
            return duration.getSeconds() + " seconds ago";
        }
        else {
            return Math.round((double)duration.getSeconds() / 60) + " minutes ago";
        }
    }
}
