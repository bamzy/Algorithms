package info.bamzy;

import java.util.*;

public class BucketSort {


    public double[] sort(double[] source, int n){
        double[] values = new double[source.length];
        Map<Integer,LinkedList<Double>> buckets = new HashMap<>();
        for (double value : source) {
            int bi = (int) (value * n);
            if (buckets.get(bi) == null)
                buckets.put(bi, new LinkedList<>());
            buckets.get(bi).add(value);
        }
        for (Integer integer : buckets.keySet()) {
            Collections.sort(buckets.get(integer));

        }

        int index = 0;
        for (Integer integer : buckets.keySet()) {
            for (Double aLong : buckets.get(integer)) {
                values[index++] = aLong;
            }
        }
        return values;

    }
}
