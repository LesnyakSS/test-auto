package OOP;

public class Manager extends Employee{

    public Manager(String name, int salary) {
        super(name, salary);
    }
@Override
    public void  work(){
        System.out.printf("%s управляет командой тестировщиков, работает за %d рублей \n" , name, salary);


    }
}
