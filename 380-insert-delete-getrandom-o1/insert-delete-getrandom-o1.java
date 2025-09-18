class RandomizedSet {
    public Map<Integer,Integer> map;
    public List<Integer> lt;
    public Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        lt=  new ArrayList<>();
        rand = new Random();

    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        lt.add(val);
        map.put(val,lt.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx  = map.get(val);
        lt.set(idx,lt.get(lt.size()-1));
        map.put(lt.get(idx),idx);
        lt.remove(lt.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return lt.get(rand.nextInt(lt.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */