import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    // used for getting origin and translation
    private Point getPoint(int oX, int oY){
        Point origin = new Point(oX,oY);
        Scanner uInput = new Scanner(System.in);
        System.out.print("[?] X : ");
        int originX = Integer.parseInt(uInput.next());
        System.out.print("[?] Y : ");
        int originY = Integer.parseInt(uInput.next());
        Point point = new Point(originX,originY,origin);
        return point;
    }

    private ArrayList<Point> getPoints(Point origin){
        String currentChoice = "";

        System.out.println("");
        System.out.println("[I] Getting Points ");

        Scanner uInput = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<Point>();

        while(!currentChoice.equalsIgnoreCase("y")){
            Point newPoint = getPoint(origin.getX(),origin.getY());
            points.add(newPoint);
            System.out.print("[?] Exit (y/n) : ");
            currentChoice = uInput.next();
        }

        return points;
    }

    public void getDilation(){
        Scanner uInput = new Scanner(System.in);
        System.out.print("[?] Scale Factor : ");
        int scale = Integer.parseInt(uInput.next());

        Point origin = getPoint(0,0);
        ArrayList<Point> points = getPoints(origin);

        System.out.println("");
        System.out.println("[!] Dilation Results");

        for (int counter = 0; counter < points.size(); counter++) {
            points.get(counter).dilate(scale,false);
        }
    }

    public void translate(){
        Point translation = getPoint(0,0);
        ArrayList<Point> points = getPoints(new Point(0,0));

        for (int counter = 0; counter < points.size(); counter++) {
            points.get(counter).translate(translation.getX(), translation.getY(), false);
        }
    }

}
