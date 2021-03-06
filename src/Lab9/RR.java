package Lab9;
import java.awt.*;
import simView.*;

public class RR extends ViewableDigraph
{

	final int NODE = 5;
	final int QUEUE = 0;

	int[] proc_t = {0, 150, 200, 450, 300, 500, 300};
	
	public RR()
	{
    	super("RR");
    	ViewableAtomic g = new genr("genr", 10);
    	ViewableAtomic s = new scheduler("scheduler", 0, NODE);
    	ViewableAtomic e = new evaluator("evaluator");
    	
    	add(g);
    	add(s);
    	add(e);

		addCoupling(g, "out", s, "in");
		addCoupling(g, "out", e, "arrive");

	
		for(int i = 1; i <= NODE; i++)
		{
			ViewableAtomic p = new processor("processor" + i, proc_t[i], QUEUE);
			add(p);
			
	
			addCoupling(s, "out" + i, p, "in");
			
			addCoupling(p, "out2", e, "loss");
			addCoupling(p, "out1", e, "solved");
		}
	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(823, 420);
        ((ViewableComponent)withName("scheduler")).setPreferredLocation(new Point(177, 81));
        ((ViewableComponent)withName("processor2")).setPreferredLocation(new Point(417, 127));
        ((ViewableComponent)withName("processor4")).setPreferredLocation(new Point(418, 266));
        ((ViewableComponent)withName("evaluator")).setPreferredLocation(new Point(594, 163));
        ((ViewableComponent)withName("processor5")).setPreferredLocation(new Point(419, 338));
        ((ViewableComponent)withName("processor1")).setPreferredLocation(new Point(417, 65));
        ((ViewableComponent)withName("genr")).setPreferredLocation(new Point(5, 195));
        ((ViewableComponent)withName("processor3")).setPreferredLocation(new Point(419, 193));
    }
}
