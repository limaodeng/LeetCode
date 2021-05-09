package com.leetcode.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: dlm
 * @Date: 2020/11/24 10:13
 * @Description: 数据流中的第K大的元素
 */
public class KthLargestElementInStream_703 {


    public static void main(String[] args) {

    }

    public class KthLargest{

        private int K;
        // 优先队列：出队顺序和入队顺序无关；和优先级相关
        private Queue<Integer> queue = new PriorityQueue();

        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                queue.add(num);
                if (queue.size() > k)
                    queue.poll();
            }
            this.K = k;
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > K)
                queue.poll();
            return queue.peek();
        }
    }


}
