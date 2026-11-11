class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length-1;
        int boat = 0;
        while(low <= high){
            if(people[low]+people[high] <= limit){
                boat++;
                low++;
                high--;
            } else if(people[high] <= limit){
                boat++;
                high--;
            } else if(people[low] <= limit) {
                boat++;
                low++;
            }
        }
        return boat;
    }
}