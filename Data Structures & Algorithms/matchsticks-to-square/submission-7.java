class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i : matchsticks){
            sum+=i;
        }
        if(sum%4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        return check(matchsticks, 0, sum, sides);
        
    }

    public boolean check(int[] matches, int index, int sum, int[] sides) {

        if(index == matches.length) {
            if(sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]){
                return true;
            }
            return false;
        }

        for(int i=0;i<4;i++){
            sides[i] +=matches[index];

            if(sides[i] > (sum/4)){
                sides[i] -=matches[index];
                continue;
            }
            int j = index;

            while(j>=0){
                if(matches[index] == matches[j]){
                    break;
                }
                j--;
            }

            

            if(check(matches, index+1, sum, sides)){
                return true;
            }
            sides[i] -= matches[index];
        }
        return false;

    }
}