package lab.mon.actlab;

import java.util.HashMap;
import java.util.Map;

class Alth {
    public int[] twoSum(int[] nums, int target) {
        int complement;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}