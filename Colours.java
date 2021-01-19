import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
public class Colours extends City
{

    public Colours (int s, int a, int ms, int ma, int sizeInt){
        super(s,a,ms,ma,sizeInt);
    }

    protected void customizeIntersection(Intersection intersection){
        IntersectionIcon icon = new IntersectionIcon(Color.WHITE, Color.PINK);
        intersection.setIcon(icon);
    }
}