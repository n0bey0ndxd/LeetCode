class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int sum = 0;
        int total = 0;
        int n = cardPoints.length - k - 1;

        for (int i : cardPoints){
            total += i;
        }

        if (cardPoints.length == k){
            return total;
        }

        for (int i = 0; i < n; i++){
            sum += cardPoints[i];
        }

        for (int i = n; i < cardPoints.length; i++){
            sum += cardPoints[i];

            res = Math.max(res, total - sum);

            sum -= cardPoints[i - n];
        }

        return res;
    }
}