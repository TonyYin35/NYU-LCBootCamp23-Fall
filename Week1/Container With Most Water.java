class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while (left != right){
            if (height[left] > height[right]) {
                right--;
            }
            else {
                left++;
            }
            int l = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, l*h);
        }
        return maxArea;
    }
}