
public class Rectangle {

    private double xpos, ypos, width, height;

    public Rectangle() {
    }

    //constructor
//create a rectangle with the specified xpos,ypos,width, and height
    public Rectangle(double xpos, double ypos, double width, double height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    //set the x position
    public void setX(double xpos) {
        this.xpos = xpos;
    }

    //set the y position
    public void setY(double ypos) {
        this.ypos = ypos;
    }

    //set the width
    public void setWidth(double width) {
        this.width = width;
    }

    //set the height
    public void setHeight(double height) {
        this.height = height;
    }

    //get the x position
    public double getX() {
        return xpos;
    }

    //get the y position
    public double getY() {
        return ypos;
    }

    //get the width
    public double getWidth() {
        return width;
    }

    //get the height
    public double getHeight() {
        return height;
    }

    //return ture if the point x,y is in the rectangle ,else return false
    public boolean contains(double x, double y) {
        return x > this.getX() && y > this.getY() && x < (this.getX() + this.getWidth()) && y < (this.getY() + this.getHeight());
    }

    //return true if the point x,y touches the rectangle,else return false
    public boolean touches(double x, double y) {
        return (x == this.getX() && y >= this.getY() && y <= (this.getY() + this.getHeight()))
                || (x == (this.getX() + this.getWidth()) && y >= this.getY() && y <= (this.getY() + this.getHeight()))
                || (y == this.getY() && x >= this.getX() && x <= (this.getX() + this.getWidth()))
                || (y == (this.getY() + this.getHeight()) && x >= this.getX() && x <= (this.getX() + this.getWidth()));
    }

    //return true if the rectangle r contains in the original rectangle,else return false
    public boolean contains(Rectangle r) {
        return (this.contains(r.getX(), r.getY()))
                && this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    //return true if the rectangle r touches the original rectangle ,else return false
    public boolean touches(Rectangle r) {
        return (this.touches(r.getX(), r.getY())
                || this.touches(r.getX() + r.getWidth(), r.getY())
                || this.touches(r.getX(), r.getY() + r.getHeight()))
                || this.touches(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    //output the rectangle's situation
    public String toString() {
        return "[xpos= " + xpos + "," + "ypos= " + ypos + "] width: " + width + ",height: " + height;
    }

    //main method
    public static void main(String args[]) {
        Rectangle r1 = new Rectangle(10, 20, 300, 400);
        Rectangle r2 = new Rectangle(20, 30, 100, 50);
        Rectangle r3 = new Rectangle(200, 200, 50, 220);
        Rectangle r4 = new Rectangle(310, 420, 10, 10);
        Rectangle r5 = new Rectangle(310, 200, 100, 100);
        Rectangle r6 = new Rectangle(300, 300, 200, 200);
        System.out.println("Point (30,40) is contained in " + r1 + "?\t" + r1.contains(30, 40));
        System.out.println("Point (30,40) touches " + r1 + "?\t" + r1.touches(30, 40));
        System.out.println("Point (10,50) is contained in " + r1 + "?\t" + r1.contains(10, 50));
        System.out.println("Point (10,50) touches " + r1 + "?\t" + r1.touches(10, 50));
        System.out.println(r2 + " is contained in " + r1 + "?\t" + r1.contains(r2));
        System.out.println(r2 + " touches " + r1 + "?\t" + r1.touches(r2));
        System.out.println(r3 + " is contained in " + r1 + "?\t" + r1.contains(r3));
        System.out.println(r3 + " touches " + r1 + "?\t" + r1.touches(r3));
        System.out.println(r4 + " is contained in " + r1 + "?\t" + r1.contains(r4));
        System.out.println(r4 + " touches " + r1 + "?\t" + r1.touches(r4));
        System.out.println(r5 + " is contained in " + r1 + "?\t" + r1.contains(r5));
        System.out.println(r5 + " touches " + r1 + "?\t" + r1.touches(r5));
        System.out.println(r6 + " is contained in " + r1 + "?\t" + r1.contains(r6));
    }

}