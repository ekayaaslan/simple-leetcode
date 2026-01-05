// https://leetcode.com/problems/spiral-matrix/
// LC54. Spiral Matrix
// Linear time, linear extra-space.
class SpiralMatrix {
    enum Direction {
        EAST, SOUTH, WEST, NORTH
    };
    class Position { 
        int x; int y; 
        Position(int x, int y) { this.x = x; this.y = y;}
        void visit(boolean[][] visited) {
            visited[x][y] = true;
        }
        boolean isValid(boolean[][] visited) {
            int n = visited.length;
            int m = visited[0].length;
            if (x < 0 || x >= n) { return false; }
            if (y < 0 || y >= m) { return false; }
            return !visited[x][y];
        }
        Position next(Direction direction) {
            switch(direction) {
                case Direction.EAST: return new Position(x, y+1);
                case Direction.SOUTH: return new Position(x+1, y);
                case Direction.WEST: return new Position(x, y-1); 
                case Direction.NORTH: return new Position(x-1, y);
            }
            return null;
        }
        String ToString() {
            return "Position: (" + x + ", " + y + ")";
        }
    };
    public Direction turnRight(Direction direction) {
        switch(direction) {
            case Direction.EAST: return Direction.SOUTH;
            case Direction.SOUTH: return Direction.WEST;
            case Direction.WEST: return Direction.NORTH;
            case Direction.NORTH: return Direction.EAST;
        }
        return null;
    }
    public List<Integer> findValueList(int[][] matrix, List<Position> positions) {
        List<Integer> values = new ArrayList();
        for (Position position : positions) {
            values.add(matrix[position.x][position.y]);
        }
        return values;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Position> positions = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Direction direction = Direction.EAST;
        Position position = new Position(0, 0);
        for (int i=0; i<n*m; i++) {
            position.visit(visited);
            positions.add(position);
            Position next = position.next(direction);
            if (!next.isValid(visited)) {
                direction = turnRight(direction);
                next = position.next(direction);
            }
            position = next;
        }
        return findValueList(matrix, positions);
    }
}