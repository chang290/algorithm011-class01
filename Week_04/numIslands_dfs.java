class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;

        int nr = grid.length;
        int nc = grid[0].length;

        for( int i = 0 ; i < nr ; i++){
            for( int j = 0 ; j < nc ; j++){
                if( grid[i][j] == '1' ){
                    count++;
                    ///深度优先遍历清除该岛屿

                    numIsLandsDfs(grid, i, j);
                }

            }
        }


        return count;
    }

    public void numIsLandsDfs(char[][] grid, int row, int col){
        //终止条件
        if( row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0') return;

        grid[row][col] = '0';

        numIsLandsDfs(grid, row, col + 1);
        numIsLandsDfs(grid, row, col - 1);
        numIsLandsDfs(grid, row + 1, col);
        numIsLandsDfs(grid, row - 1, col);
    }


}

