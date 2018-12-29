package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SimpleShip extends Boat implements Comparable<SimpleShip>{
	protected  int shipWidth = 100;
    protected  int shipHeight = 60;
    public SimpleShip(int maxSpeed, int weight, Color mainColor)
    {
    	setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
    }
    
    public SimpleShip(String info) {
		String[] str = info.split(";");
		if(str.length == 5) {
			MaxSpeed = Integer.parseInt(str[0]);
			Weight = Float.parseFloat(str[1]);
			mainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
		}
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
    	g.setColor(mainColor);
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
    @Override
	public String getInfo() {
		return MaxSpeed + ";" + Weight + ";"  + mainColor.getRed() + ";" 
				+ mainColor.getGreen() + ";" + mainColor.getBlue();
	}
    @Override
	public int compareTo(SimpleShip other) {
		if(other == null) {
			return 1;
		}
		if(MaxSpeed != other.MaxSpeed) {
			return Integer.compare(MaxSpeed, other.MaxSpeed);
		}
		if(Weight != other.Weight) {
			return Float.compare(Weight, other.Weight);
		}
		if(mainColor != other.mainColor) {
			return Integer.compare(mainColor.getRGB(), other.mainColor.getRGB());
		}
		return 0;
	}
	
	public boolean equals(SimpleShip other) {
		if(other == null) {
			return false;
		}
		if(MaxSpeed != other.MaxSpeed) {
			return false;
		}
		if(Weight != other.Weight) {
			return false;
		}
		if(mainColor != other.mainColor) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		}
		if(!(other instanceof SimpleShip)) {
			return false;
		}
		SimpleShip shipObj = (SimpleShip) other;
		return equals(shipObj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

    
}
