package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberPartnerTest {

    @Test
    @DisplayName("숫자 짝꿍")
    public void numberPartner() {
        String X = "12321";
        String Y = "42531";
        String result = "321";
        String answer = "";

        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (String key : X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }

        for (String key : Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }

        for (String key : xMap.keySet()) {
            if (!yMap.containsKey(key)) {
                continue;
            }

//            int length = Math.min(xMap.get(key), yMap.get(key));
            list.add(key);
        }

        answer = list.stream()
                     .sorted(Collections.reverseOrder())
                     .collect(Collectors.joining());

        if (answer.isEmpty()) {
            answer = "-1";
        }
        if (answer.replaceAll("0", "").isEmpty()) {
            answer = "0";
        }

        assertThat(answer).isEqualTo(result);

    }
}
