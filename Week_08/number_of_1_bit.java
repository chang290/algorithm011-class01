class Solution {
public:
    //循环打掉最后一个1
    int hammingWeight(uint32_t n) {
        int count = 0;
        while(n > 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
};

