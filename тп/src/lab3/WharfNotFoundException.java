package lab3;

public class WharfNotFoundException extends Exception{
	public WharfNotFoundException(int i) {
		super("Не найден корабль по месту " + i); 
	}
}
