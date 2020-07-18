class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0) return count;

        int nr = grid.length;
        int nc = grid[0].length;

        //遍历二维数组，每次碰到1则递增岛屿数量，然后把该岛屿消除
        //特别注意，如果使用LinkedList，需要addFirst，removeFist；
        //如果使用 addLast + removeFist 则会有重复入队列的问题
        for(int i = 0 ; i < nr ; i++){
            for( int j = 0 ; j < nc; j++){
                if(grid[i][j] == '1'){

                    count++;
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.addFirst( i * nc + j );
                    //以广度优先遍历方法消除该小岛
                    while(list.size() > 0){
                        int size = list.size();
                        int val = list.removeFirst();
                        int row = val / nc;
                        int col = val % nc;

                        grid[row][col] = '0';
                        if( col + 1 < nc && grid[row][col + 1] == '1') list.addFirst( row * nc + (col + 1));
                        if( col - 1 >= 0 && grid[row][col - 1] == '1') list.addFirst( row * nc + (col - 1));
                        if( row + 1 < nr && grid[row + 1][col] == '1') list.addFirst( (row + 1) * nc + col);
                        if( row -1 >=  0 && grid[row - 1][col] == '1') list.addFirst( (row - 1) * nc + col);
                    }
                }
            }
        }

        return count;
    }
}


