package com.bamzy;


import java.util.*;



public class Main {

    public static void main(String[] args) {
        MergeTwoSortedArrays mrg = new MergeTwoSortedArrays();
        long[] res = mrg.mergetwosortedarrays(new long[]{7},new long[]{1,2,4,6,8,9});
        System.out.println(Arrays.toString(res));

        MergeSort mrgs = new MergeSort();
        long[] input = {99,5,4,1,0,9999999,99997};
        long[] res2 = mrgs.solveMergeSort(input);
        System.out.println(Arrays.toString(res2));

        TwoStringPermutation tsp = new TwoStringPermutation();
        tsp.findStringPermutation("abcdeabc","abc");

        BinarySearchLC704 bs = new BinarySearchLC704(new long[]{-1,0,3,5,9,12});
        System.out.println(bs.findIndexBinarySearch(2));

        FindAllPositiveIntegerSolution fapis = new FindAllPositiveIntegerSolution();
        HashMap<Long, ArrayList<FindAllPositiveIntegerSolution.Couple>> tmp = fapis.solve(1,100);

        SortedSet<Long> keys = new TreeSet<Long>(tmp.keySet());
        for (Long name : keys) {
            String key = name.toString();
            ArrayList<FindAllPositiveIntegerSolution.Couple> couples = tmp.get(name);
            String value = "";
            for (FindAllPositiveIntegerSolution.Couple couple : couples) {
                value = value+ "("+ couple.getA()+ ","+couple.getB()+ ")-";
            }

//            System.out.println(key + " " + value);
            // do something
        }

       StringPermutationRecursive sbr = new StringPermutationRecursive();
        ArrayList<String> result = sbr.solve("abcefg");
        System.out.println(result.size()+result.toString());

        StringBuilder stb = new StringBuilder();
        System.out.println("capacity:"+stb.capacity());
        stb.append("abcdefghijklmnopqr");
        System.out.println("capacity:"+stb.capacity());
        stb.append("123");
        stb.ensureCapacity(77);
        System.out.println("capacity:"+stb.capacity());
        stb.trimToSize();
        System.out.println("capacity:"+stb.capacity());
        System.out.println("value:"+stb.toString());

        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        hm.put("a",1);
        hm.put("A",2);
        System.out.println(hm.toString());
        Character achar = 'a';
        int charint = Character.getNumericValue(achar);
        System.out.println((int)achar);
        int charint1 = Character.getNumericValue('B');
        System.out.println(charint1);


        LC658FindKClosestElement lc658 = new LC658FindKClosestElement();
        List<Integer> res658 = lc658.findClosestElements(new int[]{1,2,3,4,5},4,-1);
        System.out.println(res658.toString());
        res658.forEach((n) -> {System.out.println(n);});

        LTAssesment1Q1 ltAssesment1Q1 = new LTAssesment1Q1();
        System.out.println(ltAssesment1Q1.reverseStr("a",2));


        List<List<Integer>> connections = new ArrayList<>();
        ArrayList<Integer> element = new ArrayList<Integer>();
        element.add(0);
        element.add(1);
        connections.add(element);
        ArrayList<Integer> element1 = new ArrayList<Integer>();
        element1.add(1);
        element1.add(2);
        connections.add(element1);
        ArrayList<Integer> element2 = new ArrayList<Integer>();
        element2.add(0);
        element2.add(3);
        connections.add(element2);
        ArrayList<Integer> element3 = new ArrayList<Integer>();
        element3.add(2);
        element3.add(5);
        connections.add( element3);
        ArrayList<Integer> element4 = new ArrayList<Integer>();
        element4.add(5);
        element4.add(4);
        connections.add( element4);

        LTGoogleAssesment2 ltg3 = new LTGoogleAssesment2();

        int[] input5 = new int[]{6,7,3,2,1,-3,4,5,6,-7};

        System.out.println((ltg3.findKthSmallestElement(input5,2 )));


    }
}
