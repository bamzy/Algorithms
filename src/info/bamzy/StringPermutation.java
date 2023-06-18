package info.bamzy;
/*Print all permutation of String both iterative and Recursive way?*/
import java.util.ArrayList;

public class StringPermutation {
    char[] result;
    int size ;
    public void permutate(String input){
        ArrayList<Character> characters = new ArrayList<>();
        for (int i=0 ; i< input.length() ; i++) {
            characters.add(input.charAt(i));
        }
        result = new char[characters.size()];
        size = input.length();
        dooo(characters, 0 );
    }

    public void dooo(ArrayList<Character> list, int index ){
        if (0 == list.size()){
            System.out.println(result );
            return;
        }

        for (Character character : list) {
            if (index < size )
                result[index] = character;
            ArrayList<Character> dummy = (ArrayList<Character>) list.clone();
            dummy.remove(character);
            dooo(dummy, index++);
        }
    }

    /* * A method exposed to client to calculate permutation of String in Java. */
    public void permutation(String input){
        permutation("", input);
    }
    private void permutation(String perm, String word) {
        if (word.isEmpty())
        {
            System.err.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    private void loopPermutation(String input){
        String result;
        for (int i=0; i<input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
            }
        }
    }

}
