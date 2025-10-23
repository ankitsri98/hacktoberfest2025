class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // First, count distinct elements in the whole array
        HashSet<Integer> distinct = new HashSet<>();
        for(int num : nums) {
            distinct.add(num);
        }
        int totalDistinct = distinct.size();
        
        // Initialize variables
        int count = 0;
        HashMap<Integer, Integer> windowMap = new HashMap<>();
        int left = 0;
        
        // Iterate through array using sliding window
        for(int right = 0; right < nums.length; right++) {
            // Add current element to window
            windowMap.put(nums[right], windowMap.getOrDefault(nums[right], 0) + 1);
            
            // While window has all distinct elements
            while(windowMap.size() == totalDistinct) {
                // Add count of all possible subarrays ending at 'right'
                count += nums.length - right;
                
                // Remove leftmost element
                windowMap.put(nums[left], windowMap.get(nums[left]) - 1);
                if(windowMap.get(nums[left]) == 0) {
                    windowMap.remove(nums[left]);
                }
                left++;
            }
        }
        
        return count;
    }
}
