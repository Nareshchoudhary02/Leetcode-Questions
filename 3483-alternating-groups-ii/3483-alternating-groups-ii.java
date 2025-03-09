class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int validSize = 1; 

        for (int i = 1; i < n + k - 1; i++) 
        {
            if (colors[i % n] != colors[(i - 1) % n]) 
            {
                validSize++; 
                if (validSize >= k) 
                {
                    count++; 
                }
            } 
            else 
            {
                validSize = 1; 
            }
        }

        return count;
    }
}
