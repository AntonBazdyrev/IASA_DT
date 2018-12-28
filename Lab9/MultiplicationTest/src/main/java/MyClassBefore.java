public class MyClassBefore{
    public int multiply(int x,int y){
        if(x>999){
            throw new IllegalArgumentException();
        }
        return x/y;
    }
}