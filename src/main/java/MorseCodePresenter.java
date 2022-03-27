public class MorseCodePresenter
{
    private final MorseCodeConverter model;
    private final MorseCodeFrame view;

    public MorseCodePresenter(MorseCodeConverter model, MorseCodeFrame view)
    {
        this.model = model;
        this.view = view;
    }


    public void toEnglish(String text)
    {
        view.setEnglish(model.toEnglish(text));
    }

    public void toMorse(String text)
    {
        view.setMorse(model.toMorseCode(text));
    }
}
