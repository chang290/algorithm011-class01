public class Solution {
    // you need treat n as an unsigned value
    // 注意反转是指将 n 中的 第0位放到 ret 的第31位
    // 因此整体思路就是，每次取n的最低位，放到ret的指定位即可，然后将n向后移动一位
    public int reverseBits(int n) {
        int ret = 0, step = 31;
        while(step >= 0){
            ret += ((n & 1) << step);
            n = n >> 1; //将n向右移动一位
            step--;     //相应得修改对应位置
        }
        return ret;
    }
}

