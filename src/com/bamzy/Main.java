package com.bamzy;

public class Main {
    public static void main(String[] args) {
           BucketSort bucketSort = new BucketSort();
        System.out.println(bucketSort.sort(new double[]{0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.33,0.68},10));
    }
}
