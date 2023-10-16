package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDummyTest {


    @Test
    @DisplayName("카드 뭉치")
    public void cardDummy() {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = "Yes";

        int one = 0;
        int two = 0;

        int i = 0;
        while (i < goal.length) {
            if (one < cards1.length && goal[i].equals(cards1[one])) {
                one++;
            } else if (two < cards2.length && goal[i].equals(cards2[two])) {
                two++;
            } else {
                answer = "No";
                break;
            }
            i++;
        }

        assertThat(answer).isEqualTo("Yes");
    }

    @Test
    @DisplayName("카드 뭉치1")
    public void cardDummy1() {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = "Yes";

        List<String> cardList1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> cardList2 = new ArrayList<>(Arrays.asList(cards2));

        for (String str : goal) {
            if (!cardList1.isEmpty() && cardList1.get(0).equals(str)) {
                cardList1.remove(0);
            } else if (!cardList2.isEmpty() && cardList2.get(0).equals(str)) {
                cardList2.remove(0);
            } else {
                answer = "No";
                break;
            }
        }
        assertThat(answer).isEqualTo("Yes");
    }

}
