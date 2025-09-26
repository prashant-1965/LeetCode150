class LFUCache {
    private class KeyValue {
        int key;
        int freq;
        long time;

        KeyValue(int key, int freq, long time){
            this.key = key;
            this.freq = freq;
            this.time = time;
        }
    }

    private Map<Integer, KeyValue> map;
    private Map<Integer, Integer> values;
    private TreeSet<KeyValue> tree;
    private int capacity;
    private long timestamp = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.values = new HashMap<>();
        this.tree = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a.freq, b.freq);
            if (cmp != 0) return cmp;
            cmp = Long.compare(a.time, b.time);
            if (cmp != 0) return cmp;
            return Integer.compare(a.key, b.key);
        });
    }

    public int get(int key) {
        if (!values.containsKey(key)) return -1;

        KeyValue kv = map.get(key);
        tree.remove(kv);  
        kv.freq++;      
        kv.time = ++timestamp; 
        tree.add(kv);    

        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (values.containsKey(key)) {
            KeyValue kv = map.get(key);
            tree.remove(kv);
            kv.freq++;
            kv.time = ++timestamp;
            tree.add(kv);
            values.put(key, value);
            return;
        }

        if (map.size() == capacity) {
            KeyValue evict = tree.pollFirst();
            map.remove(evict.key);
            values.remove(evict.key);
        }

        KeyValue kv = new KeyValue(key, 1, ++timestamp);
        map.put(key, kv);
        values.put(key, value);
        tree.add(kv);
    }
}
