public abstract class Worker {
    private String name;
    private int id;
    private double salary;

    public abstract double calculate_salary();

    Worker(String _name, int _id, double _salary){
        name = _name;
        id = _id;
        salary = _salary;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }

    public void setName(String _name){
        this.name = _name;
    }
    public void setSalary(float _salary){
        this.salary = _salary;
    }
    public void setId(int _id){
        this.id = _id;
    }

    @Override
    public String toString() {
        return name + " " + id + " " + String.format("%.2f", calculate_salary());
    }

    public int compareTo(Worker w1){
        int result = Double.compare(this.calculate_salary(), w1.calculate_salary());
        if(result == 0){
            return this.name.compareToIgnoreCase(w1.name);
        }
        else return -result;
    }
}
