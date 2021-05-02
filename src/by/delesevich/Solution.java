package by.delesevich;

import java.util.*;

class Solution {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        list.add(String.valueOf(i) + String.valueOf(j) + String.valueOf(k) + String.valueOf(l));
                    }
                }
            }

        }

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] bulls = new int[N];
        int[] cows = new int[N];
        String[] guess = new String[N];
        for (int i = 0; i < N; i++) {
            guess[i] = in.next();
            bulls[i] = in.nextInt();
            cows[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (!(checkAll(s, guess[i], bulls[i], cows[i]))) {
                    iterator.remove();
                }
            }
        }
        System.out.println(list.get(0));
    }

    public static boolean checkAll(String str, String guess, int bullsNum, int cowsNum) {
        int numc = 0;  //счетчик коров
        int numb = 0;  //счетчик быков
        for (int i = 0; i < 4; i++) {  // проверяет быков
            if (str.charAt(i) == guess.charAt(i)) {
                numb++;
            }
        }
        for (int i = 0; i < 4; i++) {  // проверяет коров
            if (str.indexOf((guess.charAt(i))) != -1) {
                numc++;
                str = str.replaceFirst(String.valueOf(guess.charAt(i)), "X");// заменяет на Х чтобы не считывало повторно
            }
        }
        return (numb == bullsNum && (numc - numb) == cowsNum); // итоговая проверка на количество быков и коров
    }

}