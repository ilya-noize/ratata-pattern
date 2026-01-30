package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollAnalyzer {
    private AnalyzeStrategy strategy;

    public PollAnalyzer(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeAnalyzeStrategy(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void analyzePoll(List<PollFillingData> pollFillingDataList) {
        List<QuestionStatistics> statistics = collectStatistics(pollFillingDataList);
        strategy.makeAnalyze(statistics);
    }

    private List<QuestionStatistics> collectStatistics(List<PollFillingData> pollFillingDataList) {
        Map<String, QuestionStatistics> questionStatisticsMap = new HashMap<>();

        for (PollFillingData fillingData : pollFillingDataList) {
            String currentUser = fillingData.userLogin();

            for (PollQuestionResponse questionResponse : fillingData.pollQuestionResponseList()) {
                String title = questionResponse.question().title();
                questionStatisticsMap.putIfAbsent(title, new QuestionStatistics(
                        title,
                        new HashMap<>(),
                        new HashMap<>()
                ));

                QuestionStatistics questionStatistics = questionStatisticsMap.get(title);

                Map<String, Integer> selectedVariantsCount = questionStatistics.selectedVariantsCount();
                questionResponse.selectedVariants().forEach(variant -> {
                    selectedVariantsCount.putIfAbsent(variant, 0);
                    selectedVariantsCount.put(variant, selectedVariantsCount.get(variant) + 1);
                });

                questionStatistics.userSelectedVariantsCount().put(
                        currentUser,
                        questionResponse.selectedVariants().size()
                );
            }
        }
        return questionStatisticsMap.values().stream().toList();
    }
}
