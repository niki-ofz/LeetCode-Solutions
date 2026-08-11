class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find longest sequential prefix sum
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find smallest missing integer >= sum
        int answer = sum;

        while (true) {

            boolean found = false;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == answer) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }

            answer++;
        }

        return answer;
    }
}