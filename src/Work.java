public class Work {
    public int number1;
    public int number2;
    static int number3;

    public Work (int number1, int number2){
        this.number1= number1;
        this.number2= number2;

    }
    //Статический метод
    public static void staticMethod(int number3){
        if (number3 > 1){
            System.out.println("Больше");
        }
        else {
            System.out.println("Меньше");
        }
    }

    public static void main(String[] args) {
        //Экземпляр класса
        Work work = new Work(3,3);
        //Переопределение методов
            work.number1= 7;
            work.number2= 6;
            Work.number3 = 8;
        System.out.println("Две публичные переменные : Первая " + work.number1 +" Вторая "+ work.number2 );
        System.out.println("Одна статическая переменная : " + Work.number3);

        staticMethod(Work.number3);

    }
}
