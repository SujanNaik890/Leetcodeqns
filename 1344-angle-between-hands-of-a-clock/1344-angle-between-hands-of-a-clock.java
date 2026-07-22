class Solution {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(hour * 30 - 11 * minutes / 2.0);
        return Math.min(angle, 360 - angle);
    }
}