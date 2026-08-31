class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int firstCritIndex = -1;
        int prevCritIndex = -1;
        int currentIndex = 1;

        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            boolean isLocalMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isLocalMaxima || isLocalMinima) {
                if (firstCritIndex == -1) {
                    firstCritIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevCritIndex);
                }
                prevCritIndex = currentIndex;
            }

            prev = curr;
            curr = curr.next;
            currentIndex++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevCritIndex - firstCritIndex;
        return new int[]{minDistance, maxDistance};
    }
}