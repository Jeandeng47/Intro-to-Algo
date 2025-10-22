import java.util.Arrays;

/**
 * Top-Down with Memoization -- O(n^2)
 *
 * Pseudocode:
 * MEMOIZED-CUT-ROD(p, n):
 *   let r[0..n] = -∞
 *   r[0] = 0
 *   return MEMOIZED-CUT-ROD-AUX(p, n, r)
 *
 * MEMOIZED-CUT-ROD-AUX(p, n, r):
 *   if r[n] != -∞: return r[n]
 *   if n == 0: q = 0
 *   else:
 *       q = -∞
 *       for i = 1 to n:
 *           q = max(q, p[i] + MEMOIZED-CUT-ROD-AUX(p, n - i, r))
 *   r[n] = q
 *   return q
 */

public class CutRodTopDown implements RodCutter {
    private final int[] p; // p[0] unused
    private final int[] memo;

    public CutRodTopDown(int[] prices) {
        this.p = prices;
        this.memo = new int[prices.length];
        Arrays.fill(this.memo, Integer.MIN_VALUE);
        this.memo[0] = 0;
    }

    @Override
    public int revenue(int n) {
        if (memo[n] >= 0) { return memo[n]; }
        int q = Integer.MIN_VALUE;
        if (n == 0) {
            return 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + revenue(n - i));
            }
        }
        memo[n] = q;
        return q;
    }

}
