class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE; 
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        } 
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        } 
        int[] total = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            for (int multiple = f; multiple <= maxFactor;
                 multiple += f) {
                total[f] += freq[multiple];
            }
        } 
        ArrayList<int[]> candidates = new ArrayList<>();
        long limit = 2L * minPrice;
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = total[factor] - 1;
            if (gain > 0 && price < limit) {
                candidates.add(new int[]{price, gain});
            }
        } 
        candidates.sort((a, b) -> Integer.compare(a[0], b[0]));
        long remaining = budget;
        long answer = 0; 
        for (int[] candidate : candidates) {
            int price = candidate[0];
            long count = candidate[1];
            if (remaining < price) 
                break;
            long take = Math.min(count, remaining / price);
            answer += take * 2;
            remaining -= take * price;
        } 
        answer += remaining / minPrice;
        return (int) answer;
    }
}
