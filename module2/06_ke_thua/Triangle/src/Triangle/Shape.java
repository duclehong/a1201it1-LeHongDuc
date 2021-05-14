package Triangle;

public class Shape {
    private String color = "Blue";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString(){
        String a = "";
        if(this.filled){
            a = "filled";
        }else{
            a = "not filled";
        }
        return "A Shape with color of " + this.color + " and " + a;
    }
}
