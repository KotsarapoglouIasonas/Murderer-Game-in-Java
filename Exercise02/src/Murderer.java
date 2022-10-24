
public class Murderer {
    private int x;
    private int y;

    public Murderer(int x, int y) {
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
