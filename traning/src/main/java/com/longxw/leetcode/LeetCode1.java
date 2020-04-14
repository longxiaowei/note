package com.longxw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *  demo:
 *  nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 * @author longxw
 * @since 2020/4/14
 */
public class LeetCode1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1().twoSum(new int[]{3,2,4}, 6));
    }


    /**
     * 使用 map 存储 数值 和对应的下标
     * 在 放入 map 之前判断 另外一个数字是否已经放入了map
     * 注意： 由于遍历顺序，在找到第二个数字时，第一个已经放入了map
     * 所有从map中获取的下标是 第一个值
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        int[] result = new int[2];
        for (int i=0;i<nums.length; i++){
            Integer value = map.get(target - nums[i]);
            if(value != null){
                result[0] = value;
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
