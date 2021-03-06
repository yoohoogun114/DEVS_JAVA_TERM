package Lab7;
import java.awt.*;
import simView.*;

public class model extends ViewableDigraph
{

	public model()
	{
		super("Queue_Model");
    	
		ViewableAtomic g = new genr("Generator", 30);
		ViewableAtomic q = new queue("Queue", 10);
		ViewableAtomic p = new proc("Processor", 70);
		
		add(g);
		add(q);
		add(p);

  
		addCoupling(g, "out", q, "in_1");
		addCoupling(q, "out", p, "in");	
		addCoupling(p, "out_2", q, "in_2");
		addCoupling(p, "out_1", g, "in");

	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(535, 325);
        ((ViewableComponent)withName("Generator")).setPreferredLocation(new Point(30, 109));
        ((ViewableComponent)withName("Queue")).setPreferredLocation(new Point(308, 42));
        ((ViewableComponent)withName("Processor")).setPreferredLocation(new Point(285, 222));
    }
}
