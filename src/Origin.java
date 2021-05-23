public class Origin {
    private int xPos;
    private int yPos;

    public Origin(){
        this.xPos = 0;
        this.yPos = 0;
    }

    public Origin(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public int getX(){
        return this.xPos;
    }

    public int getY(){
        return this.yPos;
    }

    public Point getPointFromOrigin(Point oldPoint){
        int x = oldPoint.getX();
        int y = oldPoint.getY();
        Point newPoint = new Point(x - this.xPos, y - this.yPos);
        return newPoint;
    }

    public Point returnPointToBefore(Point newPoint){
        int x = newPoint.getX();
        int y = newPoint.getY();
        Point oldPoint = new Point(x - (-this.xPos), y - (-this.yPos));
        return oldPoint;
    }

}
