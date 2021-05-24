package Circle;

public class RectangleResizeable extends Rectangle implements Resizeable {
    public RectangleResizeable() {
    }

    public RectangleResizeable(double width, double length) {
        super(width, length);
    }

    public RectangleResizeable(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }

    @Override
    public void resize(double percent) {

    }
}
