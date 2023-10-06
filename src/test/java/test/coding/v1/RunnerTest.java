package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunnerTest {

    @Test
    @DisplayName("달리기 경주")
    public void runner() {
        String[] answer = {"mumu", "kai", "mine", "soe", "poe"};
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        // "mumu" - "kai" - "soe" - "poe" - "mine"
        // "mumu" - "kai" - "mine" - "soe" - "poe"

        int n = players.length;
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = indexMap.get(calling);
            if (idx > 0) {
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;

                indexMap.put(players[idx - 1], idx - 1);
                indexMap.put(players[idx], idx);
            }
        }

        assertThat(players).isEqualTo(answer);

    }
}
