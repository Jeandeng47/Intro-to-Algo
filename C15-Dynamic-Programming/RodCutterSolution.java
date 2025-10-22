import java.util.ArrayList;
import java.util.List;

/**
 * Bottom-Up Extended DP — computes revenue and remembers first cut to recover a plan.
 *
 * Pseudocode:
 * EXTENDED-BOTTOM-UP-CUT-ROD(p, n):
 *   let r[0..n], s[0..n]; r[0] = 0
 *   for j = 1 to n:
 *       q = -∞; best = 1
 *       for i = 1 to j:
 *           cand = p[i] + r[j - i]
 *           if cand > q:
 *               q = cand; best = i
 *       r[j] = q; s[j] = best
 *   return r, s
 *
 * PRINT-CUT-SOLUTION(s, n):
 *   while n > 0:
 *       print s[n]
 *       n = n - s[n]
 */

public class RodCutterSolution {
    private final int[] p;

    public RodCutterSolution(int[] prices) {
        this.p = prices;
    }

    // Return the revenue for rod of length n
    public int revenue(int n) {
        return compute(n)[0][n];
    }

    // Return the optiomal cut solution for rod of length n
    public List<Integer> cutsFor(int n) {
        // result[0] = revenue array, result[1] = cut array
        int[][] result= compute(n); 
        int[] s = result[1];
        List<Integer> cuts = new ArrayList<>();
        int len = n;
        while (len > 0) {
            int first = s[len]; // first cut at s[len] 
            cuts.add(first); 
            len -= first; // rest of the cuts
        }
        return cuts;
    }

    /** returns { r[], s[] } where r[j] is best revenue, s[j] is first cut size */
    private int[][] compute(int n) {
        int[] r = new int[n + 1]; // r[0] = 0
        int[] s = new int[n + 1];
        // use bottom-up method
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            int c = 1;
            for (int i = 1; i <= j; i++) {
                int candidate = p[i] + r[j - i];
                if (candidate > q) {
                    q = candidate;
                    c = i;
                }
            }
            // for length j, the opt. revenue = q, opt.cut = c
            r[j] = q;
            s[j] = c;
        }
        return new int[][] { r, s };
    }
    
}
