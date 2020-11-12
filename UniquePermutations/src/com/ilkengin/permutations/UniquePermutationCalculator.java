package com.ilkengin.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquePermutationCalculator {

    private Set<List<Integer>> permutations = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUnique(nums, 0, new ArrayList<>());
        return permutations.stream().collect(Collectors.toList());
    }
    
    private void permuteUnique(int[] nums, int i, List<Integer> perm) {
        if (i == nums.length) {
            permutations.add(perm);
            return;
        }
        
        for (int j = 0; j <= perm.size(); j++) {
            perm.add(j, nums[i]);
            permuteUnique(nums, i + 1, new ArrayList<>(perm));
            perm.remove(j);
        }
    }
	
}
