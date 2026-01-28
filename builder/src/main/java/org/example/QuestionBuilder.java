package org.example;

import java.util.ArrayList;
import java.util.List;

public class QuestionBuilder {
    private PollBuilder pollBuilder;
    private String title;
    private int min;
    private int max;
    private List<String> answers;

    public QuestionBuilder(PollBuilder pollBuilder) {
        this.pollBuilder = pollBuilder;
        this.title = "Empty";
        this.min = 0;
        this.max = 0;
        this.answers = new ArrayList<>();
    }

    public QuestionBuilder title(String title) {
        this.title = title;
        return this;
    }

    public QuestionBuilder min(int min) {
        this.min = min;
        return this;
    }

    public QuestionBuilder max(int max) {
        this.max = max;
        return this;
    }

    public QuestionBuilder answerVariant(String answer) {
        this.answers.add(answer);
        return this;
    }

    public PollBuilder and() {
        Question question = this.build();
        return pollBuilder.addQuestion(question);
    }

    private Question build() {
        return new Question(title,min,max,answers);
    }
}
