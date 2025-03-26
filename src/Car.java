public class Car {
   public String model;
    public int year;

    public Car(String model, int year){
        this.model=model;
        this.year=year;
    }
    public Car(String model){
        this.model=model;
    }

public void  makeBeBe(String model){
    if (model.equals("Лайнер")){
        System.out.println("Гомкий БИБИ ");
    }
    else if (model.equals("Поезд")){
        System.out.println("Средний БИБИ ");
    } else {
        System.out.println("Тихий БИБИ ");
    }
}

    public static void main(String[] args) {
      Car car1 = new Car("Поезд", 10);
      car1.year=15;
      car1.model="Лайнер";
      car1.makeBeBe(car1.model);
        System.out.println(car1.model + " - This a model ," +  car1.year + " - This is the number of years");

      Car car2 = new Car("Машина");
      car2.model="Самолет";
      car2.makeBeBe(car2.model);
        System.out.println(car2.model + " - This a model ");
    }
}
