package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordWithYouTest {

    @Test
    @DisplayName("둘만의 암호")
    public void passwordWithYou() {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    j--;
                }
            }
            answer += c;
        }

        assertThat(answer).isEqualTo("happy");
    }

    @Test
    @DisplayName("둘만의 암호1")
    public void passwordWithYou1() {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
//        String answer = "";

        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }

            answer.append(temp);
        }

        assertThat(answer.toString()).isEqualTo("happy");
    }

}
