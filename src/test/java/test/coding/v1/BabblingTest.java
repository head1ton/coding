package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BabblingTest {

    @Test
    @DisplayName("옹알이")
    public void babbling() {
        String[] babbling = {"aya", "yee", "u", "maa"};
        int result = 1;
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") || babbling[i].contains("mama")
                || babbling[i].contains("woowoo") || babbling[i].contains("yeye")) {
                continue;
            }

            babbling[i] = babbling[i].replace("aya", "");
            babbling[i] = babbling[i].replace("ye", "");
            babbling[i] = babbling[i].replace("woo", "");
            babbling[i] = babbling[i].replace("ma", "");
            if (babbling[i].length() == 0) {
                answer += 1;
            }

            assertThat(answer).isEqualTo(result);
        }


    }

}
