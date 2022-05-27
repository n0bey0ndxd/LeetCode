class Solution {
public:
    int numberOfSteps(int num) {
        if (num < 2) {
		    return num;
        }

        return numberOfSteps(num / 2) + (num % 2 == 0 ? 1 : 2);
    }
};