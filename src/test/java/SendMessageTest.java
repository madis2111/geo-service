import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.*;

import ru.netology.entity.*;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

public class SendMessageTest {


    @Test
    public void sendMessageTest() {
        GeoService geoService = mock(GeoService.class);
        LocalizationService localizationService = mock(LocalizationService.class);

        when(geoService.byIp(ArgumentMatchers.startsWith("172."))).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 5));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать!");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        HashMap<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        Assert.assertEquals("Добро пожаловать!", messageSender.send(map));

        verify(geoService).byIp("172.123.12.19");
        verify(localizationService, times(2)).locale(Country.RUSSIA);
    }
}