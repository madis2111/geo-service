import org.junit.Test;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.Assert.*;

public class GeoServiceTest {

    @Test
    public void testByIp() {
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        String ip = "172.168.0.1";
        Location expectedLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actualLocation = geoServiceImpl.byIp(ip);
        assertEquals(expectedLocation.getCountry(), actualLocation.getCountry());
    }

    @Test
    public void exceptionTest() {
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        assertThrows(RuntimeException.class, () -> geoServiceImpl.byCoordinates(1.3, 2.6));
    }
}