学习笔记
#### 岛屿数量
在解岛屿数量时，使用了广度优先搜索。开始时使用一个LinkedList来保存待访问的元素，采用 addLast与removeFist的方式来搜索。
这是就会出现有些节点被重复加入到LinkedList的情况。
