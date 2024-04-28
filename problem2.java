import java.util.*;
public class Bellmanford {
    static final int infinity = Integer.MAX_VALUE;
    public static void bellmanford1(int[][] gh, int st) {
        int s = gh.length;
        int[] d = new int[s];
        Arrays.fill(d, infinity);
        d[st] = 0;
        for (int k = 0; k < s - 1; k++) {
            for (int l = 0; l < s; l++) {
                for (int p = 0; p < s; p++) {
                    if (gh[l][p] != 0 && d[l] != infinity && d[l] + gh[l][p] < d[p]) {
                        d[p] = d[l] + gh[l][p];
                    }
                }
            }
        }
        for (int l = 0; l < s; l++) {
            for (int p = 0; p < s; p++) {
                if (gh[l][p] != 0 && d[l] != infinity && d[l] + gh[l][p] < d[p]) {
                    System.out.println("Graph contains -ve weight");
                    return;
                }
            }
        }
        System.out.println("shortest Distance:");
        for (int k = 0; k < s; k++) {
            System.out.println(k + " \t\t " + (d[k] == infinity ? "Infinity" : d[k]));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int s = scanner.nextInt();
        int[][] gh = new int[s][s];
        System.out.println("Adjacency matrix:");
        for (int k = 0; k < s; k++) {
            for (int j = 0; j < s; j++) {
                gh[k][j] = scanner.nextInt();
            }
        }
        System.out.print("starts at:");
        int st = scanner.nextInt();
        bellmanford1(gh, st);
        scanner.close();
    }
}
