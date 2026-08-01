class TimeMap {

    public class Timestamp {
        int key;
        String value;

        public Timestamp(int k, String val){
            this.key = k;
            this.value = val;
        }
    }

    HashMap<String, ArrayList<Timestamp>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Timestamp(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Timestamp> arr = map.get(key);
        int low = 0, high = arr.size()-1;
        String ans = "";
        for(int i =0; i< arr.size();i++){
            Timestamp t = arr.get(i);
            if(t.key <= timestamp){
                ans = arr.get(i).value;
            }
        }
        return ans;
        }
}
