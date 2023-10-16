package test.coding.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrivateValidateTest {


    @Test
    @DisplayName("개인정보 수집 유효기간")
    public void privateValidity() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = {1, 3};
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> expireDate = new HashMap<>();
        for (String term : terms) {
            String type = term.split(" ")[0];
            int date = Integer.parseInt(term.split(" ")[1]);
            expireDate.put(type, date);
        }
//        System.out.println("expireDate = " + expireDate);

        int todayInt = Integer.parseInt(today.replace(".", ""));
//        System.out.println("todayInt = " + todayInt);

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            int date = Integer.parseInt(privacy.split(" ")[0].replace(".", ""));
            String type = privacy.split(" ")[1];

            int year = date / 10000;
            int month = (date % 10000) / 100;
            int day = date % 100;
//            System.out.println("day = " + day);

            month += expireDate.get(type);
            day -= 1;

            if (day == 0) {
                month -= 1;
                day += 28;
            }
            if (month > 12) {
                year += (month / 12);
                month = month - 12 * (month / 12);
            }
            if (month == 0) {
                month = 12;
                year -= 1;
            }

            date = year * 10000 + month * 100 + day;

            if (date < todayInt) {
                answer.add(i);
            }
        }

        int[] answerArr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i) + 1;
        }

        assertThat(answerArr).isEqualTo(result);
    }

    @Test
    @DisplayName("개인정보 수집 유효기간1")
    public void privateValidity1() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = {1, 3};

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }

        int[] array = answer.stream().mapToInt(i -> i).toArray();
        assertThat(array).isEqualTo(result);
    }

    private int getDate(final String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
