package OOP;

public  class Employee {
    public String name ;
    public int salary;

    public Employee(String name,int salary){
        this.salary=salary;
        this.name=name;
    }
    public void work(){
        System.out.printf(" Имя - %s, работает за %d рублей ", name, salary);
    }


    public static void main(String[] args) {
        Manager manager = new Manager("Антон",20000);
        manager.work();
        Developer developer= new Developer("Сергей",15000);
        developer.work();
    }

}
