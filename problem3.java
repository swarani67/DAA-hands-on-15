import java.util.*;
public class floydwarshall {
    static final int infinity = Integer.MAX_VALUE;
    public static void floydwarshall1(int[][] gh) {
        int s = gh.length;
        int[][] d = new int[s][s];
        for (int k = 0; k < s; k++) {
            for (int l = 0; l < s; l++) {
                d[k][l] = gh[k][l];
            }
        }
        for (int p = 0; p < s; p++) {
            for (int k = 0; k < s; k++) {
                for (int l = 0; l < s; l++) {
                    if (d[k][p] != infinity && d[p][l] != infinity && d[k][p] + d[p][l] < d[k][l]) {
                        d[k][l] = d[k][p] + d[p][l];
                    }
                }
            }
        }
        System.out.println("Shortest distance:");
        for (int k = 0; k < s; k++) {
            for (int l = 0; l < s; l++) {
                System.out.print((d[k][l] == infinity ? "Infinity" : d[k][l]) + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of vertices:");
        int s = scanner.nextInt();
        int[][] graph = new int[s][s];
        System.out.println("Adjacency matrix:");
        for (int k = 0; k < s; k++) {
            for (int l = 0; l < s; l++) {
                graph[k][l] = scanner.nextInt();
            }
        }
        floydwarshall1(graph);
        scanner.close();
    }
}
