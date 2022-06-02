class Solution {
public:
    double average(vector<int>& salary) {
    int accum = 0;
	int max_e = 0;
	int min_e = salary[0];

	for (auto i : salary) {
		if (i < min_e) {
			min_e = i;
		}
		else if (i > max_e) {
			max_e = i;
		}
		accum += i;
	}

	accum -= min_e + max_e;
	return static_cast<double>(accum) / (salary.size() - 2);
    }
};