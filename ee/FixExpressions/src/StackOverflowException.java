
public class StackOverflowException extends RuntimeException {
	public StackOverflowException() {
		super("top or pop method is called on an empty stack");
	}
}
