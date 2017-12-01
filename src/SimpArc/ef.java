package SimpArc;
import simView.*;
import java.awt.*;

public class ef extends ViewableDigraph
{
	
	public ef()
	{
		this("ef", 30, 1000);
	}
	
	public ef(String name, double int_arr_t, double observe_t)
	{
		super(name);
		
		addInport("in"); 
		addOutport("out");
		
		ViewableAtomic g = new genr("g", int_arr_t);
		ViewableAtomic t = new transd("t", observe_t);

		add(g);
		add(t);

		addCoupling(this, "in", t, "solved");

		addCoupling(g, "out", t, "ariv");
		addCoupling(g, "out", this, "out");
		
		addCoupling(t, "out", g, "in");
	}

    
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(463, 297);
        ((ViewableComponent)withName("t")).setPreferredLocation(new Point(144, 195));
        ((ViewableComponent)withName("g")).setPreferredLocation(new Point(36, 52));
    }
}
