package lab1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Set;



public class Ship {
	private float _startPosX;
	private float _startPosY;
	private int _pictureWidth;
	private int _pictureHeight;
	private int shipWidth = 100;
	private int shipHeight = 60;
	private int MaxSpeed;
	public int getMaxSpeed(){
		return MaxSpeed;
	}
	private void setMaxSpeed(int value){
		MaxSpeed = value;
	}
	
	private float Weight;
	public float getWeight(){
		return Weight;
	}	
	private void setWeight(float value){
	Weight = value;
	}
	
	private Color MainColor;
	public Color getMainColor(){
		return MainColor;
	}
	private void setMainColor(Color value){
	MainColor = value;
	}
	
	private Color DopColor;
	public Color getDopColor(){
		return DopColor;
	}
	private void setDopColor(Color value){
	DopColor = value;
	}
	
	public Ship(int maxSpeed, float weight, Color mainColor, Color dopColor) {
		setMaxSpeed (maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		setDopColor (dopColor);
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void MoveTransport(Direction direction) {

		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - shipWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step - 10 > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - shipHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	public void DrawShip(Graphics g) {
		g.setColor(MainColor);
		int[] arrayX = { (int) _startPosX, (int) _startPosX + 90,
				(int) _startPosX + 75, (int) _startPosX + 20 };
		int[] arrayY = { (int) _startPosY + 20, (int) _startPosY + 20,
				(int) _startPosY + 50, (int) _startPosY + 50 };
		Polygon poly = new Polygon(arrayX, arrayY, 4);
		g.fillPolygon(poly);
		g.drawPolygon(poly);
		g.setColor(DopColor);
		g.fillRect((int) _startPosX + 70, (int) _startPosY - 10, 15, 30);
		g.drawRect((int) _startPosX + 70, (int) _startPosY - 10, 15, 30);
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
	}
}
