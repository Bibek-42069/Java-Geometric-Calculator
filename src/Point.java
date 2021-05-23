public class Point {
    private int xPos;
    private int yPos;
    private Origin origin;

    public Point(){
        this.xPos = 0;
        this.yPos = 0;
        this.origin = new Origin(0,0);
    }

    public Point(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.origin = new Origin(0,0);
    }

    public Point(int xPos, int yPos, Point originPos){
        this(xPos,yPos);
        this.origin = new Origin(originPos.getX(),originPos.getY());
    }

    private boolean isNegative(int num){
        return num < 0;
    }

    private void changeCords(int newX, int newY){
        this.xPos = newX;
        this.yPos = newY;
    }

    public void printCords(){
        System.out.printf("[C] Coordinates : (%d,%d) %n", this.xPos, this.yPos);
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }


    public void getQuadrant(){
        boolean xIsNegative = isNegative(this.xPos);
        boolean yIsNegative = isNegative(this.yPos);

        if(!xIsNegative && !yIsNegative){
            System.out.println("[Q] Quadrant : 1");
        }
        else if(xIsNegative && !yIsNegative){
            System.out.println("[Q] Quadrant : 2");
        }
        else if(xIsNegative){
            System.out.println("[Q] Quadrant : 3");
        }
        else{
            System.out.println("[Q] Quadrant : 4");
        }
    }

    public void getSlope(int x2, int y2){
        int y = y2 - this.yPos;
        int x = x2 - this.xPos;
        System.out.println( "[S] Point Slope : " + y + " / " + x);
    }

    public void translate(int xTranslate, int yTranslate, boolean change){
        int xNew = this.xPos + xTranslate;
        int yNew = this.yPos + yTranslate;
        System.out.printf("[T] Translation : (%d,%d) -> (%d,%d) %n", this.xPos, this.yPos, xNew, yNew);

        if(change){
            changeCords(xNew,yNew);
        }
    }

    public void dilate(int scaleFactor, boolean change){
        Point pointFromOrigin = origin.getPointFromOrigin(this);
        int xNew = pointFromOrigin.xPos * scaleFactor;
        int yNew = pointFromOrigin.yPos * scaleFactor;
        Point newPoint = new Point(xNew,yNew);
        Point pointFromRealOrigin = origin.returnPointToBefore(newPoint);
        System.out.printf("[D] Dilation : (%d,%d) -> (%d,%d) %n", this.xPos, this.yPos, pointFromRealOrigin.getX(), pointFromRealOrigin.getY());

        if(change){
            changeCords(pointFromRealOrigin.getX(), pointFromOrigin.getY());
        }
    }
}
