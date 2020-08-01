class Solution {

    //定义 arrs[i][j] 表示 text1[0 ~ i] 与 text2[0 ~ j] 这两个子串的最长公共子序列
    //DP函数： 
    //若 text1[i] == text2[j] 则 arrs[i][j] = arrs[i-1][j-1] + 1  由于最后一个字符相等，那么就去掉这个字符+1
    //否则 arrs[i][j] = max(arrs[i-1][j], arrs[i][j-1])
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int len1 = text1.length(), len2 = text2.length();
        //多定义一行一列，用于表示默认值0，避免后面特殊判断越界问题
        int[][] arrs = new int[len1 + 1][len2 + 1];     //java初始化的默认值为0
        for(int i = 0; i < len1 ; i++){
            for(int j = 0; j < len2; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    arrs[i + 1][j + 1] = arrs[i][j] + 1;
                }else{
                    arrs[i + 1][j + 1] = Math.max(arrs[i][j + 1],arrs[i + 1][j]);
                }
            }
        }
        return arrs[len1][len2];
    }
}

