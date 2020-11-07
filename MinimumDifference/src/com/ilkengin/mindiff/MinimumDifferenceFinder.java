package com.ilkengin.mindiff;

import java.util.Arrays;
import java.lang.Math;

public class MinimumDifferenceFinder {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) { return 0; }
        
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}