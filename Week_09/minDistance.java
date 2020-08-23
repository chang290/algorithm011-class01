class Solution {

    //状态定义 F[i][j] 表示 word1[0-i] 与 word2[0-j] 的编辑距离
    //DP返程  如果 word1[i] == word[j] 那么 F[i][j] = F[i-1][j-1]
    // 否则 F[i][j] = min( F[i-1][j-1], F[i-1][j], F[i][j-1] ) + 1
    // F[i-1][j-1] 表示将 word1[i] 设置为 word2[j], 反过来一样
    // F[i-1][j] 表示删除 word1[i]，删除与增加字符效果一样，因此使用删除，这样可以保证向同一个方向发展
    // F[i][j-1] 表示删除 word2[j]
    // 采用递推的方法，就需要先i、j从0开始的值计算出来
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        int len1 = word1.length(), len2 = word2.length();

        int[][] arr = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++){
            arr[i][0] = i;
        }
        for(int j = 1; j <= len2; j++){
            arr[0][j] = j;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    arr[i][j] = arr[i-1][j-1];
                }else{
                    arr[i][j] = Math.min( Math.min( arr[i-1][j-1], arr[i-1][j] ), arr[i][j-1] ) + 1;
                }
            }
        }
        return arr[len1][len2];
    }
}

