import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Step 1: Count how many times each number appears in nums1
        // Since constraints say 0 <= nums1[i] <= 1000, size 1001 is enough
        int[] counts = new int[1001];
        for (int num : nums1) {
            counts[num]++;
        }

        // Step 2: Look through nums2 and collect common elements
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // If the number exists in nums1 (count > 0), keep it
            if (counts[num] > 0) {
                list.add(num);
                counts[num]--; // Use up one occurrence
            }
        }

        // Step 3: Convert the List into a standard Java int[] array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}