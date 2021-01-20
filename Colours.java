import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
public class Colours extends City
{
    //streets, ave
    public Colours (int s, int a){
        super(s,a);
    }

    protected void customizeIntersection(Intersection intersection){
        IntersectionIcon icon = new IntersectionIcon(Color.WHITE, Color.PINK);
        intersection.setIcon(icon);
    }
}