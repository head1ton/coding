package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaintOverTest {

    @Test
    @DisplayName("덧칠하기")
    public void paint_over() {
        int n = 8;      // 구간
        int m = 4;      // 롤러의 길이
        int[] section = {2, 3, 6};  // 덧칠 부분
        int result = 2;         // 칠을 하는 횟수
        int answer = 0;

//        System.out.println(String.valueOf(section[0]));
        int cnt = 1;
        int roller = section[0];
        for (int i = 1; i < section.length; i++) {
            if (roller + m - 1 < section[i]) {
                cnt++;
                roller = section[i];
            }
        }
        assertThat(cnt).isEqualTo(result);
    }

    @Test
    @DisplayName("덧칠하기1")
    public void paint_over1() {
        int n = 8;      // 구간
        int m = 4;      // 롤러의 길이
        int[] section = {2, 3, 6};  // 덧칠 부분
        int result = 2;         // 칠을 하는 횟수
        int answer = 0;
        int max = 0;

        // max 는 롤러 + section 구간
        // max 보다 크다면 answer(칠하는 수)를 1씩 늘여줌
        for (int i = 0; i < section.length; i++) {
            if (section[i] < max) {
                continue;
            }

            answer++;
            max = section[i] + m;
        }

        assertThat(answer).isEqualTo(result);
    }
}
