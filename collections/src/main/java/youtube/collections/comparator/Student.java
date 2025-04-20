package youtube.collections.comparator;


public class Student {

    private String name;
    private double gpa;

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){
        return this.name;
    }

    public double getGpa(){
        return this.gpa;
    }

    @Override
    public String toString(){
        return this.name + ": " + this.gpa;
    }

}
