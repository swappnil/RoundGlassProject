package geetmusicsglabs.com.roundglass;

/**
 * Created by swappnil on 20-01-2017.
 */
public class ListItems {
    private String shape,color;
    public ListItems(){

    }
    public ListItems(String shape,String color){
        this.shape=shape;
        this.color=color;
    }
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
