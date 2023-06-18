package info.bamzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
Print all positive integer solutions to the equation a^3 + b^3 = c^3 + d^3
a,b,c and d are integers between 1 and 1000.

*/
public class FindAllPositiveIntegerSolution {
    public HashMap<Long,ArrayList<Couple>> solve(int min, int max){
        HashMap<Long, ArrayList<Couple>> mappings = new HashMap<>();
        for (int a=min;a<=max;a++){
            for(int b=min;b<=max;b++){
                long acube = (long) Math.pow(a,3);
                long  bcube = (long) Math.pow(b,3);
                Long sum = acube+bcube;
                Couple e = new Couple(a, b);
                if (mappings.get(sum)==null) {
                    ArrayList<Couple> tmp = new ArrayList<>();
                    tmp.add(e);
                    mappings.put(sum,tmp);
                } else mappings.get(sum).add(e);
            }

        }
        for (int c=min;c<=max;c++){
            for(int d=min;d<=max;d++){
                long ccube = (long) Math.pow(c,3);
                long  dcube = (long) Math.pow(d,3);
                Long sum = ccube+dcube;
                Couple e = new Couple(c, d);
                 mappings.get(sum).add(e);
            }

        }

        return mappings;
    }
    public class Couple {
        private long a,b;
        public Couple(long a,long b){
            this.a = a;
            this.b = b;
        }

        public long getA() {
            return a;
        }



        public long getB() {
            return b;
        }


    }
}
