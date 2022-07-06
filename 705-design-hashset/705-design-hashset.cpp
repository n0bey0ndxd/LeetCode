class MyHashSet {
private:
    std::vector<int> data;
public:
    MyHashSet() 
    :
        data(std::vector<int>(1'000'001, -1))
    {}
    
    void add(int key) {
        data[key] = key;
    }
    
    void remove(int key) {
        data[key] = -1;
    }
    
    bool contains(int key) {
        return data[key] != -1;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */