
public class QueueOverflowException extends RuntimeException {
public QueueOverflowException() {
super("dequeue method is called on an empty queue");}
}
