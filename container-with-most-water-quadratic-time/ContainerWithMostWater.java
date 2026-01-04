// https://leetcode.com/problems/container-with-most-water/
// LC11. Container With Most Water
// Time/space: Quadratic time, constant extra-space.
// Concepts: Linear Search.
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
