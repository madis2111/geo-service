import org.junit.Assert;
import org.junit.Test;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {

    @Test
    public void testLocale() {
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();

        String resultRussia = localizationServiceImpl.locale(Country.RUSSIA);
        Assert.assertEquals("Добро пожаловать", resultRussia);
        String resultOther = localizationServiceImpl.locale(Country.OTHER);
        Assert.assertEquals("Welcome", resultOther);
    }
}