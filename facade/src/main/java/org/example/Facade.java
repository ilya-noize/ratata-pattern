package org.example;

import java.util.List;

public class Facade {
    public static void main(String[] args) {
        PollLifecycleFacade pollLifecycleFacade = new PollLifecycleFacade();

        Poll poll = pollLifecycleFacade.createPoll();
        List<PollFillingData> userFillingDataList = pollLifecycleFacade.getUserResponses(poll);
        pollLifecycleFacade.makeAnalyzePoll(userFillingDataList);
    }
}