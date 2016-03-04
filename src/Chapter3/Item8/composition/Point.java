package Chapter3.Item8.composition;// Simple immutable two-dimensional integer point class - Page 37

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    // See Item 9
    @Override
    public int hashCode(){
        return 31 * x + y;
    }
}
