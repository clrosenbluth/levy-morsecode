public class MorseCodePresenter
{
    private final MorseCodeConverter model;
    private final MorseCodeFrame view;

    public MorseCodePresenter(MorseCodeConverter model, MorseCodeFrame view)
    {
        this.model = model;
        this.view = view;
    }


    public String toEnglish(String text)
    {
        return model.toEnglish(text);
    }

    public String toMorse(String text)
    {
        return model.toMorseCode(text);
    }
}
