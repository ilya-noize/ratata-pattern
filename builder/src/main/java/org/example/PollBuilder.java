package org.example;

import java.util.ArrayList;
import java.util.List;

public class PollBuilder {
    private String name;
    private final List<Question> questions;

    public PollBuilder() {
        this.questions = new ArrayList<>();
    }

    public Poll build() {
        return new Poll(name, questions);
    }

    public PollBuilder pollName(String pollName) {
        this.name = pollName;
        return this;
    }

    public QuestionBuilder pollQuestion(String title) {
        return new QuestionBuilder(this).title(title);
    }

    public QuestionBuilder oneVariantQuestion(String title) {
        return new QuestionBuilder(this)
                .title(title)
                .min(1)
                .max(1);
    }

    public PollBuilder yesNoQuestion(String title) {
        return new QuestionBuilder(this)
                .title(title)
                .min(1)
                .max(1)
                .answerVariant("Yes")
                .answerVariant("No")
                .and();
    }

    public PollBuilder addQuestion(Question question) {
        this.questions.add(question);
        return this;
    }
}
