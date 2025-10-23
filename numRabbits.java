class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : answers) { 
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> i : freq.entrySet()) {
            int b = i.getValue();
            int a = i.getKey();
            if (b<=(a+1)) {
                ans += a+1;
            } else {
                double v = Math.ceil(((double)b/(a+1)));
                int x = (int)v;
                ans += (x*(a+1));
            }
        }
        return ans;
    }
}
// 1 1 2 
// 1 - 2
// 1 
// 2

// 5 5 5

// 5 (rabit inside jungle) > 3 (no. of rabits said)
// add ans 5+1

// 3 3 3 3  3 3

// 3 -> 6

// 6/(3+1) = 2 

// 2*(3+1) = 8 ans





