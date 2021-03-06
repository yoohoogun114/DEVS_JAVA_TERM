package Lab6;
import java.awt.*;
import simView.*;

public class routing_model extends ViewableDigraph
{

	public routing_model()
	{
		super("routing_model");
    	
		ViewableAtomic g = new sender("sender", 10);
		ViewableAtomic r = new router("router", 10);

		add(g);
		add(r);

		for(int i=1; i<=5; i++)
		{
			ViewableAtomic p = new receiver("receiver #" + i, 10);
			add(p);
			addCoupling(r, "out" + i, p, "in");
		}

		addCoupling(g, "out", r, "in");
		addCoupling(r, "out", g, "in");

	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(995, 557);
        ((ViewableComponent)withName("receiver #1")).setPreferredLocation(new Point(590, 47));
        ((ViewableComponent)withName("router")).setPreferredLocation(new Point(293, 171));
        ((ViewableComponent)withName("receiver #2")).setPreferredLocation(new Point(589, 118));
        ((ViewableComponent)withName("receiver #4")).setPreferredLocation(new Point(596, 267));
        ((ViewableComponent)withName("receiver #5")).setPreferredLocation(new Point(592, 346));
        ((ViewableComponent)withName("receiver #3")).setPreferredLocation(new Point(590, 187));
        ((ViewableComponent)withName("sender")).setPreferredLocation(new Point(27, 162));
    }
}
