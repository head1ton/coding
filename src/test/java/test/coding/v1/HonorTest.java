package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HonorTest {

    @Test
    @DisplayName("명예의 전당")
    public void honor() {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] result = {10, 10, 10, 20, 20, 100, 100};
        int[] answer = new int[score.length];

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < score.length; i++) {
            if (temp.size() < k) {
                temp.add(score[i]);
                Collections.sort(temp);
                answer[i] = temp.get(0);
                continue;
            }

            if (temp.size() == k) {
                int minNum = temp.get(0);

                if (minNum < score[i]) {
                    temp.remove(0);
                    temp.add(score[i]);
                    Collections.sort(temp);
                }

                answer[i] = temp.get(0);
            }
        }

        assertThat(answer).isEqualTo(result);
    }

    @Test
    @DisplayName("명예의 전당1")
    public void honor1() {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] result = {10, 10, 10, 20, 20, 100, 100};
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }

            answer[i] = queue.peek();
        }

        assertThat(answer).isEqualTo(result);
    }
}
