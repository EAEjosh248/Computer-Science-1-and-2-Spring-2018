
public class QueueUnderflowException extends RuntimeException {
	public QueueUnderflowException() {
super("enqueue method is called on a full queue");
}}
