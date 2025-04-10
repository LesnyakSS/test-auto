package work8;

import static work8.NumberOfStrings.StringsInstruments.GUITAR;

public class Guitar implements Playable{
    @Override
    public void play() {
        System.out.print("Играет Гитара. У гитары " + GUITAR.getStrings() + " струн \n");
    }
}
