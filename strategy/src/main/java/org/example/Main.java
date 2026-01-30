package org.example;

import org.example.strategy.FullCountStrategy;
import org.example.strategy.LeastFrequentAnswerStrategy;
import org.example.strategy.MostFrequentAnswerStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PollFillingData> pollFillingDataList = new ArrayList<>();

        AnalyzeStrategy fullCountStrategy = new FullCountStrategy();
        AnalyzeStrategy leastFrequentAnswerStrategy = new LeastFrequentAnswerStrategy();
        AnalyzeStrategy mostFrequentAnswerStrategy = new MostFrequentAnswerStrategy();

        PollAnalyzer analyzer = new PollAnalyzer(fullCountStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(leastFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(mostFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);
    }
}

