package lab3;

import java.awt.Graphics;

import javax.swing.JPanel;


public class PanelWharf extends JPanel{
	public  Wharf<ITransport> wharf;
	
	 public Wharf<ITransport> getWharf() {
	        return wharf;
	    }

	    public PanelWharf() {
	    	wharf = new Wharf<>(20, 615, 603);
	    }

	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
			if(wharf != null) {
				wharf.Draw(g);
			}
	}
}
