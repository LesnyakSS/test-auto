package OOP;

public class Developer extends Employee{
    public Developer(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void  work(){
        System.out.printf("%s тестирует приложение, работает за %d рублей \n", name, salary);
    }
}
