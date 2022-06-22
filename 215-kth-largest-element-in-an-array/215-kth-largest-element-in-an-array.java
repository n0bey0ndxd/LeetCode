class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p_q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int item : nums){
            p_q.add(item);
        }
        
        while(k-- != 1){
            p_q.poll();
        }
        
        return p_q.peek();
    }
}