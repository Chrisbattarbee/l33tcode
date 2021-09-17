//Given the coordinates of two rectilinear rectangles in a 2D plane, return the 
//total area covered by the two rectangles. 
//
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its 
//top-right corner (ax2, ay2). 
//
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its 
//top-right corner (bx2, by2). 
//
// 
// Example 1: 
//
// 
//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 
//2
//Output: 45
// 
//
// Example 2: 
//
// 
//Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 
//= 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics Math Geometry 👍 640 👎 937


/**
 * The basic premise is that the overlap of the two rectangles if it exists is always another rectangle with
 * co-ordinates x1 = max(x1s) x2 = min(x2s)
 *              y1 = max(y1s) y2 = min(y2s)
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static int computeAreaOfOne(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    private static int computeIntersection(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int maxX1s = Math.max(ax1, bx1);
        int minX2s = Math.min(ax2, bx2);
        // no overlap
        if (minX2s < maxX1s) {
            return 0;
        }

        int maxY1s = Math.max(ay1, by1);
        int minY2s = Math.min(ay2, by2);
        // no overlap
        if (minY2s < maxY1s) {
            return 0;
        }
        return computeAreaOfOne(maxX1s, maxY1s, minX2s, minY2s);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int intersectionArea = computeIntersection(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        int totalArea = computeAreaOfOne(ax1, ay1, ax2, ay2) + computeAreaOfOne(bx1, by1, bx2, by2);
        return totalArea - intersectionArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
