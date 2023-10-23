package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamburgerMakingTest {

    @Test
    @DisplayName("햄버거 만들기")
    public void hamburgerMaking() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result = 2;
        int answer = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1
                    && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 1) == 1) {

                    answer++;
//                    stack.pop();
//                    stack.pop();
//                    stack.pop();
//                    stack.pop();
                }
            }
        }

        assertThat(answer).isEqualTo(result);
    }
}
