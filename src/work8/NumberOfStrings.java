package work8;

public class NumberOfStrings {
    public enum StringsInstruments {
        GUITAR(6,"Гитара — струнный щипковый музыкальный инструмент"),
        PIANO(220, "Пианино — струнно-клавишный музыкальный инструмент с молоточковым способом звукоизвлечения.");

        private final int strings;
        private final String info;

        StringsInstruments(int strings, String info) {
            this.strings = strings;
            this.info = info;
        }

        public int getStrings() {
            return strings;
        }
        public String getInfo() {
            return info;
        }
    }

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        guitar.play();
        Piano piano = new Piano();
        piano.play();
    }
}
