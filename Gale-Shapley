import java.util.*;

public class GaleShapley {
    public static void main(String[] args) {
        // Number of men and women
        int N = 5;

        // Preference lists for men (M1 to M5)
        int[][] menPref = {
            {1, 3, 5, 2, 4},  // M1's preferences
            {2, 3, 4, 5, 1},  // M2's preferences
            {5, 4, 2, 3, 1},  // M3's preferences
            {3, 5, 4, 1, 2},  // M4's preferences
            {4, 5, 1, 2, 3}   // M5's preferences
        };

        // Preference lists for women (W1 to W5)
        int[][] womenPref = {
            {4, 1, 5, 2, 3},  // W1's preferences
            {3, 2, 4, 5, 1},  // W2's preferences
            {2, 3, 4, 1, 5},  // W3's preferences
            {1, 5, 3, 4, 2},  // W4's preferences
            {5, 1, 2, 3, 4}   // W5's preferences
        };

        // Array to store the current partner of each woman (-1 if unmarried)
        int[] womenPartner = new int[N];
        Arrays.fill(womenPartner, -1);

        // Boolean array to check if a man is free
        boolean[] freeMen = new boolean[N];
        Arrays.fill(freeMen, true);

        // Array to track how many women each man has proposed to
        int[] menProposals = new int[N];

        // Number of free men at the start
        int freeCount = N;

        // While there are free men who haven't proposed to all women
        while (freeCount > 0) {
            int man;
            for (man = 0; man < N; man++) {
                if (freeMen[man]) break; // Find a free man
            }

            // The current woman this man is proposing to based on his preference
            int woman = menPref[man][menProposals[man]] - 1;
            menProposals[man]++;

            // If the woman is not yet married, pair her with the man
            if (womenPartner[woman] == -1) {
                womenPartner[woman] = man;
                freeMen[man] = false;
                freeCount--;
            } else {
                // If the woman is already engaged, check if she prefers this man
                int currentPartner = womenPartner[woman];
                if (prefersNewMan(womenPref[woman], man, currentPartner)) {
                    womenPartner[woman] = man;
                    freeMen[man] = false;
                    freeMen[currentPartner] = true; // The woman's previous partner becomes free
                }
            }
        }

        // Output the results
        System.out.println("Stable matches:");
        for (int i = 0; i < N; i++) {
            System.out.println("Woman " + (i + 1) + " is matched with Man " + (womenPartner[i] + 1));
        }
    }

    // Helper function to check if a woman prefers a new man over her current partner
    static boolean prefersNewMan(int[] womanPref, int newMan, int currentPartner) {
        for (int i = 0; i < womanPref.length; i++) {
            if (womanPref[i] == newMan + 1) return true;
            if (womanPref[i] == currentPartner + 1) return false;
        }
        return false;
    }
}
