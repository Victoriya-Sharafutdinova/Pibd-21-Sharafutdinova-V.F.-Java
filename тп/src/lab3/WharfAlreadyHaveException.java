package lab3;

public class WharfAlreadyHaveException extends Exception{
	public WharfAlreadyHaveException() {
		super("В порту уже есть такой корабль");
	}
}
