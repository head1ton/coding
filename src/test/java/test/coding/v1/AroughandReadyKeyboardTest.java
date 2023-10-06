package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AroughandReadyKeyboardTest {

    @Test
    @DisplayName("대충만든자판")
    public void keyboard() {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        int[] result = {9, 4};

        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                map.put(key, Math.min(i + 1, map.getOrDefault(key, Integer.MAX_VALUE)));
//                System.out.println(map.getOrDefault(key, Integer.MAX_VALUE));
//                System.out.println("============");
//                System.out.println(s.charAt(i));
//                System.out.println("============");
            }
//            System.out.println(map);
        }
//        System.out.println(map);    // 최소 키보드를 누르는 형식. A = 1, B = 1, C = 2, D= 5 (SUM = 9)

        for (int i = 0; i < targets.length; i++) {
            String s = targets[i];

            for (int j = 0; j < s.length(); j++) {
                char key = s.charAt(j);

                if (map.containsKey(key)) {
//                    System.out.println("============");
//                    System.out.println(map);
//                    System.out.println(map.get(key));
//                    System.out.println("============");

                    answer[i] += map.get(key);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        assertThat(answer).isEqualTo(result);
    }
}
