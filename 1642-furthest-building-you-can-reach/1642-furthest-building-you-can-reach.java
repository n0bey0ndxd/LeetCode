class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i + 1 < heights.length; i++){
            if (heights[i + 1] > heights[i]){
                int h = heights[i + 1] - heights[i];
                bricks -= h;
                heap.add(h);
                
                if (bricks < 0){
                    if (ladders == 0){
                        return i;
                    }
                    
                    ladders--;
                    bricks += heap.poll();
                }
            }
        }
        
        return heights.length - 1;
    }
}