
// Given a chessboard, find the shortest distance (minimum number of steps) taken by a knight 
// to reach a given destination from a given source.
import java.util.*;

class Cell {
    // (x, y) represents chessboard coordinates
    // `dist` represents its minimum distance from the source
    int x, y, dist;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    /*
     * // As we are using the class object as a key in a `HashMap`,
     * // we need to implement `hashCode()` and `equals()`
     * 
     * @Override
     * public boolean equals(Object o) {
     * if (this == o)
     * return true;
     * if (o == null || getClass() != o.getClass())
     * return false;
     * Node node = (Node) o;
     * return x == node.x &&
     * y == node.y &&
     * dist == node.dist;
     * }
     * 
     * @Override
     * public int hashCode() {
     * return Objects.hash(x, y, dist);
     * }
     */
}

class ChessKnight {
    // Below arrays detail all eight possible movements for a knight
    private static int[] dx = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] dy = { -1, 1, 1, -1, 2, -2, 2, -2 };

    // Check if (x, y) is valid chessboard coordinates.
    // Note that a knight cannot go out of the chessboard
    private static boolean isInsideChessboard(int x, int y, int N) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    // Find the minimum number of steps taken by the knight
    // from the source to reach the destination using BFS
    public static int findShortestDistance(Cell src, Cell dest, int N) {
        // set to check if the matrix cell is visited before or not
        Set<Cell> visited = new HashSet<>();

        // create a queue and enqueue the first node
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(src);

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node and process it
            Cell node = queue.poll();

            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            // if the destination is reached, return distance
            if (x == dest.x && y == dest.y) {
                return dist;
            }

            // skip if the location is visited before
            if (!visited.contains(node)) {
                // mark the current node as visited
                visited.add(node);

                // check for all eight possible movements for a knight
                // and enqueue each valid movement
                for (int i = 0; i < dx.length; i++) {
                    // get the knight's valid position from the current position on
                    // the chessboard and enqueue it with +1 distance
                    int x1 = x + dx[i];
                    int y1 = y + dy[i];

                    if (isInsideChessboard(x1, y1, N)) {
                        queue.add(new Cell(x1, y1, dist + 1));
                    }
                }
            }
        }

        // return -1 if the path is not possible
        return -1;
    }

    public static void main(String[] args) {
        // N x N matrix
        int N = 8;

        // source coordinates
        Cell src = new Cell(0, 7);

        // destination coordinates
        Cell dest = new Cell(7, 0);

        System.out.println("The minimum number of steps required is " +
                findShortestDistance(src, dest, N));
    }
}
