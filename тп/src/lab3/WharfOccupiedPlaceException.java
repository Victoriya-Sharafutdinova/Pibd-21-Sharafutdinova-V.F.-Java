package lab3;

public class WharfOccupiedPlaceException extends Exception{
	public WharfOccupiedPlaceException(int i) {
		super("На месте " + i + " уже стоит корабль");
	}
}
