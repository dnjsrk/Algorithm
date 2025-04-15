import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class BOJ1238 {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> a, b;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        a = new ArrayList<>();
        b = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
            b.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            a.get(start).add(new Node(end, weight));
            b.get(end).add(new Node(start, weight));
        }

        int[] dist1 = dijkstra(a);
        int[] dist2 = dijkstra(b);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(X, 0));

        int[] dist = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist;
    }
}
