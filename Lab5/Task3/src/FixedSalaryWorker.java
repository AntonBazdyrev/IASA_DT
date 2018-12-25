public class FixedSalaryWorker extends Worker{
    FixedSalaryWorker(String _name, int _id, double _salary){
        super(_name, _id, _salary);
    }
    @Override
    public double calculate_salary() {
        return this.getSalary();
    }
}