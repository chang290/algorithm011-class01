class Solution {
    //状态定义： F[i][j] 表示 第i、j位置走到Finish的路径数
    //DP方程：
    //若 i、j位置有障碍物，则 F[i][j] = 0; 否则 F[i][j] = F[i+1][j] + F[i][j+1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] arr = new int[row + 1][col + 1];    //初始化数组，默认值都是0
        arr[row][col - 1] = 1;  //只需要初始化，Finish下一行的那个位置设置为1即可。
        for(int i = row - 1; i >= 0; i--){  //从最后往前递推
            for(int j = col - 1; j >= 0; j--){
                arr[i][j] = arr[i+1][j] + arr[i][j+1];
                if(obstacleGrid[i][j] == 1) arr[i][j] = 0;
            }
        }
        return arr[0][0];
    }
}

