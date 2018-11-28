package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SimpleShip extends Boat{
	protected  int shipWidth = 100;
    protected  int shipHeight = 60;
    public SimpleShip(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }
   
    public  void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Right:
                if (_startPosX + step < _pictureWidth - shipWidth)
                {
                    _startPosX += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step - 10 > 0)
                {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - shipHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    public void DrawShip(Graphics g)
    {
    	g.setColor(MainColor);
		int[] arrayX = { (int) _startPosX, (int) _startPosX + 90,
				(int) _startPosX + 75, (int) _startPosX + 20 };
		int[] arrayY = { (int) _startPosY + 20, (int) _startPosY + 20,
				(int) _startPosY + 50, (int) _startPosY + 50 };
		Polygon poly = new Polygon(arrayX, arrayY, 4);
		g.fillPolygon(poly);
		g.drawPolygon(poly);

		Color newColor = new Color(255, 255, 255);
		g.setColor(newColor);
		g.fillRect((int) _startPosX + 70, (int) _startPosY - 10, 15, 30);
		g.drawRect((int) _startPosX + 70, (int) _startPosY - 10, 15, 30);
    }
}
