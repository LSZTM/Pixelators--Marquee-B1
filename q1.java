package model_assesment;
import java.util.*;
/*
 * You are given an array representing fuel cost per kilo-meter for a long trip.
Find the most fuel-efficient contiguous route segment of length ≥ k.
Requirements:
 Must run in O(n) using sliding window or prefix sums.
 Return: start index, end index, and minimum total cost.
 If two segments have same cost → choose shorter one.
 If still tie → choose the one that starts earlier.
 */
public class q1 {	
	public static void main(String args[]) {
		int[] a = {5, 2, 3, 1, 3, 1};
		int n = a.length;
		int k = 2;
		int left = 0;
		int currSum = 0;
		int bestStart = 0;
		int bestEnd = k - 1;
		int bestSum = Integer.MAX_VALUE;
		for (int right = 0; right < n; right++) {
		    currSum += a[right];
		    if (right - left + 1 >= k) {
		        int len = right - left + 1;
		        int bestLen = bestEnd - bestStart + 1;
		        if (currSum < bestSum ||
		            (currSum == bestSum && len < bestLen) ||
		            (currSum == bestSum && len == bestLen && left < bestStart)) {
		            bestSum = currSum;
		            bestStart = left;
		            bestEnd = right;
		        }
		        while (right - left + 1 > k && currSum - a[left] <= currSum) {
		            currSum -= a[left];
		            left++;
		            len = right - left + 1;
		            if (len >= k) {
		                if (currSum < bestSum ||
		                    (currSum == bestSum && len < bestLen) ||
		                    (currSum == bestSum && len == bestLen && left < bestStart)) {
		                    bestSum = currSum;
		                    bestStart = left;
		                    bestEnd = right;
		                }}}}}
		System.out.println(bestStart + ", " + bestEnd + ", " + bestSum);

}}
