package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodFightTest {

    @Test
    @DisplayName("푸드 파이트 대회")
    public void foodFight() {
        int[] food = {1, 3, 4, 6};
        String result = "1223330333221";
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < food.length; i++) {
            int division = food[i] / 2;

            for (int j = 0; j < division; j++) {
                sb.append(i);
            }
        }
        answer = sb + "0" + sb.reverse();

        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("푸드 파이터1")
    public void foodFight1() {
        int[] food = {1, 3, 4, 6};
        String result = "1223330333221";
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        assertThat(answer).isEqualTo(result);
    }

}
