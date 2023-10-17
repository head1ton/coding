package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringDivideTest {

    @Test
    @DisplayName("문자열 나누기")
    public void stringDivide() {
        String s = "abracadabra";
        int result = 6;
        int answer = 0;
        char prev = '1';
        int same = 0;
        int diff = 0;

        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                answer++;
            } else if (prev == c) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                prev = '1';
                same = 0;
                diff = 0;
            }
        }

        assertThat(answer).isEqualTo(result);
    }
}
