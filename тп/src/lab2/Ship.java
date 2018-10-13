package lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Ship extends SimpleShip{	
	
	private Color DopColor;
	public Color getDopColor(){
		return DopColor;
	}
	public void setDopColor(Color value) {

		DopColor = value;

    }
	public Ship(int maxSpeed, float weight, Color mainColor, Color dopColor) 
    {      
		super(maxSpeed, weight, mainColor);
        DopColor = dopColor;
    }

	public void DrawShip(Graphics g) {
		super.DrawShip(g);
		g.setColor(MainColor);
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
		
    	g.setColor(DopColor);
		int[] arrayX = { (int) _startPosX, (int) _startPosX + 90,
				(int) _startPosX + 82, (int) _startPosX + 10 };
		int[] arrayY = { (int) _startPosY + 20, (int) _startPosY + 20,
				(int) _startPosY + 35, (int) _startPosY + 35 };
		Polygon poly = new Polygon(arrayX, arrayY, 4);
		g.fillPolygon(poly);
		g.drawPolygon(poly);
	}
}
