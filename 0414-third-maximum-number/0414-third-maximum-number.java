class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            long val = num;

            if (val == max || val == secondMax || val == thirdMax) {
                continue;
            }

            if (val > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = val;
            } else if (val > secondMax) {
                thirdMax = secondMax;
                secondMax = val;
            } else if (val > thirdMax) {
                thirdMax = val;
            }
        }

        return thirdMax == Long.MIN_VALUE ? (int) max : (int) thirdMax;
    }
}