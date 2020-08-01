class Solution {

    //定义 arrs[i][j] 表示从初始位置到达 m,n 的不同路径数
    //动态方程：arrs[i][j] = arrs[i+1][j] + arrs[i][j+1]
    //根据定义最后一行与最后一列都为1
    public int uniquePaths1(int m, int n) {

        int[][] arrs = new int[m][n];

        ///将最后一行全部设置为1
        for(int col = 0 ; col < n ; col++) arrs[m-1][col] = 1;
        ///将最后一列全部设置为1
        for(int row = 0 ; row < m ; row++) arrs[row][n-1] = 1;

        for(int i = m - 2 ; i >= 0 ; i--){  ///从倒数第二行向0行遍历
            for( int j = n - 2; j >= 0 ; j--){
                arrs[i][j] = arrs[i + 1][j] + arrs[i][j+1];
            }
        }

        return arrs[0][0];
    }

    //此处进一步优化内存使用，只需要使用额外n个元素的存储空间
    //定义n大小的数组用于存储一行，先初始化最后一行
    //那么倒数第二行，可以继续使用这个数据，就相当于把下一行的值直接加进来了
    //对于倒数第二行，最后一个数，不需要加右边数据，因为他的右边为空，因此只要从倒数第二个进行遍历即可
    public int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr,1);

        for(int i = m - 2; i >= 0 ; i--){
            for(int j = n - 2; j >= 0 ; j--){
                arr[j] += arr[j + 1];
            }
        }
        return arr[0];
    }

}

