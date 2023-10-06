package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WallpaperCleanTest {

    @Test
    @DisplayName("바탕화면 정리")
    public void wallpaper_clean() {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] result = {0, 1, 3, 4};
        int[] answer = {};

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        answer = new int[]{minX, minY, maxX + 1, maxY + 1};     // +1 은 끝점을 선택해야 하기 때문에 1을 더해준다.

        assertThat(answer).isEqualTo(result);
    }
}
