package org.example.strategy;

import org.example.AnalyzeStrategy;
import org.example.QuestionStatistics;

import java.util.List;
import java.util.Map;

public class LeastFrequentAnswerStrategy implements AnalyzeStrategy {

    @Override
    public void makeAnalyze(List<QuestionStatistics> questionStatistics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Least Frequent Analyze\n");

        for (QuestionStatistics questionStats : questionStatistics) {
            var mostFrequentQuestionAnswer = "";
            var mostFrequentQuestionVotes = -1;

            for (Map.Entry<String, Integer> qv : questionStats.selectedVariantsCount().entrySet()) {
                if (mostFrequentQuestionVotes == -1
                        || mostFrequentQuestionVotes > qv.getValue()) {
                    mostFrequentQuestionVotes = qv.getValue();
                    mostFrequentQuestionAnswer = qv.getKey();
                }
            }

            stringBuilder.append("Question: ")
                    .append(questionStats.questionTitle()).append("\n")
                    .append("Least frequent answer is: ").append(mostFrequentQuestionAnswer).append("\n")
                    .append(mostFrequentQuestionVotes).append(" choose this variant").append("\n\n");
        }

        System.out.println(stringBuilder);
    }
}
