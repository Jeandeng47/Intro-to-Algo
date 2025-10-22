/**
 * Recursive Top-Down -- O(2^n)
 * 
 * Pseudo code:
 * CUT-ROD(p, n)
 *  if n == 0:
 *      return 0
 *  q = = -∞
 *  for i = 1 to n:
 *      q = max (q, p[i] + CUT-ROD(p, n-1))
 *  return q
 */


public class CutRodRecursive implements RodCutter {
    private final int[] p; // p[0] unused

    public CutRodRecursive(int[] prices) { this.p = prices; }

    @Override
    public int revenue(int n) {
        if (n == 0) return n;
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + revenue(n - i));
        }
        return q;
    }
    
}
