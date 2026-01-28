package org.example;

import java.util.List;

public record Poll(
        String name,
        List<Question> questions
) {
    public static PollBuilder builder() {
        return new PollBuilder();
    }
}
