package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CocaColaTest {

    @Test
    @DisplayName("콜라 문제")
    public void cocaColaTest() {
        int a = 2;
        int b = 1;
        int n = 20;
        int result = 19;
        int answer = 0;

        while (true) {
            if (n < a) {
                break;
            }

            answer += (n / a) * b;
            n = ((n / a) * b) + (n % a);
        }

        assertThat(answer).isEqualTo(result);
    }

}
