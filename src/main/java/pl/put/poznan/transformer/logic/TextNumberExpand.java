package pl.put.poznan.transformer.logic;

public class TextNumberExpand extends TextDecorator {

    public TextNumberExpand(TextTransformer decoratedText){
        super(decoratedText);
    }

    public String transform(String text){
        // Metoda zwraca tekst z zmiana liczb na tekst
        // np. Wplac 100 zl --> Wplac sto zl
        String output_string = text;
        String str = text;
        str = str.replaceAll("[^-?0-9]+", " ");
//        System.out.println(str);
        String[] arr = str.trim().split(" ");
        for (String s : arr) {
//            System.out.println("index of " + s + " to " + output_string.indexOf(s));
            int number_of_digits = s.length();
            int number_in_text;
            String nowy_tekst = "";
            String[] data = {"sto ", "dwiescie ", "trzysta ", "czterysta ", "piecset ",
                    "szescset ", "siedemset ", "osiemset ", "dziewiecset ", "dzisiec", "dwadziescia", "trzydziesci", "czterdzisci",
                    "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat",
                    "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie",
                    "dziewietnascie", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"};

            if (number_of_digits > 3){
                continue;
            }
            if (number_of_digits == 3) {
                number_in_text = Character.getNumericValue(s.charAt(0));
                if (number_in_text != 0)
                    nowy_tekst = nowy_tekst + data[number_in_text - 1];
            }
            if (number_of_digits >= 2){
                if (number_of_digits == 3)
                    number_in_text = Character.getNumericValue(s.charAt(1));
                else
                    number_in_text = Character.getNumericValue(s.charAt(0));
                if (number_in_text == 0){
                    // cyfra dziesiatek == 0 --> pokazuje cyfre jednosci
                    if (number_of_digits == 3)
                        number_in_text = Character.getNumericValue(s.charAt(2));
                    else
                        number_in_text = Character.getNumericValue(s.charAt(1));
                    if (number_in_text != 0) {
                        nowy_tekst = nowy_tekst + data[26 + number_in_text];
                    }
                }
                else if (number_in_text == 1){
                    // dziesiec, jedenascie, ...
                    if (number_of_digits == 3)
                        number_in_text = Character.getNumericValue(s.charAt(2));
                    else
                        number_in_text = Character.getNumericValue(s.charAt(1));
                    if (number_in_text == 0)
                        nowy_tekst = nowy_tekst + "dziesiec";
                    else {
                        nowy_tekst = nowy_tekst + data[17+number_in_text];
                    }

                }
                else {
                    nowy_tekst = nowy_tekst + data[8+number_in_text];
                    if (number_of_digits == 3)
                        number_in_text = Character.getNumericValue(s.charAt(2));
                    else
                        number_in_text = Character.getNumericValue(s.charAt(1));
                    if (number_in_text != 0){
                        nowy_tekst = nowy_tekst + data[26+number_in_text];
                    }
                }
            }
            if (number_of_digits == 1){
                // pojedyncza cyfra
                number_in_text = Character.getNumericValue(s.charAt(0));
                if (number_in_text == 0)
                    nowy_tekst = nowy_tekst + "zero";
                else {
                    nowy_tekst = nowy_tekst + data[26+number_in_text];
                }
            }
//            System.out.println(nowy_tekst);
            output_string = output_string.substring(0, output_string.indexOf(s)) + nowy_tekst +
                    output_string.substring(output_string.indexOf(s)+number_of_digits);
//            System.out.println(output_string);
        }
        return output_string;
    }
}
