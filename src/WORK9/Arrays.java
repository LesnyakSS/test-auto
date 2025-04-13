package WORK9;

public class Arrays {
    private String[] arrays  = {"привет", "ПОКА", "гипербола"};

    public int getRandomString()
    {
        int a = (int) (Math.random() * 3); //генерим число
        System.out.printf("Рандомное число - %d \n" ,a);
        String b = arrays[a]; // выводим строку по сгенерированному числу
        System.out.printf("Строка \"%s\" по индексу %d \n" ,b ,a);

        return a;
    }




    public static void main(String[] args) {
        Arrays arrays1 = new Arrays();
        arrays1.getRandomString();


        }


}



