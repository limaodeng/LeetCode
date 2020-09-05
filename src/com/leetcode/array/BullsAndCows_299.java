package com.leetcode.array;


public class BullsAndCows_299 {

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        String res = getHint2(secret,guess);
        System.out.println(res);
    }

    public static String getHint(String secret, String guess) {
        int[] m = new int[128];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else ++m[secret.charAt(i)];
        }
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) != guess.charAt(i) && m[guess.charAt(i)] != 0) {
                ++cows;
                --m[guess.charAt(i)];
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static String getHint2(String secret, String guess) {
        int[] m = new int[128];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else {
                if (m[secret.charAt(i)]++ < 0) ++cows;
                if (m[guess.charAt(i)]-- > 0) ++ cows;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
