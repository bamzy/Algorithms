package info.bamzy;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */
public class KokoBananaEating {
    int res;
    Integer[] minSpeedsPerHours;
    public int minEatingSpeed(int[] piles, int hours){

        Integer solution = Integer.MAX_VALUE;

        int max = findMax(piles);
//        System.out.println("max:"+max);
        int l=0, r=max;
        while(l<=r){
            int currentSeed = l+ ((r-l)/2);
//            System.out.println("l:"+l+" r:"+r + " speed:"+currentSeed );
            if(isPossible(piles,currentSeed,hours)){
                solution = Math.min(currentSeed,solution);
//                System.out.println("sol:"+solution);
                r = currentSeed-1;
            } else l = currentSeed+1;
        }
        return solution;
    }
    boolean isPossible(int[] piles,int currSpeed,int h){
        if(currSpeed==0) return false;
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            int rem = piles[i]%currSpeed==0?0:1;
            sum = sum + piles[i]/currSpeed + rem;
        }
        System.out.println("sum:"+sum);
        if(sum>h) return false;
        return true;
    }
    private int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for (int i =0 ;i < piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
//    int neededHoursBasedOnGivenSpeed(int[] piles,  int h){
//        int currMin=Integer.MAX_VALUE;
//        h = h-1;
//        int speed =
//        if(minSpeedsPerHours[h-1] == null) neededHoursBasedOnGivenSpeed(piles,speed,h);
//        if(minSpeedsPerHours[h]!= null) return minSpeedsPerHours[h];
//        for(int currSpeed = speed-1;speed>0;speed--){
//            int sum = 0;
//
//            for(int i=0;i<piles.length;i++){
//                int tmp =piles[i]/currSpeed;
//                sum = sum + tmp + ((piles[i]%currSpeed==0)?0:1);
//            }
//            currMin = Math.min(sum,currMin);
//        }
//        minSpeedsPerHours[h] = Math.min(neededHoursBasedOnGivenSpeed(piles,speed,h-1),currMin );
//        return minSpeedsPerHours[h];
////        neededHoursBasedOnGivenSpeed(piles, speed,hours-1)
////        while(int )
//    }

    public static void runTest(){
        KokoBananaEating koko = new KokoBananaEating();
        System.out.println("koko:"+koko.minEatingSpeed(new int[]{3,6,7,11},8));
    }
}
