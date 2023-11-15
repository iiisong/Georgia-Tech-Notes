/* 
[5:53 PM] Katchen, Tyler W
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.

Input: [0,0,1,1,1,2,2,3,3,4]
Output: [0,1,2,3,4,_,_,_,_,_]
*/

import java.util.HashMap;

public class test {
    public static int[] test(int[] input) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        int i = 0; // entry to enter new ints
        // iterate through input
        for (int n : input) {

            // if number is new
            if (hm.get(n) == null) {
                hm.put(n, true); // make it seen
                input[i] = n; // add it to the input
                i++; // move input entry along
            }
        }

        return input;
    }


}