package com.leetcode.array;

import java.util.*;

/**
 * @Auther: dlm
 * @Date: 2020/11/25 15:49
 * @Description: 区间合并
 */
public class MergeIntervals_56 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });


        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < start) {
                list.add(new int[]{start, end});
            } else {
                list.get(list.size() - 1)[1] = Math.max(end, list.get(list.size() - 1)[1]);
            }
        }

        return list.toArray(new int[0][0]);
    }

    public List<Interval> merge2(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        if (o1.start != o2.start) {
                            return o1.start - o2.start;
                        } else {
                            return o1.end - o2.end;
                        }
                    }
                }
        );

        List<Interval> ans = new ArrayList<>(intervals.size());
        for (int i = 0; i < intervals.size(); i++) {
            if (ans.size() == 0 || ans.get(ans.size() - 1).end < intervals.get(i).start) {
                ans.add(intervals.get(i));
            } else {
                ans.get(ans.size() - 1).end = Math.max(intervals.get(i).end, ans.get(ans.size() - 1).end);
            }
        }

        return ans;
    }


    public class Interval {
        int start;
        int end;

        public Interval() {
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
