package org.example;

import java.lang.reflect.Field;
import java.util.List;

public class PollAnalyzerProxy extends PollAnalyzer {
    private String currentStrategy;
    private final PollAnalyzer delegate;

    public PollAnalyzerProxy(
            PollAnalyzer delegate
    ) {
        super(null);
        this.delegate = delegate;
        this.currentStrategy = extractCurrentStrategyName();
    }

    public void analyzePoll(List<PollFillingData> pollFillingDataList) {
        System.out.println("*** starting analyze poll by strategy: " + currentStrategy);
        long startTime = System.currentTimeMillis();
        delegate.analyzePoll(pollFillingDataList);
        long endTime = System.currentTimeMillis();
        System.out.printf("*** Ending analyze poll by strategy: %s, totalAnalyzeTimeMS: %s%n%n",
                currentStrategy,
                endTime - startTime
        );
    }

    public void changeAnalyzerStrategy(AnalyzeStrategy analyzerStrategy) {
        delegate.changeAnalyzeStrategy(analyzerStrategy);
        currentStrategy = analyzerStrategy.getClass().getSimpleName();
    }

    private String extractCurrentStrategyName() {
        try {
            Field field = delegate.getClass().getDeclaredField("analyzerStrategy");
            field.setAccessible(true);
            var currentStrategy = field.get(delegate);
            return currentStrategy.getClass().getSimpleName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return "Unknown strategy";
        }
    }
}
