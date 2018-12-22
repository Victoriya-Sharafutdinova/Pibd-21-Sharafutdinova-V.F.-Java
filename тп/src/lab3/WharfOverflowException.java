package lab3;

public class WharfOverflowException extends Exception{
	public WharfOverflowException() {
		super("В порту нет свободных мест");
	}
}
