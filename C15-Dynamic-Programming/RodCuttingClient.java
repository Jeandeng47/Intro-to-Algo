import java.util.Arrays;
import java.util.List;

// To 

/**
 * Simple console client to compare different rod-cutting implementations.
 */
public class RodCuttingClient {

    public static void main(String[] args) {
        // CLRS price table for lengths 1..10
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 10;

        RodCutter rec = new CutRodRecursive(p);
        RodCutter td  = new CutRodTopDown(p);
        RodCutter bu = new CutRodBottomUp(p);
        RodCutterSolution ext = new RodCutterSolution(p);

        System.out.println("Prices (1..10): " + Arrays.toString(Arrays.copyOfRange(p, 1, p.length)));
        System.out.println();

        run("Recursive (top-down)", rec, n);
        run("Memoized (top-down + cache)", td, n);
        run("Bottom-up DP", bu, n);

        System.out.println("\nExtended (bu-up with cuts):");
        for (int L = 1; L <= n; L++) {
            int r = ext.revenue(L);
            List<Integer> cuts = ext.cutsFor(L);
            System.out.printf("L=%2d  revenue=%2d  cuts=%s%n", L, r, cuts.toString());
        }
    }

    private static void run(String title, RodCutter impl, int n) {
        System.out.println(title + ":");
        for (int L = 1; L <= n; L++) {
            int r = impl.revenue(L);
            System.out.printf("  L=%2d -> %2d%n", L, r);
        }
        System.out.println();
    }
}
