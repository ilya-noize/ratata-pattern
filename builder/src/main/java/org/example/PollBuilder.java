package org.example;

import java.util.ArrayList;
import java.util.List;

public class PollBuilder {
    private String name;
    private List<Question> questions;

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
        return new QuestionBuilder(this);
    }

    public QuestionBuilder oneVariantQuestion(String title) {
        return new QuestionBuilder(this)
                .title(title)
                .min(1)
                .max(1);
    }

    public PollBuilder addQuestion(Question question) {
        this.questions.add(question);
        return this;
    }
}
