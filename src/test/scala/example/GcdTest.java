package example;

import static org.junit.Assert.assertEquals;

public class GcdTest {

    @org.junit.Test
    public void gcd() {
        assertEquals(Gcd.gcd(120,25),5);
        assertEquals(Gcd.gcd(125,25),25);
        assertEquals(Gcd.gcd(874,1944),2);
        assertEquals(Gcd.gcd(493,899),29);
        assertEquals(Gcd.gcd(21212121,12121212),3030303);

    }

}