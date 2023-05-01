package com.bamzy;

import java.util.*;

/**
 * 621. Task Scheduler
 * Medium
 * 7.9K
 * 1.6K
 * Companies
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> taskMap = new HashMap<>();
        ArrayList<Character> result = new ArrayList<>();
        for(int i =0; i<tasks.length;i++){
            if(taskMap.containsKey(tasks[i])) taskMap.put(tasks[i],taskMap.get(tasks[i])+1);
            else taskMap.put(tasks[i],1);
        }
        Comparator<Map.Entry<Character, Integer>> valueComparator = (e1, e2) -> {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return -1*v1.compareTo(v2);
        };
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(taskMap.entrySet());
        sortedList.sort( valueComparator);

        boolean allowed = false;

        int index = 0;
        while(sortedList.size()>0){

            result.add(findAllowedTask(index++,result,n,sortedList));
        }
        return result.size();
    }
    private Character findAllowedTask(int index, ArrayList<Character> result,int n,List<Map.Entry<Character,Integer>> sortedList){
        Character res;
        Integer useIndex = null;
        for(int i=0;i<sortedList.size();i++){

            Character thisKey = sortedList.get(i).getKey();
            int thisValue = sortedList.get(i).getValue();
//            if(thisValue<=0) continue;
            if(index==0) {
                useIndex = 0; break;
            }
            else {
                boolean canUse = true;
                for(int j=1;j<=n;j++){
                    if(index-j>=0){
                        if(thisKey==result.get(index-j)) {canUse=false; break;}
                    }
                }
                if(canUse) {
                    useIndex = i;
                    break;
                }
            }


        }
        if(useIndex==null) return ' ';
        res = sortedList.get(useIndex).getKey();
        sortedList.get(useIndex).setValue( sortedList.get(useIndex).getValue()-1);
        if(sortedList.get(useIndex).getValue()<=0) sortedList.remove((int)useIndex);
        return res;
    }
    public int leastInterval1(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int m = tasks.length;
        int[] cnt = new int[26];
        /* Build the count array with frequency of each task */
        for (char c: tasks) {
            cnt[c - 'A']++;
        }
        Arrays.sort(cnt);
        /* Get maximum frequency task  and calculate max idle spaces*/
        int max = cnt[25]-1;
        int spaces = max * n;

        /* Iterate over rest of the array and reduce the idle space count */
        for (int i = 24; i >= 0; i--) {
            spaces -= Math.min(max, cnt[i]);
        }
        /* Handle cases when spaces become negative */
        spaces = Math.max(0, spaces);
        return tasks.length + spaces;
    }
    public int leastInterval2(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        HashMap<Character, Integer> map=new HashMap<>();
        for(char x: tasks) map.put(x, map.getOrDefault(x, 0)+1);


        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>((e1, e2) -> e2.getValue()-e1.getValue());
        pq.addAll(map.entrySet());
        PriorityQueue<Map.Entry<Character, Integer>> tmp =new PriorityQueue<>((e1, e2) -> e2.getValue()-e1.getValue());
        int res=0;
        while(!pq.isEmpty()){
            for(int i=0; i<=n; i++){
                if(!pq.isEmpty()){
                    Map.Entry<Character, Integer> entry = pq.poll();
                    entry.setValue(entry.getValue() - 1);
                    if(entry.getValue()!=0){
                        tmp.add(entry);
                    }
                    res++;
                }else if(!tmp.isEmpty()){
                    res++;
                }else{
                    break;
                }
            }
            while(!tmp.isEmpty()){
                Map.Entry<Character, Integer> entry = tmp.poll();
                pq.add(entry);
            }
        }
        return res;
    }
    public static void runTest(){
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval2(new char[]{'A','A','A','A','A','A','B','B','B','B','B','B','C','C','C','C','C','C','D','D','D','D','D','D','E','E','E','E','F'},2));
        System.out.println(ts.leastInterval2(new char[]{'D','D','D','A','A','B','C','C','C'},2));
        System.out.println(ts.leastInterval2(new char[]{'D','D','D','C','C','C'},0));
        System.out.println(ts.leastInterval2(new char[]{'D','D','D','C','C','C'},2));
        System.out.println(ts.leastInterval2(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'},2));
    }
}
