package com.example.niuke;

/**
 * TODO
 *
 * @author LiuYun
 * @date 2021/5/7 16:33
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5};
        System.out.println(search(nums, 2));
    }

    /**
     * 斐波那契数列(递归实现)  443ms
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-2) + Fibonacci(n-1);
    }

    /**
     * 斐波那契数列（非递归实现） 0ms
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= n; i++){
            b = c;
            a = c - a;
            c = a + b;
        }
        return c;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1 ;
        int mid = 0;
        while (right >= left){
            mid = (right + left)/2;
            if(target == nums[mid]){
                if(mid > left){
                    right -= 1;
                }else{
                    return mid;
                }
            }else if (target < nums[mid]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
