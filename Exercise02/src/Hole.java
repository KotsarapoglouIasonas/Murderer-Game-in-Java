
public class Hole {

    private int x;
    private int y;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int returnx() {
        return x;
    }

    public int returny() {
        return y;
    }

}
