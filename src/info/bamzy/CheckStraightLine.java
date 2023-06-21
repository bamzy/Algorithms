package info.bamzy;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 * Example 1:
 *Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if(len==0) return false;
        int[] prev = coordinates[0];
        Double prevAngle = null;
        double angle = Integer.MAX_VALUE;
        for(int i=1;i<len;i++){
            int[] current = coordinates[i];

            if(current[0]-prev[0]!=0) angle = (double)(current[1]-prev[1])/(double)(current[0]-prev[0]);
            else angle = Integer.MAX_VALUE;
            if(prevAngle!=null){
                if(angle!=prevAngle) return false;
            }
            prev = current;
            prevAngle = angle;
        }
        return true;
    }
}
