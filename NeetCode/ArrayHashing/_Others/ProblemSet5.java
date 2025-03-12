package _Others;
import java.util.HashMap;
import java.util.Map;

public class ProblemSet5 {
    // Problem 1: Sort colors

    // Brute force : Count number of zeroes and ones and then insert the same amount

    /*
     * Method 1: Placing 0 and 1 at its right position would mean 2 gets to its
     * right position
     * TC O(N)
     * SC O(1)
     */
    public void sortColorsI(int[] nums) {
        int i = 0;

        // zero put in place
        for (int j = 0; j < nums.length && i < nums.length; j++) {
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        // one put in place and we will automatically take care of the rest
        for (int j = i; j < nums.length && i < nums.length; j++) {
            if (nums[j] == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

    }

    /*
     * Method 2: Dutch national flag algorithm - using a single pass
     * TC: O(N)
     * SC: O(1)
     */
    public void sortColorsII(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                nums[mid] = nums[left];
                nums[left] = 0;
                mid++;
                left++;
            } else if (nums[mid] == 2) {
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            } else
                mid++;
        }
    }

    // Problem 2: Maximum score after splitting a string

    /*
     * Method 1: We can say that it's a dynamic sliding window or also prefix sum
     * kind of
     * TC: O(n)
     * SC: O(1)
     */
    public int maxScoreI(String s) {
        int zero_char = 0;
        int one_char = 0;

        int max_score = -1;

        // counting total ones
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                one_char++;

        }

        // making the window bigger from left side and counting the number of zeroes
        // while also keeping count of the total number of ones in the right window.
        // Also, since you want to have 2 non empty strings always, we can only go till
        // n-1
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                zero_char++;
            if (s.charAt(i) == '1')
                one_char--;

            max_score = Math.max(max_score, zero_char + one_char);
        }

        return max_score;

    }

    // Problem 3: Unique email addresses

    /*
     * Method 1: Brute force
     * TC: O(N * M) where n is the length of the array and m is the average length
     * of the string
     * SC: O(N)
     */
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> map = new HashMap<>();

        StringBuilder str;

        for (int i = 0; i < emails.length; i++) {
            String s = emails[i];
            str = new StringBuilder();

            boolean isPlus = false;
            boolean isAtSymbol = false;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '@')
                    isAtSymbol = true;

                if (!isAtSymbol && isPlus)
                    continue;

                if (s.charAt(j) == '+' && !isAtSymbol) {
                    isPlus = true;
                    continue;
                }

                if (s.charAt(j) == '.' && !isAtSymbol)
                    continue;

                str.append(s.charAt(j));
            }

            map.put(str.toString(), 1);

        }
        return map.size();
    }
}
