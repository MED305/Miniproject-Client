package math;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Vector2f(float c_x, float c_y) {
        this.x = c_x;
        this.y = c_y;
    }

    public boolean equals(Vector2f other) {
        return (this.x == other.x && this.y == other.y);
    }

    public static double distance(Vector2f a, Vector2f b) {
        float v0 = b.x - a.x;
        float v1 = b.y - a.y;
        return Math.sqrt(v0 * v0 + v1 * v1);
    }

    public void normalize() {

        double length = Math.sqrt(this.x * this.x + this.y * this.y);

        if (length != 0.0) {
            float s = 1.0f / (float) length;
            this.x *= s;
            this.y *= s;
        }
    }

    public Vector2f add(Vector2f other) {
        float newX = this.x += other.x;
        float newY = this.y += other.y;

        return new Vector2f(newX, newY);
    }

    public Vector2f subtract(Vector2f other) {
        float newX = this.x -= other.x;
        float newY = this.y -= other.y;

        return new Vector2f(newX, newY);
    }
}
