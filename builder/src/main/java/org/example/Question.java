package org.example;

import java.util.List;

public record Question(
        String title,
        int min,
        int max,
        List<String> answers
) {
    public Question {
        if(min < 0
                || max<=0
                || min > max
                || min >= answers.size()
        ) {
            throw new IllegalArgumentException("Illegal max or min answers count");
        }
    }
}
