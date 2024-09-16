package Java.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    // 1. Two Sum (Easy)
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> refined = new HashMap<>();

        for (int x = 0; x < numbers.length; x++) {
            if (refined.containsKey(target - numbers[x])) {
                return new int[] {x, refined.get(target - numbers[x])};
            }

            refined.put(numbers[x], x);
        }

        return new int[] {-1, -1};
    }

    // 9. Palindrome Number (Easy)
    public boolean isPalindrome(int number) {
        if (number < 0) return false;

        if (number % 10 != 0) {
            int rest = number, reverse = 0;

            while (rest != 0) {
                reverse = reverse * 10 + rest % 10;
                rest /= 10;
            }

            return number == reverse;
        } else {
            return number == 0;
        }
    }

    // 13. Roman to Integer (Easy)
    public int romanToInt(String value) {
        Map<Character, Integer> table = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;

        for (int x = value.length() - 1; x >= 0; x--) {
            if (x != 0 && table.get(value.charAt(x)) > table.get(value.charAt(x - 1))) {
                result += table.get(value.charAt(x)) - table.get(value.charAt(x - 1));
                x--;
            } else {
                result += table.get(value.charAt(x));
            }
        }

        return result;
    }

    // 14. Longest Common Prefix (Easy)
    public String longestCommonPrefix(String[] array) {
        String result = array[0];

        for (int x = 1; x < array.length; x++) {
            while (array[x].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }

    // 20. Valid Parentheses (Easy)
    public boolean isValid(String value) {
        Stack<Character> stack = new Stack<>();
        char[] open = new char[] {'(', '[', '{'};
        char[] close = new char[] {')', ']', '}'};

        for (int x = 0; x < value.length(); x++) {
            char character = value.charAt(x);
            int location = Arrays.binarySearch(open, character);

            if (location >= 0) {
                stack.push(character);
            } else {
                location = Arrays.binarySearch(close, character);

                if (!stack.empty() && stack.peek().equals(open[location])) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // 1. Two Sum (Easy)
        solution.twoSum(null, 0);

        // 9. Palindrome Number (Easy)
        solution.isPalindrome(0);

        // 13. Roman to Integer (Easy)
        solution.romanToInt(null);

        // 14. Longest Common Prefix (Easy)
        solution.longestCommonPrefix(null);

        // 20. Valid Parentheses (Easy)
        solution.isValid(null);

    }

}
