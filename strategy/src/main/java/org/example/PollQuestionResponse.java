package org.example;

import java.util.List;

public record PollQuestionResponse(
        Question question,
        List<String> selectedVariants) {
}
