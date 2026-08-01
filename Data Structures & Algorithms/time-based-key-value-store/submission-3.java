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

        while(low <= high){
            int mid = low + (high - low) /2;
            Timestamp midTime = arr.get(mid);
            if(midTime.key == timestamp){
                return midTime.value;
            } 
            if(midTime.key < timestamp){
                ans = midTime.value;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
        }
}
