import java.awt.*;
import java.awt.geom.Line2D;

public class InteractiveRectangle extends Rectangle {

    private static Rectangle me;

    public InteractiveRectangle(int x, int y, int width, int height){
        setRect(x, y, width, height);
        me = this;
    }

    public static void update(Line2D line){
        if(line.intersects(me)){
            Graphics g
        }
    }

}
