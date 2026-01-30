package org.example;

public class Builder {
    public static void main(String[] args) {
        Poll poll = Poll.builder()
                .pollName("test")
                .pollQuestion("Q1")
                .min(1)
                .max(2)
                .answerVariant("1")
                .answerVariant("2")
                .answerVariant("3")
                .answerVariant("4")
                .and()
                .build();

    }
}