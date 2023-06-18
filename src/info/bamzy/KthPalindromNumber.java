package info.bamzy;

import java.util.*;

class kthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        // int rem = (intLength%2)?1:0;
        int usedLength = intLength/2+intLength%2;
    int min = (int)Math.pow(10,usedLength-1);
    System.out.println(min);
    
    List<Long> result = new ArrayList<>();
    for (int i=0;i<queries.length;i++){
        int index = queries[i];
        if(index<1) result.add(-1L);
        int val = min+index-1;
        if(Math.pow(10,usedLength+1)-1<val) {
            result.add(-1L);
            
        } else {
                String strVal = val+"";
                StringBuilder input1 = new StringBuilder();
                input1.append(strVal);
                String revStrVal = input1.reverse().toString();
                // System.out.println("strVal:"+strVal + "  index:  "+index + "  rev:"+input1);
                
                String resStr = "-1";
                if(intLength%2==1) resStr = strVal + revStrVal.substring(1);
                else resStr = strVal+revStrVal;
                long finalVal = Long.parseLong(resStr);
                if(finalVal>Math.pow(10,intLength)-1) finalVal=-1;
                result.add(finalVal);
        }
            
    }
    return result.stream().mapToLong(i -> i).toArray();
                    
    }

    private long[] checkAll(int[] queries,int intLength){
        int counter = 0;
        HashSet<Integer> palindromeIndexHash = new HashSet<>();
        HashMap<Integer,Integer> mappings = new HashMap<>();
        for (int i=0;i<queries.length;i++){
            palindromeIndexHash.add(queries[i]);
            mappings.put(queries[i],null);
        }
        List<Long> result = new ArrayList<>();
        for(int i=(int)Math.pow(10,intLength-1);i<(int)Math.pow(10,intLength);i++){
            // System.out.println("i:"+i);
            if(isPalindrome(i)) {
                    counter++;
                    // System.out.println("found palindrome at:"+counter);
                    if(palindromeIndexHash.contains(counter)) mappings.put(counter,i);
            }
            
        }
        
        for(int i=0;i<queries.length;i++)
        {
            if(mappings.get(queries[i])==null) 
                result.add(-1L); 
            else 
                result.add(new Long(queries[i]));
        }
        return result.stream().mapToLong(i -> i).toArray();
        // return Arrays.copyOf(result, result.length, Long[].class);
    
    
    }
    public boolean isPalindrome(int num){
        String tmp = num+"";
        int size = tmp.length();
        for (int i =0;i<size/2;i++){
            if(tmp.charAt(i)!=tmp.charAt(size-1-i)) return false;
        }
        return true;
}
}