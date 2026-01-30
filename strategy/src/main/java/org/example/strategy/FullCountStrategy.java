package org.example.strategy;

import org.example.AnalyzeStrategy;
import org.example.QuestionStatistics;

import java.util.List;
import java.util.Map;

public class FullCountStrategy implements AnalyzeStrategy {

    @Override
    public void makeAnalyze(List<QuestionStatistics> questionStatistics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fill Count Analyze\n");

        for(QuestionStatistics questionStats: questionStatistics) {
            stringBuilder.append("Question: ")
                    .append(questionStats.questionTitle())
                    .append("\n");

            int totalUserPolledCount = questionStats.userSelectedVariantsCount().size();
            for(Map.Entry<String,Integer> entry: questionStats.selectedVariantsCount().entrySet()) {
                stringBuilder.append(entry.getValue())
                        .append(" out of ")
                        .append(totalUserPolledCount)
                        .append(" chose: ")
                        .append(entry.getKey())
                        .append("\n");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
