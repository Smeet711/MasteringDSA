// Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.

// Examples:

// Input: arr[] = [1, 2, 5, 9], k = 6
// Output: 5
// Explanation: 5 is the smallest divisor having sum of quotients (1 + 1 + 1 + 2 = 5) less than or equal to 6.


class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int n = arr.length;
        int start = 1;
        int end = arr[n-1];
        int ans = Integer.MAX_VALUE;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            int sum = getSum(arr,mid);
            
            if(sum > k){
                start = mid + 1;
            }
            else{
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    private int getSum(int[] arr, int div){
        
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            sum += (int)Math.ceil((double)arr[i]/div);
        }
        
        return sum;
        
    }
}