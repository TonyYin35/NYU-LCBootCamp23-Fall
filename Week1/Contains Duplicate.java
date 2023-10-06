class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int item: nums){
            if (!set.add(item)){
                return true;
            }
        }
        return false;
    }
}