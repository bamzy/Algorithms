package info.bamzy;

public class ICantBelieveItSorts {
    public int[] sort(int[] input){
        for(int i=0;i<input.length;i++)
            for(int j=0;j<input.length;j++)
                if(input[i]<input[j]) {
                    int tmp = input[i];
                    input[i]=input[j];
                    input[j]= tmp;
                }
        return input;
    }
}
