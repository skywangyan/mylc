#!/usr/bin/python
# -*- coding: utf-8 -*-
# Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points
#  (i, j, k) such that the distance between i and j equals the distance between i and k (the
#  order of the tuple matters).

# Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are
#  all in the range [-10000, 10000] (inclusive).

# Example:
# Input:
# [[0,0],[1,0],[2,0]]

# Output:
# 2

# Explanation:
# The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
from collections import defaultdict
class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        res = 0
        for i in xrange(len(points)):
            store = defaultdict(int)
            for j in xrange(len(points)):
                if j == i:
                    continue
                dist = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] -
                 points[i][1]) * (points[j][1] - points[i][1])
                store[dist] += 1
            for k,v in store.iteritems():
                if v >= 2:
                    res += v * (v-1)
        return res
s = Solution()
print s.numberOfBoomerangs([[0,0],[1,0],[2,0]])
