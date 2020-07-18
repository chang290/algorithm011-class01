class Solution {
       //1. 将每个单词构建一个链接表
    //2. 广度优先搜索
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( wordList == null ) return 0;

        ///原始单词 -> 可转换的星单词列表
        Map<String, List< String > > starMap = new HashMap<>();

        //星单词 -> 原始单词列表
        Map<String, List< String > > linkedMap = new HashMap<>();

        for(String word : wordList){
            List<String> starList = getStarStrings(word);
            starMap.put(word,starList);
            for(String starStr : starList){
                if(linkedMap.get(starStr) == null){
                    linkedMap.put(starStr, new ArrayList<String>());
                }
                //构建一个星单词到原始单词的映射
                linkedMap.get(starStr).add(word);
            }
        }

        //采用广度优先搜索
        LinkedList<String> list = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        list.addLast(beginWord);
        int length = 1;

        while(list.size() > 0){
            length++;

            ///遍历一层
            int size = list.size();
            for(int i = 0; i < size ; i++){
                String word = list.removeFirst();

                //避免循环访问
                if( visited.contains( word ) ) continue;
                visited.add(word);
                
                //取到当前单词星链
                List<String> starList = getStarStrings( word );

                //遍历星链，根据星单词去进行向后遍历
                for(String star : starList){
                    List<String> links = linkedMap.get( star );
                    if( links == null ) continue;
                    for( String linkStr : links){
                        if(linkStr.equals( endWord )) return length;
                        list.addLast(linkStr);
                    }
                }
            }
        }

        return 0;
    }

    public List<String> getStarStrings(String str){
        List<String> starStrs = new ArrayList<String>();
        for( int i = 0; i < str.length(); i++){
            char[] arr = str.toCharArray();
            arr[i] = '*';
            starStrs.add(new String( arr ));
        }
        return starStrs;
    }
}

