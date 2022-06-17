class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 2){
            return fruits.length;
        }

        int left = 0;
        int right = 1;
        int result = 1;

        Map<Integer, Integer> basket = new HashMap<>();
        basket.put(fruits[left], basket.getOrDefault(fruits[left], 0) + 1);

        while(right < fruits.length){
            int fruit_type = fruits[right];

            if (basket.size() != 2){
                basket.put(fruit_type, basket.getOrDefault(fruit_type, 0) + 1);
            }
            else if (basket.containsKey(fruit_type)){
                basket.put(fruit_type, basket.get(fruit_type) + 1);
            }
            else{
                while(!basket.isEmpty()){
                    int fruit_to_remove = fruits[left++];
                    int count = basket.get(fruit_to_remove);

                    if (count == 1){
                        basket.remove(fruit_to_remove);
                        basket.put(fruit_type, 1);
                        break;
                    }
                    else{
                        basket.put(fruit_to_remove, basket.get(fruit_to_remove) - 1);
                    }
                }
            }
            right++;
            result = Math.max(result, right - left);
        }

        return result;
    }
}