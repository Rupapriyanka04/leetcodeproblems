import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        int ans = (n - countRows(reservedSeats)) * 2;
        int i = 0;

        while (i < reservedSeats.length) {
            int row = reservedSeats[i][0];
            boolean left = true, middle = true, right = true;

            while (i < reservedSeats.length && reservedSeats[i][0] == row) {
                int s = reservedSeats[i][1];

                if (s >= 2 && s <= 5) left = false;
                if (s >= 4 && s <= 7) middle = false;
                if (s >= 6 && s <= 9) right = false;

                i++;
            }

            if (left && right)
                ans += 2;
            else if (left || middle || right)
                ans++;
        }

        return ans;
    }

    private int countRows(int[][] a) {
        if (a.length == 0) return 0;

        int count = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] != a[i - 1][0])
                count++;
        }

        return count;
    }
}