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
            case "magenta":
            	dopColor = Color.MAGENTA;
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
            case "pink":
            	dopColor = Color.PINK;
                break;
            case "cyan":
            	dopColor = Color.CYAN;
                break;
        }

    }
    
    public Ship(int maxSpeed, int weight, Color mainColor, Color dopColor)
    {
    	super(maxSpeed, weight, mainColor);
		setDopColor(dopColor);
    }
    
    public Ship(String info) {
    	super(info);
		String[] str = info.split(";");
		if(str.length == 8) {
			MaxSpeed = Integer.parseInt(str[0]);
			Weight = Float.parseFloat(str[1]);
			mainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
			dopColor = new Color(Integer.parseInt(str[5]), Integer.parseInt(str[6]), Integer.parseInt(str[7]));
		}
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
	@Override
	public String getInfo() {
		return MaxSpeed + ";" + Weight + ";" + mainColor.getRed() + ";" 
				+ mainColor.getGreen() + ";" +  mainColor.getBlue() + ";" 
				+ dopColor.getRed() + ";" + dopColor.getGreen() + ";" 
				+ dopColor.getBlue();
	}
	public int compareTo(Ship other) {
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
		if(dopColor != other.dopColor) {
			return Integer.compare(dopColor.getRGB(), other.dopColor.getRGB());		
		}
		return 0;
	}
	
	public boolean equals(Ship other) {
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
		if(dopColor != other.dopColor) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		}
		if(!(other instanceof Ship)) {
			return false;
		}
		Ship shipObj = (Ship) other;
		return equals(shipObj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
