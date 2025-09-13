class LRUCache {
    private int capacity;
    private Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        if(map.containsKey(key)) return map.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key,value);
        if(map.size()>capacity){
            int peek=0;
            for(int i:map.keySet()){
                peek = i;
                break;
            }
            map.remove(peek);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */