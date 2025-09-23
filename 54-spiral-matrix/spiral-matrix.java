class Solution {
    public List<Integer> spiralOrder(int[][] arr)
    {
        List<Integer> ans = new ArrayList<>();
        if (arr == null || arr.length == 0)
        {
            return ans;
        }
        int down = 0, left = 0;
        int up = arr.length - 1, right = arr[0].length - 1;

        while (left <= right && down <= up)
        {
            for (int i = left; i <= right; i++)
            {
                ans.add(arr[down][i]);
            }
            down++;
            for (int i = down; i <= up; i++)
            {
                ans.add(arr[i][right]);
            }
            right--;
            if (down <= up)
            {
                for (int i = right; i >= left; i--)
                {
                    ans.add(arr[up][i]);
                }
                up--;
            }
            if (left <= right)
            {
                for (int i = up; i >= down; i--)
                {
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
