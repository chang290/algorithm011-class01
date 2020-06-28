class Solution {

    //暴力法
    //使用一个for循环向前遍历，从当前节点向左右查找边界，若能够找到一个合法边界
    //则计算盛水量，然后向右跳到右边界，继续遍历
    public int trap1(int[] height) {
        int total = 0, maxLeft = 0, maxRight = 0;
        for( int i = 0; i < height.length; i++){
            maxLeft = maxRight = 0;
            for(int j = i; j >= 0; --j){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int j = i; j < height.length; j++){
                maxRight = Math.max(maxRight, height[j]);
            }

            total += (Math.min(maxLeft, maxRight) - height[i]);
        }
        return total;
    }

    //对上述方法的优化实现，前述暴力法，每次需要左右扫描来确定leftMax和rightMax
    //可以通过两次遍历，将所有的leftMax和rightMax预先算好，后面直接查找即可。
    public int trap2(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int total = 0, maxLeft = 0, maxRight = 0;
        int[] leftList = new int[height.length];
        int[] rightList = new int[height.length];

        leftList[0] = height[0];
        rightList[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; ++i){
            leftList[i] = Math.max( leftList[i - 1], height[i]);
        }
        for(int i = height.length - 2; i >= 0 ; --i){
            rightList[i] = Math.max( rightList[i + 1], height[i]);
        }

        for( int i = 0; i < height.length; ++i){
            total += (Math.min( leftList[i], rightList[i] ) - height[i]);
        }

        return total;
    }

    //使用栈来实现
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int total = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < height.length; ++i){
            while( stack.size() > 1 && height[i] > height[stack.peek()] ){
                int idx = stack.pop();
                if(stack.peek() == -1) continue;
                total += ((Math.min( height[stack.peek()], height[i] ) - height[idx]) * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return total;
    }
}

