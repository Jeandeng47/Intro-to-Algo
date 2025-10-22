/**
 * Bottom-Up Dynamic Programming -- O(n^2)
 *
 * Pseudocode:
 * BOTTOM-UP-CUT-ROD(p, n):
 *   let r[0..n]; r[0] = 0
 *   for j = 1 to n:
 *       q = -∞
 *       for i = 1 to j:
 *           q = max(q, p[i] + r[j - i])
 *       r[j] = q
 *   return r[n]
 */

public class CutRodBottomUp implements RodCutter {
    private final int[] p; // p[0] unused
    
    public CutRodBottomUp(int[] prices) {
        this.p = prices;
    }

    @Override
    public int revenue(int n) {
        int[] memo = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + memo[j - i]);
            }
            memo[j] = q;
        }
        return memo[n];
    }

    
}
