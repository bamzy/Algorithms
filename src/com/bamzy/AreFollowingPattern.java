package com.bamzy;
/*Given an array strings, determine whether it follows the sequence
given in the patterns array. In other words, there should be no i and j for
which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which
strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output
should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the
output should be
areFollowingPatterns(strings, patterns) = false.*/
public class AreFollowingPattern {
    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        for (int i = 0 ; i < strings.length-1  ; i++){
            for (int j = i + 1  ; j < strings.length ; j++){
                if ((strings[i].equals(strings[j]) && !patterns[i].equals(patterns[j]))
                        || (!strings[i].equals(strings[j]) && patterns[i].equals(patterns[j])))
                        return false;
            }
        }
        return true;
    }

}
