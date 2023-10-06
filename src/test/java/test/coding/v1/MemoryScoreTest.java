package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryScoreTest {

    @Test
    @DisplayName("추억 점수")
    public void memory_score() {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}};
        int[] answer = {19, 15, 6};

        HashMap<String, Integer> numbers = new HashMap<>();
        int[] scores = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            numbers.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            String[] persons = photo[i];
            int score = 0;

            for (int j = 0; j < persons.length; j++) {
                String person = persons[j];
                if (numbers.containsKey(person)) {
                    score += numbers.get(person);
                }
            }
            scores[i] = score;
        }

        assertThat(scores).isEqualTo(answer);
    }

}
