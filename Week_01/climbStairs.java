class Solution {
    public int climbStairs(int n) {
	//当层数为0、1、2 时，就是n种方法
        if ( n <= 2) return n;

	//定义3个遍历，向后遍历
        int f1 = 1, f2 = 2, f3 = 3;
        for ( int i = 3; i <= n ; ++i ){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}

