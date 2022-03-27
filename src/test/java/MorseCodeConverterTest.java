import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeConverterTest
{
    MorseEnglishDictionary dictionary = Mockito.mock(MorseEnglishDictionary.class);

    @Test
    public void toMorseCode()
    {
        // given
        Mockito.doReturn("...").when(dictionary).translate("s");
        MorseCodeConverter converter = new MorseCodeConverter(dictionary);

        // when
        String morse = converter.toMorseCode("sss");

        // then
        assertEquals(".........", morse);
        Mockito.verify(dictionary, Mockito.times(3)).translate("s");
    }

    @Test
    public void toEnglish()
    {
        // given
        Mockito.doReturn("s").when(dictionary).translate("...");
        MorseCodeConverter converter = new MorseCodeConverter(dictionary);

        // when
        String english = converter.toEnglish("... ... ...");

        // then
        assertEquals("sss", english);
        Mockito.verify(dictionary, Mockito.times(3)).translate("...");
    }
}