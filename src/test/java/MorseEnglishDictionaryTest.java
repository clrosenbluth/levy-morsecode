import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseEnglishDictionaryTest
{
    MorseEnglishDictionary dictionary = new MorseEnglishDictionary();

    @Test
    public void translate_English_good()
    {
        // given
        String english = "S";

        // when
        String translated = dictionary.translate(english);

        // then
        assertEquals("...", translated);
    }

    @Test
    public void translate_English_bad()
    {
        // given
        String english = ",";

        // when
        String translated = dictionary.translate(english);

        // then
        assertNull(translated);
    }

    @Test
    public void translate_Morse_good()
    {
        // given
        String morse = "...";

        // when
        String translated = dictionary.translate(morse);

        // then
        assertEquals("s", translated);
    }

    @Test
    public void translate_Morse_bad()
    {
        // given
        String morse = "----";

        // when
        String translated = dictionary.translate(morse);

        // then
        assertNull(translated);
    }

}