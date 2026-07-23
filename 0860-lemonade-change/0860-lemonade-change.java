class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        for(int i : bills){
            if(i==5){
                five++;
                continue;
            }

            if(i==10){
                if(five < 1) return false;
                five--;
                ten++;
                continue;
            }

            if(five>=1 && ten>=1 ){
                five--;
                ten--;
            }else{
                if(five<3){
                    return false;
                }else{
                    five-=3;
                }
            }
        }

        return true;
        
    }
}