package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KnightsTest {

    @Test
    @DisplayName("기사단원의 무기")
    public void knights_weapon() {
        int number = 5;
        int limit = 3;
        int power = 2;
        int result = 10;
        int answer = 0;

        int[] count = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }

        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }

        assertThat(answer).isEqualTo(result);
    }

}
