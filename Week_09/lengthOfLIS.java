class Solution {
    //状态定义 f[i] 表示以 nums[i] 未结尾最长上升子序列
    //DP方程 f[i] = max(1 + f[j] ) 其中 j 为在 0~i-1 之中 nums[j] < nums[i]
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) arr[i] = 1;
        int ret = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    arr[i] = Math.max( arr[i], (arr[j] + 1) );
                }
            }
            ret = Math.max( ret, arr[i] );   //记录下最大的那个值
        }

        return ret;
    }
}

