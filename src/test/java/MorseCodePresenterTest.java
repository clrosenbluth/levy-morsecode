import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class MorseCodePresenterTest
{
    private MorseCodeFrame view = Mockito.mock(MorseCodeFrame.class);
    private MorseCodeConverter model = Mockito.mock(MorseCodeConverter.class);
    private MorseCodePresenter presenter = new MorseCodePresenter(model, view);
    private String english;
    private String morse;

    @Test
    public void toEnglish()
    {
        // given
        doReturn(english).when(model).toEnglish(morse);

        // when
        presenter.toEnglish(morse);

        // then
        verify(model).toEnglish(morse);
        verify(view).setEnglish(english);
    }

    @Test
    public void toMorse()
    {
        // given
        doReturn(morse).when(model).toMorseCode(english);

        // when
        presenter.toMorse(english);

        // then
        verify(model).toMorseCode(english);
        verify(view).setMorse(morse);
    }

}