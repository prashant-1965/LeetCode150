class Solution {
    public static Integer[] dp;
    public int climbStairs(int n) {
        int val0 = 0;
        int val1 = 1,temp;
        for(int i=2;i<=n;i++){
            temp = val0+val1;
            val0 = val1;
            val1 = temp;

        }
        return val0+val1;
    }
}


// class Solution {
//     public int climbStairs(int n) {
//         int val1  = 0,val2 = 1,temp;
//         for(int i=2;i<=n;i++){
//             temp = val1+val2;
//             val1 = val2;
//             val2 = temp;
//         }
//         return val1+val2;
//     }
// }

// Method 2
// class Solution {
//     public static Integer[] dp;
//     public int climbStairs(int n) {
//         dp = new Integer[n+1];
//         return dfs(n);
//     }
//     public static int dfs(int n) {
//         if(n<0) return 0;
//         if(n==0) return 1;
//         if(dp[n]!=null)return dp[n];
//         return dp[n]= dfs(n-1)+dfs(n-2);
//     }
// }

// Method 1
// public int climbStairs(int n) {
//     if(n==0) return 1;
//     if(n<0) return 0;
//     return climbStairs(n-1)+climbStairs(n-2);
// }