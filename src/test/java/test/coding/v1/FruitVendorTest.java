package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FruitVendorTest {

    @Test
    @DisplayName("과일 장수")
    public void fruitVendor() {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        int result = 8;
        int answer = 0;

        Arrays.sort(score);

        int[] tScore = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            tScore[i] = score[score.length - 1 - i];
        }
        int index = 0;

        while (true) {
            if (index >= tScore.length || index + m > tScore.length) {
                break;
            }
            answer += tScore[index + m - 1] * m;
            index += m;
        }

        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("과일 장수1")
    public void fruitVendor1() {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int result = 33;
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }

        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("과일 장수2")
    public void fruitVendor2() {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int result = 33;
        int answer = 0;

        Arrays.sort(score);
        int cnt = score.length / m;

        int curIdx = score.length - 1;

        while (cnt > 0) {
            int minValue = 10;
            for (int i = 0; i < m; i++) {
                minValue = Math.min(minValue, score[curIdx--]);
            }
            answer += minValue * m;
            cnt--;
        }

        assertThat(answer).isEqualTo(result);
    }
}
