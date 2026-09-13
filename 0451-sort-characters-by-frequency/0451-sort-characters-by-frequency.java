import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // Store characters
        Character[] chars = new Character[62];
        int k = 0;

        for (char c : s.toCharArray()) {
            if (freq[c] > 0) {
                chars[k++] = c;
                freq[c] = -freq[c]; // mark as added
            }
        }

        // Sort by frequency
        Arrays.sort(chars, 0, k, (a, b) ->
            Integer.compare(Math.abs(freq[b]), Math.abs(freq[a]))
        );

        // Build result
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < k; i++) {
            char c = chars[i];

            for (int j = 0; j < Math.abs(freq[c]); j++) {
                res.append(c);
            }
        }

        return res.toString();
    }
}