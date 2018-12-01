package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Ship extends SimpleShip{	
	
	private Color dopColor;
    public Color getDopColor() {
    	return dopColor;
    }
    private void setDopColor(Color dopColor) {
    	this.dopColor = dopColor;
    }
    public void setDopColor(String colorName) {
        switch (colorName) {
            case "yellow":
            	dopColor = Color.YELLOW;
                break;
            case "blue":
            	dopColor = Color.BLUE;
                break;
            case "red":
            	dopColor = Color.RED;
                break;
            case "green":
            	dopColor = Color.GREEN;
                break;
            case "black":
            	dopColor = Color.BLACK;
                break;
            case "orange":
            	dopColor = Color.ORANGE;
                break;
            case "grey":
            	dopColor = Color.GRAY;
                break;
            case "white":
            	dopColor = Color.WHITE;
                break;
        }

    }
    
	public Ship(int maxSpeed, int weight, Color mainColor, Color dopColor) 
    {      
		super(maxSpeed, weight, mainColor);
        setDopColor(dopColor);
    }

	public void DrawShip(Graphics g) {
		super.DrawShip(g);
		g.setColor(mainColor);
		Color newColor = new Color(150, 0, 24);
		g.setColor(newColor);
		g.fillRect((int) _startPosX + 10, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 30, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 50, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 40, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 40, (int) _startPosY - 10, 10, 10);
		g.fillRect((int) _startPosX + 60, (int) _startPosY, 10, 10);
		Color newColor2 = new Color(48, 48, 48);
		g.setColor(newColor2);
		g.fillRect((int) _startPosX, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 40, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 60, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 10, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 30, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 50, (int) _startPosY - 10, 10, 10);
		Color newColor3 = new Color(0, 0, 0);
		g.setColor(newColor3);
		g.fillRect((int) _startPosX + 20, (int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 20, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 50, (int) _startPosY, 10, 10);
		g.fillRect((int) _startPosX + 20, (int) _startPosY - 10, 10, 10);
		
    	g.setColor(dopColor);
		int[] arrayX = { (int) _startPosX, (int) _startPosX + 90,
				(int) _startPosX + 82, (int) _startPosX + 10 };
		int[] arrayY = { (int) _startPosY + 20, (int) _startPosY + 20,
				(int) _startPosY + 35, (int) _startPosY + 35 };
		Polygon poly = new Polygon(arrayX, arrayY, 4);
		g.fillPolygon(poly);
		g.drawPolygon(poly);
	}
}
