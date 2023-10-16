package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NearestStringTest {

    @Test
    @DisplayName("가장 가까운 글자")
    public void nearestString() {
        String s = "banana";
        int[] result = {-1, -1, -1, 2, 2, 2};
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
            } else {
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        System.out.println("answer = " + answer);
        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("가장 가까운 글자1")
    public void nearestString1() {
        String s = "banana";
        int[] result = {-1, -1, -1, 2, 2, 2};
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            answer[i] = i - map.getOrDefault(ch, i + 1);
            map.put(ch, i);
        }

        assertThat(answer).isEqualTo(result);
    }
}
