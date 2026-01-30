package org.example;

import java.util.Map;

public class QuestionStatistics {
    private String questionTitle;
    private Map<String,Integer> selectedVariantsCount;
    private Map<String,Integer> userSelectedVariantsCount;

    protected QuestionStatistics() {
    }

    public QuestionStatistics(String questionTitle, Map<String, Integer> selectedVariantsCount, Map<String, Integer> userSelectedVariantsCount) {
        this.questionTitle = questionTitle;
        this.selectedVariantsCount = selectedVariantsCount;
        this.userSelectedVariantsCount = userSelectedVariantsCount;
    }

    public String questionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Map<String, Integer> selectedVariantsCount() {
        return selectedVariantsCount;
    }

    public void setSelectedVariantsCount(Map<String, Integer> selectedVariantsCount) {
        this.selectedVariantsCount = selectedVariantsCount;
    }

    public Map<String, Integer> userSelectedVariantsCount() {
        return userSelectedVariantsCount;
    }

    public void setUserSelectedVariantsCount(Map<String, Integer> userSelectedVariantsCount) {
        this.userSelectedVariantsCount = userSelectedVariantsCount;
    }
}
