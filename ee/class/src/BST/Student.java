package BTS;
class Student implements Comparable<Student>{
	private String name,id;
	private double gpa;
	public Student(){}
	public Student(String name,String id,double gpa){this.name=name; this.id=id; this.gpa=gpa;}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String toString() {
		return id+"||"+name+"||"+gpa;
		
	}
	@Override
	public int compareTo(Student other) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(other.getName());
	}}
