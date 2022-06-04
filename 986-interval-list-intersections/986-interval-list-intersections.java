class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;

        List<int[]> ans = new ArrayList<>();

        final int first = 0;
        final int last = 1;

        while(i < n && j < m){
            if (firstList[i][first] == secondList[j][first]
                && firstList[i][last] == secondList[j][last]){
                ans.add(IntStream.of(firstList[i][first], firstList[i][last]).toArray());
                i++;
                j++;
            }
            else if (firstList[i][first] == secondList[j][last]){
                ans.add(IntStream.of(secondList[j][last], secondList[j][last]).toArray());
                j++;
            }
            else if (firstList[i][last] == secondList[j][first]){
                ans.add(IntStream.of(firstList[i][last], firstList[i][last]).toArray());
                i++;
            }
            else if(firstList[i][last] <= secondList[j][last]){
                if (firstList[i][last] >= secondList[j][first]){
                    int f = Math.max(firstList[i][first],secondList[j][first]);

                    ans.add(IntStream.of(f, firstList[i][last]).toArray());
                }
                i++;
            }
            else if(firstList[i][last] >= secondList[j][last]){
                if (secondList[j][last] >= firstList[i][first]){
                    int f = Math.max(firstList[i][first],secondList[j][first]);

                    ans.add(IntStream.of(f, secondList[j][last]).toArray());
                }
                j++;
            }
        }

        int[][] res = new int[ans.size()][2];
        for (int k = 0; k < res.length; k++){
            res[k] = ans.get(k);
        }

        return res;
    }
}