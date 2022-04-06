// model

public class MorseCodeConverter
{
    private final MorseEnglishDictionary dictionary;

    public MorseCodeConverter(MorseEnglishDictionary dictionary)
    {
        this.dictionary = dictionary;
    }

    public String toMorseCode(String english)
    {
        char[] toTranslate = english.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char letter : toTranslate)
        {
            sb.append(dictionary.translate(String.valueOf(letter)));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String toEnglish(String morse)
    {
        String[] toTranslate = morse.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String letter : toTranslate)
        {
            sb.append(dictionary.translate(letter));
        }
        return sb.toString();
    }

}
