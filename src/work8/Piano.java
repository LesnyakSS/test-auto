package work8;


import static work8.NumberOfStrings.StringsInstruments.PIANO;

public class Piano implements Playable{

    @Override
    public void play() {
        System.out.print("Играет Пианино. "+ PIANO.getInfo() + " У пианино " + PIANO.getStrings() + " струн \n");

    }

}
