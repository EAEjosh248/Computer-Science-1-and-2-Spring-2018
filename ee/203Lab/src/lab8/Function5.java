package lab8;

public class Function5 extends Function {

	@Override
	public double fnValue(double x) {
		// TODO Auto-generated method stub
		return Math.sin(1/x);
	}
	public String toString () {
		return "sin(1/x)";
	}
}
