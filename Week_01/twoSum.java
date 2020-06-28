class Solution {
     public int[] twoSum1(int[] nums, int target) {
         for( int i = 0; i < nums.length - 1; i++){
             for( int j = i + 1; j < nums.length; j++){
                 if( nums[i] + nums[j] == target){
                     return new int[]{i,j};
                 }
             }
         }
         return null;
     }

     public int[] twoSum2(int[] nums, int target) {

         Map<Integer,Integer> aMap = new HashMap<Integer,Integer>();
         for( int i = 0; i < nums.length; i++){
             aMap.put(nums[i],i);
         }
         for ( int i = 0; i< nums.length; i++){
             int needVal = target - nums[i];
             if(aMap.containsKey(needVal) && aMap.get(needVal) != i){
                 return new int[]{i,aMap.get(needVal)};
             }
         }
         return null;
     }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> aMap = new HashMap<Integer,Integer>();
        for( int i = 0; i < nums.length; i++){
            int needVal = target - nums[i];
            if(aMap.containsKey(needVal) && aMap.get(needVal) != i){
                return new int[]{aMap.get(needVal),i};
            }
            aMap.put(nums[i],i);
        }
        return null;
    }
}

