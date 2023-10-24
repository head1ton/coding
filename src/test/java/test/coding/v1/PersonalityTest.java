package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonalityTest {

    @Test
    @DisplayName("성격 유형 검사")
    public void personality() {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = "TCMA";
        String answer = "";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int value = choices[i];

            if (value > 0 && value < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch, 0) + 4 - value);
            } else if (value > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch, 0) + value - 4);
            }
        }

        answer = String.valueOf(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
            + (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
            + (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
            + (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');

        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("성격 유형 검사1")
    public void personality1() {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = "TCMA";
        String answer = "";

        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        Map<Character, Integer> typeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < types.length; i++) {
            typeMap.put(types[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int pos = 0;
            if (choices[i] >= 5) {
                pos = 1;
            }

            typeMap.put(survey[i].charAt(pos),
                typeMap.get(survey[i].charAt(pos)) + score[choices[i]]);
        }

        for (int i = 0; i < types.length; i += 2) {
            if (typeMap.get(types[i]) >= typeMap.get(types[i + 1])) {
                sb.append(types[i]);
            } else {
                sb.append(types[i + 1]);
            }
        }
        answer = sb.toString();

        assertThat(answer).isEqualTo(result);

    }

}
