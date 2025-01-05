class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearest_x = Math.max(x1, Math.min(x2, xCenter));
        int nearest_y = Math.max(y1, Math.min(y2, yCenter));

        int x_dist = nearest_x - xCenter;
        int y_dist = nearest_y - yCenter;

        return x_dist * x_dist + y_dist * y_dist <= radius * radius;
    }
}
