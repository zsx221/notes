今日一问：hashCode()函数是用来在哈希表中将对象映射成int值的，然后通过这个int值计算出哈希值从而确定其在哈希表里的位置。
    在hashmap中：
        static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
            //这里使用hashcode的高位与低位做了一次异或运算，那他的作用是什么呢？
            //Hashmap的查找以及添加的性能完全与当前哈希值所对应的长度有关，而链表的长度就是当前Hashmap所保存的数据的哈希值的个数，而Hashmap的哈希值使用的是hash(key)除以tab
            长度的余数，也就是hash(key)的低位数，所以这个方法使用高位与低位一起做了一次异或运算，能增加低位的无序程度，降低哈希值相等的可能，从而达到提升HashMap的性能的目的.
            在这里，特别注意，&和%的效果一样，都是计算余数的，而且&的效率更高
        public V put(K key, V value) {
                    return putVal(hash(key), key, value, false, true);
                }
        tab[i = (n - 1) & hash]