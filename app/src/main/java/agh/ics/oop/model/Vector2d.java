package agh.ics.oop.model;

public class Vector2d {

    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
    }

    public boolean precedes(Vector2d other) {
        return x <= other.getX() && y <= other.getY(); 
    }

    public boolean follows(Vector2d other) {
        return x >= other.getX() && y >= other.getY(); 
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.getX(), y + other.getY());
    }
    
    public Vector2d substract(Vector2d other) {
        return new Vector2d(x - other.getX(), y - other.getY());
    }
    
    public Vector2d upperRight(Vector2d other) {
        int x = this.x;
        int y = this.y;
        if (other.getX() > x)
            x = other.getX();
        if (other.getY() > y)
            y = other.getY();
        
        return new Vector2d(x, y);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int x = this.x;
        int y = this.y;
        if (other.getX() < x)
            x = other.getX();
        if (other.getY() < y)
            y = other.getY();
        
        return new Vector2d(x, y);
    }
    
    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }

    public boolean equals(Object other){
        if(!(other instanceof Vector2d))
            return false;

        Vector2d that = (Vector2d) other;

        return this.x == that.getX() && this.y == that.getY();
    }
}
