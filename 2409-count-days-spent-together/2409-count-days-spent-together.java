class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int a1 = calculateDayOfYear(arriveAlice, daysInMonths);
        int l1 = calculateDayOfYear(leaveAlice, daysInMonths);
        int a2 = calculateDayOfYear(arriveBob, daysInMonths);
        int l2 = calculateDayOfYear(leaveBob, daysInMonths);
        
        int startTogether = Math.max(a1, a2);
        int endTogether = Math.min(l1, l2);
        
        return Math.max(0, endTogether - startTogether + 1);
    }
    
    private int calculateDayOfYear(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        
        return totalDays;
    }
}