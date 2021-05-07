package string;

public class SentenceCapitalization {
    public static void main(String[] args) {
        System.out.println(capitalize("trees are        beautiful"));
    }

    private static String capitalize(String sentence) {
        StringBuilder result = new StringBuilder();
        for (String word : sentence.replaceAll(" +", " ").split(" ")) {

            result.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase())
                    .append(" ");

        }
        return "'" + result.toString().trim() + "'";
    }
}
