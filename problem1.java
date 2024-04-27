import java.util.*;
public class Dijkstra {
    static final int infinity = Integer.MAX_VALUE;
    public static void dijkstra1(int[][] gh, int st) {
        int s = gh.length;
        int[] d = new int[s];
        boolean[] vt = new boolean[s];
        Arrays.fill(d, infinity);
        d[st] = 0;
        for (int k = 0; k < s - 1; k++) {
            int e = -1;
            for (int l = 0; l < s; l++) {
                if (!vt[l] && (e == -1 || d[l] < d[e])) {
                    e = l;
                }
            }
            vt[e] = true;
            for (int v = 0; v < s; v++) {
                if (gh[e][v] != 0 && !vt[v]) {
                    d[v] = Math.min(d[v], d[e] + gh[e][v]);
                }
            }
        }
        System.out.println("Distance:");
        for (int k = 0; k < s; k++) {
            System.out.println(k + " \t\t " + (d[k] == infinity ? "No path" : d[k]));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int n = scanner.nextInt();
        int[][] gh = new int[n][n];
        System.out.println("Adjacency matrix:");
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                gh[k][l] = scanner.nextInt();
            }
        }
        System.out.print("starts at:");
        int st = scanner.nextInt();
        dijkstra1(gh, st);
        scanner.close();
    }
}
