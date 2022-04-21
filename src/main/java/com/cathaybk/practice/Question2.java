package com.cathaybk.practice;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author RogerLo
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA"
 * All letters in this word are not capitals, like "leetcode"
 * Only the first letter in this word is capital, like "Google"
 * Given a string word, return true if the usage of capitals in it is right.
 * Example 1:
 * Input: word = "USA"
 * Output: true
 * Example 2:
 * Input: word = "FlaG"
 * Output: false
 * Constraints:
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
public class Question2 {

    public static void main(String[] args) {
        System.out.println(checkWord("USA"));
        System.out.println(checkWord("leetcode"));
        System.out.println(checkWord("Google"));
        System.out.println(checkWord("FlaG"));
    }

    public static boolean isUppercase(char ch) {
        return ((int) ch) >= ((int) 'A') && ((int) ch) <= ((int) 'Z');
    }

    public static boolean checkWord(String word) {
        char[] chars = word.toCharArray();
        int ll = chars.length;

        int upperCount = 0;
        int lowerCount = 0;
        for (char ch : chars) {
            if (isUppercase(ch)) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }

        if (upperCount == ll) { // 全大寫
            return true;
        }
        if (upperCount == 0) { // 全小寫
            return true;
        }

        if (isUppercase(chars[0])) {
            if (isUppercase(chars[ll - 1])) {
                if (ll > 2) {
                    return isUppercase(chars[1]) == false ? false : true;
                }
            }

            if (lowerCount == chars.length - 1) {
                return true;
            }
        }

        return false;
    }
}
