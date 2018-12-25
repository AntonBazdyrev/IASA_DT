public class HourlySalaryWorker extends Worker {
    HourlySalaryWorker(String _name, int _id, double _salary){
        super(_name, _id, _salary);
    }
    @Override
    public double calculate_salary(){
        return 20.8 * 8 * getSalary();
    }
}