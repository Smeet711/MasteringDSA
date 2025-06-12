// You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.

// An element a is closer to x than b if:


// |a - x| < |b - x|, or
// |a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)


// Return the k closest elements in order of closeness.

// Examples:

// Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
// Output: 3 1
// Explanation: 4 is excluded, Closest elements to 4 are: 3 (1), 1 (3). So, the 2 closest elements are: 3 1


class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
       for(int val : arr){
           if(x-val != 0){
           map.put(val,Math.abs(val - x));
           }
       }
      
        
       List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        
        entryList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            } else {
                return b.getKey() - a.getKey(); 
            }
        });

        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}