class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        std::sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& lhs,
                                                        const vector<int>& rhs) {
           return lhs.back() > rhs.back(); 
        });
        
        int units(0);
        
        for (size_t i = 0u; i < boxTypes.size() && truckSize > 0; i++) {
            units += truckSize < boxTypes[i].front() ? boxTypes[i].back() * truckSize : boxTypes[i].front() * boxTypes[i].back();
            truckSize -= boxTypes[i].front();
        }
        
        return units;
    }
};