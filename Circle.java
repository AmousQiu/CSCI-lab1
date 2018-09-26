public class Circle {
    private double xpos, ypos, radius;

    //set the x position
    public void setX(int xpos) {
        this.xpos = xpos;
    }

    //set the y position
    public void setY(int ypos) {
        this.ypos = ypos;
    }

    //get the x position
    public double getX() {
        return xpos;
    }

    //get the y position
    public double getY() {
        return ypos;
    }

    public double getRadius() {
        return radius;
    }

    //constructor
    public Circle(double xpos, double ypos, double radius) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    //get the are of the circle
    public double getArea() {
        return 3.14 * radius * radius;
    }

    //get the circumference of the circle
    public double getCircumference() {
        return 3.14 * 2 * radius;
    }

    //judge if the point is inside the circle
    public boolean contains(double x, double y) {
        double distance = (x - xpos) * (x - xpos) + (y - ypos) * (y - ypos);
        return distance < (radius * radius);
    }

    //judge if the point touches the circle
    public boolean touches(double x, double y) {
        double distance = (x - xpos) * (x - xpos) + (y - ypos) * (y - ypos);
        return distance == (radius * radius);
    }

    //judge if the circle is contained in the original circle
    public boolean contains(Circle circle) {
        double distance = (circle.getX() - xpos) * (circle.getX() - xpos) + (circle.getY() - ypos) * (circle.getY() - ypos);
        distance = Math.sqrt(distance) + circle.getRadius();
        return distance < this.radius;
    }

    //judge if the circle touches the original one
    //so we get two situations here,one for inner touch one for outside touch
    public boolean touches(Circle circle) {
        double distance = (circle.getX() - xpos) * (circle.getX() - xpos) + (circle.getY() - ypos) * (circle.getY() - ypos);
        distance = Math.sqrt(distance);
        return distance + circle.getRadius() == this.radius || distance == (circle.radius + this.radius);
    }

    public String toString() {
        return "[xpos= " + xpos + "," + "ypos= " + ypos + "] radius: " + radius;
    }

    public static void main(String args[]) {
        Circle c1 = new Circle(1, 2, 5);
        Circle c2 = new Circle(1, 0, 1);
        Circle c3 = new Circle(3, 2, 3);
        Circle c4 = new Circle(9, 2, 3);
        Circle c5 = new Circle(1, -2, 3);
        System.out.println(c1 + " area: " + c1.getArea() + " circumference: " + c1.getCircumference());
        System.out.println("Point (2,2) is contained in " + c1 + "?\t" + c1.contains(2, 2));
        System.out.println("Point (2,2) touches " + c1 + "?\t" + c1.touches(2, 2));
        System.out.println("Point (1,7) is contained in " + c1 + "?\t" + c1.contains(1, 7));
        System.out.println("Point (1,7) touches " + c1 + "?\t" + c1.touches(1, 7));
        System.out.println(c2 + " is contained in " + c1 + "?\t" + c1.contains(c2));
        System.out.println(c2 + " touches " + c1 + "?\t" + c1.touches(c2));
        System.out.println(c3 + " is contained in " + c1 + "?\t" + c1.contains(c3));
        System.out.println(c3 + " touches " + c1 + "?\t" + c1.touches(c3));
        System.out.println(c4 + " is contained in " + c1 + "?\t" + c1.contains(c4));
        System.out.println(c4 + " touches " + c1 + "?\t" + c1.touches(c4));
        System.out.println(c5 + " is contained in " + c1 + "?\t" + c1.contains(c5));
        System.out.println(c5 + " touches " + c1 + "?\t" + c1.touches(c5));
    }

}
