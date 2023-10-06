package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParkWalkTest {

    private final Map<String, Integer> dx = Map.of("N", -1, "S", 1, "E", 0, "W", 0);
    private final Map<String, Integer> dy = Map.of("N", 0, "S", 0, "E", 1, "W", -1);

    @Test
    @DisplayName("공원 산책")
    public void park_walk() {

        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        int[] result = {2, 1};

        int[] answer = new int[result.length];

        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            boolean end = false;

            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");

            int nx = x + dx.get(split[0]) * Integer.parseInt(split[1]);
            int ny = y + dy.get(split[0]) * Integer.parseInt(split[1]);

            if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()) {
                continue;
            }

            boolean end = false;

            for (int i = 1; i <= Integer.parseInt(split[1]); i++) {
                if (park[x + i * dx.get(split[0])].charAt(y + i * dy.get(split[0])) == 'X') {
                    end = true;
                    break;
                }
            }

            if (end) {
                continue;
            }

            x = nx;
            y = ny;

        }

        assertThat(new int[]{x, y}).isEqualTo(result);

    }
}
