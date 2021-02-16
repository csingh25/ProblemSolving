class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.cache=new LinkedHashMap<Integer,Integer>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
      int val= -1;
      if (cache.containsKey(key) ){
          val = cache.get(key);
          cache.remove(key);
          cache.put(key,val);            
      }
      return val;
        
    }
    
    public void put(int key, int value) {
        if (cache.size()==capacity && !cache.containsKey(key)){
            Iterator itr=cache.keySet().iterator();
            cache.remove(itr.next());                
        }else if (cache.containsKey(key)){
            cache.remove(key);
        }
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */