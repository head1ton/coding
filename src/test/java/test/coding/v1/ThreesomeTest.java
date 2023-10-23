package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreesomeTest {

    @Test
    @DisplayName("삼총사")
    public void threesome() {
        int[] number = {-2, 3, 0, 2, -5};
        int result = 2;
        int answer = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        assertThat(answer).isEqualTo(result);
    }

}
