class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int cand1 = arr[0], cand2 = arr[0];
        int count1 = 1, count2 =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == cand1){
                count1++;
            } else if(arr[i] == cand2){
                count2++;
            } else if(count1 == 0){
                cand1 = arr[i];
                count1 = 1;
            } else if(count2 == 0){
                cand2 = arr[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == cand1) count1++;
            if(arr[i] == cand2) count2++;
        }
        if(cand1 == cand2) {
            ans.add(cand1);
            return ans;
        }
        if(count1 > (int)(arr.length/3)) ans.add(cand1);
        if(count2 > (int)(arr.length/3)) ans.add(cand2);

        return ans;
    }
}