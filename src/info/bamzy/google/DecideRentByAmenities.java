package info.bamzy.google;

import java.util.Arrays;
import java.util.HashMap;

/**
 * you are given an array of class BuldingBlock demonstrating a list of adjacent blocks on the same street where each block has multiple amenity flags with boolean value
 * of true or false signaling if that building block has certain amenities within them, a neighbouring block
 * might have amenities that other blocks can use, but there is travel time cost added. Find one block where the
 * longest travel time to any amenity is less than other blocks. The list of desired amenities will be provided to you.
 *
 * example BuldingBlocks =
 * [
 *      {'gym':true,'store':false,'library':false,'yoga':true},
 *      {'gym':false,'store':true,'library':false,'yoga':false},
 *      {'gym':false,'store':false,'library':true,'yoga':false}
 *] and amenities = ['gym','store','library']
 * answer: block index:1 with the longest distance time of 1 block
 */
public class DecideRentByAmenities {
    public static class BuildingBlock {
        private HashMap<String,Boolean> amenities;
        public BuildingBlock(HashMap<String,Boolean> amenities){
            this.amenities = amenities;

        }
        public HashMap<String,Boolean> getAmenities(){return this.amenities;}
    }
    public int solve(BuildingBlock[] blocks, String[] amenities){
        Integer[][] map = new Integer[amenities.length][blocks.length];
        for(int j=0;j<amenities.length;j++){
            for (int i=0;i<blocks.length;i++){
                if(blocks[i].getAmenities().get(amenities[j])) map[j][i] = 0;
            }
        }
//        for(int j = 0;j<amenities.length;j++){
//            for (int i=0;i<blocks.length;i++){
//                if(map[j][i] == null) map[j][i] = findShortestFor(map,j,i);
//            }
//        }
        for(int j= 0 ; j< amenities.length;j++) populateShortestDistanceWithOofN(map[j]);
        Integer[] maxes = new Integer[map[0].length];
        for(int i = 0 ; i<map[0].length;i++){
            int thisMax = -1;
            for (int j = 0; j< map.length; j++){
                if (map[j][i]!=null) thisMax = Math.max(thisMax,map[j][i]);
            }
            if(thisMax != -1) maxes[i] = thisMax;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0 ; i < maxes.length ; i++){
            if (maxes[i]!=null) {
                if (maxes[i]<min) {
                    min = maxes[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    private int findShortestFor(Integer[][] map, int j , int i){
        Integer min = map[j][i];

        for(int k=0 ;k < map[j].length;k++){
            if(k==i) continue;
            if(map[j][k] != null && map[j][k]==0){
                if(min==null) min=Math.abs(k-i);
                else min = Math.min(min,Math.abs(k-i));
            }
        }
        return min;
    }
/**
 * |------------------------------------------------------------------------------|
 * | null | 0 | null | null | 0 | null | 0 | null | null | null | null | 0 | null |
 * |------------------------------------------------------------------------------|
 * **/
    public void populateShortestDistanceWithOofN(Integer[] map){
        Integer distance = null;
        for(int i =0;i<map.length;i++){
            if (map[i]!= null && map[i]==0) {
                distance =1;

            }
            else  {
                if(distance!= null ) {
                    map[i] = distance;
                    distance++;
                }
            }

        }
//        null,0,1,2,0,1,0,1,2,3,4,0,1
        distance = null;
        for(int i= map.length-1; i>=0; i--){
            if(map[i] != null && map[i] == 0) {
                distance=1;
            } else {
                if(distance!=null){
                    if(map[i]==null) map[i]=distance;
                    else map[i] = Math.min(map[i],distance);
                    distance++;
                }
            }
        }
        System.out.println(Arrays.toString(map));
    }
    public static void runTest(){
        DecideRentByAmenities dra = new DecideRentByAmenities();
        BuildingBlock[] blocks = new BuildingBlock[3];
        HashMap<String,Boolean> bzeora = new HashMap<String,Boolean>();
        bzeora.put("gym",true);
        bzeora.put("store",false);
        bzeora.put("library",false);
        blocks[0] = new BuildingBlock(bzeora);

        HashMap<String,Boolean> bonea = new HashMap<String,Boolean>();
        bonea.put("gym",false);
        bonea.put("store",true);
        bonea.put("library",false);
        blocks[1] = new BuildingBlock(bonea);

        HashMap<String,Boolean> btwoa = new HashMap<String,Boolean>();
        btwoa.put("gym",false);
        btwoa.put("store",false);
        btwoa.put("library",true);
        blocks[2] = new BuildingBlock(btwoa);
        System.out.println("result:" +dra.solve(blocks,new String[]{"gym","store","library"}));

        dra.populateShortestDistanceWithOofN(new Integer[]{null , null , null ,  null});
        dra.populateShortestDistanceWithOofN(new Integer[]{null , 0 , null , null , 0 , null , 0 , null , null , null , null , 0 , null });
    }
}
