package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class PollLifecycleFacade {


    public Poll createPoll() {
        return Poll.builder()
                .pollName("Тест по «Звёздным войнам» (Star Wars)")
                .yesNoQuestion("Люк Скайуокер — сын Энакина Скайуокера?")
                .oneVariantQuestion("Кто является главным антагонистом в оригинальной трилогии (эпизоды IV–VI)?")
                .answerVariant("Дарт Мол")
                .answerVariant("Император Палпатин")
                .answerVariant("Генерал Гривус")
                .answerVariant("Кайло Рен")
                .and()
                .pollQuestion("Какие из перечисленных персонажей владеют световым мечом?")
                .min(1)
                .max(5)
                .answerVariant("Хан Соло")
                .answerVariant("Оби-Ван Кеноби")
                .answerVariant("Чубакка")
                .answerVariant("Йода")
                .answerVariant("Лея Органа")
                .and()
                .yesNoQuestion("Планета Набу — родина Падме Амидалы?")
                .oneVariantQuestion("Как называется космический корабль Хана Соло?")
                .answerVariant("«Тысячелетний сокол»")
                .answerVariant("«Тантив IV»")
                .answerVariant("«Звезда Смерти»")
                .answerVariant("«Сокол Тысячелетия»")
                .and()
                .pollQuestion("Кто из перечисленных является джедаем?")
                .min(1)
                .max(5)
                .answerVariant("Мейс Винду")
                .answerVariant("Дарт Вейдер")
                .answerVariant("Квай-Гон Джинн")
                .answerVariant("Граф Дуку")
                .answerVariant("Асока Тано")
                .and()
                .yesNoQuestion("В фильме «Звёздные войны. Эпизод V: Империя наносит ответный удар» Люк обучается у Йоды на планете Дагоба?")
                .oneVariantQuestion("Какой цвет у светового меча Дарта Вейдера?")
                .answerVariant("Синий")
                .answerVariant("Зелёный")
                .answerVariant("Красный")
                .answerVariant("Фиолетовый")
                .and()
                .pollQuestion("Какие из этих планет появляются в оригинальной трилогии?")
                .max(5)
                .min(0)
                .answerVariant("Татуин")
                .answerVariant("Корусант")
                .answerVariant("Хот")
                .answerVariant("Эндор")
                .answerVariant("Мустафар")
                .and()
                .yesNoQuestion("Финн — бывший штурмовик Первого Ордена?")
                .build();
    }

    public List<PollFillingData> getUserResponses(Poll poll) {
        return IntStream.range(0, 50)
                .mapToObj(i -> generateRandomFillingData(poll))
                .toList();
    }

    public void makeAnalyzePoll(List<PollFillingData> pollFillingDataList) {

    }

    private PollFillingData generateRandomFillingData(Poll poll) {
        Random random = new Random();
        List<PollQuestionResponse> responses = new ArrayList<>();

        for (Question question : poll.questions()) {
            int min = question.min();
            int max = question.max();
            List<String> answers = question.answers();

            int numAnswers = min + random.nextInt(max - min + 1);
            List<String> selected = new ArrayList<>();

            for (int i = 0; i < numAnswers; i++) {
                String rndVariant = answers.get(random.nextInt(answers.size()));

                if (!selected.contains(rndVariant)) {
                    selected.add(rndVariant);
                }
            }

            responses.add(new PollQuestionResponse(question, selected));
        }

        return new PollFillingData("User #" + random.nextInt(), responses);
    }

}
