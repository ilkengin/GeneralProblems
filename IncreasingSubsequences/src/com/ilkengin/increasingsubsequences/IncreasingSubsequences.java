package com.ilkengin.increasingsubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IncreasingSubsequences {
    private Set<List<Integer>> increasingSubsequences;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        increasingSubsequences = new HashSet<>();
        findIncreasingSubsequences(nums, 0, new ArrayList<>());
        return increasingSubsequences.stream().collect(Collectors.toList());
    }
    
    private void findIncreasingSubsequences(int[] nums, int i, List<Integer> currentIncreasingSubsequence) {
        
        if (i >= nums.length) {
            return;
        }
        
        int lastItemInIS = currentIncreasingSubsequence.isEmpty() ? Integer.MIN_VALUE : currentIncreasingSubsequence.get(currentIncreasingSubsequence.size() - 1);
        
        if (nums[i] >= lastItemInIS) {
            currentIncreasingSubsequence.add(nums[i]);

            if (i == nums.length - 1 && currentIncreasingSubsequence.size() > 1) {
                increasingSubsequences.add(new ArrayList<>(currentIncreasingSubsequence));
            }
            
            findIncreasingSubsequences(nums, i + 1, currentIncreasingSubsequence);
            
            currentIncreasingSubsequence.remove(currentIncreasingSubsequence.size() - 1);
        }

        if (i == nums.length - 1 && currentIncreasingSubsequence.size() > 1) {
            increasingSubsequences.add(new ArrayList<>(currentIncreasingSubsequence));
        }

        findIncreasingSubsequences(nums, i + 1, currentIncreasingSubsequence);
    }
}
