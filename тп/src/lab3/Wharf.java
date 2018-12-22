package lab3;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

 class Wharf<T extends ITransport > {
    private HashMap<Integer,T> _places;
    private int _maxCount;
    private int PictureWidth;
    public int getPictureWidth(){
		return PictureWidth;
	}
	
	public void setPictureWidth(int pw){
		PictureWidth = pw;
	}
    private int PictureHeight;
    
    public int getPictureHeight(){
		return PictureHeight;
	}
	
	public void setPictureHeight(int ph){
		PictureHeight = ph;
	}
    private int _placeSizeWidth = 210;
    private int _placeSizeHeight = 80;
    public Wharf( int sizes, int pictureWidth, int pictureHeight)
    {
    	_maxCount = sizes;
        _places = new  HashMap<Integer,T>();
        PictureWidth = pictureWidth;
        PictureHeight = pictureHeight;
        
    }
    public int Plus(T ship)
    {
    	if (_places.size() == _maxCount)
        {
            return -1;
        }
        for (int i = 0; i < _maxCount;  i++)
        {
            if (CheckFreePlace(i))
            {
                _places.put(i, ship);
                _places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 20, PictureWidth, PictureHeight);
                return i;
            }
        }
        return -1;
    }

    public  T Minus( int index)
    {
        if (index < 0 || index > _maxCount)
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T ship = _places.get(index);
            _places.remove(index);
            return ship;
        }
        return null;
    }

    private boolean CheckFreePlace(int index)
    {
        return !_places.containsKey(index);
    }
    public void Draw(Graphics g)
    {
    	DrawMarking(g);
        for (int i = 0; i < _places.keySet().toArray().length; i++)
        {    
            _places.get(_places.keySet().toArray()[i]).DrawShip(g);

        }
    }
    private void DrawMarking(Graphics g)
    {
		Color newColor3 = new Color(0, 0, 0);
		g.setColor(newColor3);
        g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _maxCount / 5; i++)
        {
            for (int j = 0; j < 6; ++j)
            {  
                g.drawRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5 );
                Color nc = new Color(200,200,200);
        		g.setColor(nc);
                g.fillRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5);
            }
    		g.setColor(newColor3);
            g.drawLine( i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }
    public T getShip(int index) {
    	if (_places.get(index) != null) {
			return _places.get(index);
		} else {
			return null;
		}
    }
    public void setShip(int index, T ship) {
    	if(CheckFreePlace(index)) {
    		_places.put(index, ship);
    		_places.get(index).SetPosition(5 + index / 5 * _placeSizeWidth + 5, index % 5 * _placeSizeHeight + 15, PictureWidth, PictureHeight);
    	}
    }
 }
