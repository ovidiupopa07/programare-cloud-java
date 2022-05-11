package com.unitbv.autowiring.util;

import org.springframework.stereotype.Component;

@Component
public class FormatUtil {
    public String formatted(boolean isFormatted) {
        if (isFormatted) {
            return "Everything was formatted.";
        }
        return "Couldn't format";
    }
}
