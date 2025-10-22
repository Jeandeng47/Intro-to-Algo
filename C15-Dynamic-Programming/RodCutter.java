/**
 * Rod Cutting Problem
 * 
 * Problem:
 * Given a rod of length n and a table of prices p[i] (price of piece of length i)
 * determine the max revenue obtainable by cutting the rod into pieces and selling them.
 * 
 * Assumptions:
 * - Prices are 1-indexed: p[1]..p[n]; p[0] is unused (0).
 * - There is no cutting cost (use an extended version if there is).
 * - Multiple cuts allowed; the order of pieces does not matter, only their lengths.
 *
 * Goal:
 * Return the maximum obtainable revenue for a given length n.
 * 
 */
public interface RodCutter {
    // Return the max revenue for a rod of length n
    int revenue(int n);
    
} 