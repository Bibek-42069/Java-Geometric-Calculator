import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    private Point getOrigin(){
        Scanner uInput = new Scanner(System.in);
        System.out.print("[?] Origin X : ");
        int originX = Integer.parseInt(uInput.next());
        System.out.print("[?] Origin Y : ");
        int originY = Integer.parseInt(uInput.next());
        Point origin = new Point(originX,originY);
        return origin;
    }

    private ArrayList<Point> getPoints(Point origin){
        String currentChoice = "";
        System.out.println("");
        System.out.println("[I] Getting Points ");
        Scanner uInput = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<Point>();

        while(!currentChoice.equalsIgnoreCase("y")){
            System.out.print("[?] Point X : ");
            int x = Integer.parseInt(uInput.next());
            System.out.print("[?] Origin Y : ");
            int y = Integer.parseInt(uInput.next());

            Point newPoint = new Point(x,y,origin);

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
        Point origin = getOrigin();
        ArrayList<Point> points = getPoints(origin);

        System.out.println("");
        System.out.println("[!] Dilation Results");

        for (int counter = 0; counter < points.size(); counter++) {
            points.get(counter).dilate(scale,false);
        }
    }

    public void translate(){

    }

}
