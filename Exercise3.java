import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        double[][] points = new double[5][2];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter " + points.length + " points: ");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        Rectangle boundingRectangle = getRectangle(points);
        //TODO: Display its center, width and height
        double centerx=boundingRectangle.getX()+boundingRectangle.getWidth()/2;
        double centery=boundingRectangle.getY()+boundingRectangle.getHeight()/2;
        System.out.println("The bouding rectangle's center ("+centerx+","+centery+"), width "+boundingRectangle.getWidth()+", height "+boundingRectangle.getHeight());
    }

    /*
    TODO – Complete this method
    This method finds the xpos, ypos, width and height of the
    bounding rectangle
    constructs it and returns it
    */
    public static Rectangle getRectangle(double[][] points) {
        Rectangle R = new Rectangle();
        double xleft=points[0][0];
        double xright=points[0][0];
        double yleft=points[0][1];
        double yright=points[0][1];
        //get the left edge of the rectangle
        for (int i=1;i<5;i++){
            if(points[i][0]<xleft){
                xleft=points[i][0];
            }
            //get the right edge of the rectangle
            if(points[i][0]>xright){
                xright=points[i][0];
            }
        }
        for (int i=1;i<5;i++){
            //get the top edge of the rectangle
            if(points[i][1]<yleft){
                yleft=points[i][1];
            }
            //get the bottom edge of the rectangle
            if(points[i][1]>yright){
                yright=points[i][1];
            }
        }
        R.setX(xleft);
        R.setY(yleft);
        R.setHeight(yright-yleft);
        R.setWidth(xright-xleft);
        return R;
    }
}
