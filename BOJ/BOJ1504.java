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

public class BOJ1504 {
    static int N, E;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < N + 1; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            a.get(start).add(new Node(end, weight));
            a.get(end).add(new Node(start, weight));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int res = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(res);

    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        queue.offer(new Node(start, 0));
        dist[start] = 0;

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

        return dist[end];
    }
}
