package lab3;

import java.awt.Graphics;

import javax.swing.JList;
import javax.swing.JPanel;


public class PanelWharf extends JPanel{
	private  MultiLevelWharf wharf;
	private JList listBoxLevels;
	private final int countLevel = 5;
	
	public MultiLevelWharf getWharf() {
        return wharf;
	}
    public PanelWharf() {
    	wharf = new MultiLevelWharf(countLevel, 615, 603);
    }
	
    public void setListLevels(JList listBoxLevels) {
        this.listBoxLevels = listBoxLevels;
    }
    
	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
		int selectedLevel = listBoxLevels.getSelectedIndex();
		wharf.getWharf(selectedLevel).Draw(g);
		if(selectedLevel != -1){
			if(wharf != null) {
				wharf.getWharf(selectedLevel).Draw(g);
			}
		}		
	}
}
