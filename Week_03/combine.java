class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if(k > n) return retList;

        combineImpl(retList , new LinkedList<Integer>(), n , k , 1);
        return retList;
    }

    private void combineImpl(List<List<Integer>> retList, LinkedList<Integer> curr, int n, int k, int nBegin) {
        if(curr.size() == k){
            retList.add(new LinkedList<>(curr));
        }

        for(int i = nBegin ; i <= n ; i++){
            curr.add(i);

            combineImpl(retList, curr, n, k, i + 1);

            curr.removeLast();
        }
    }
}

