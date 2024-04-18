package models;

import org.junit.Assert;
import org.junit.Test;

public class DTOTest {

    @Test
    public void testConstructor() {
        Integer id = 1;
        String make = "Honda";
        String model = "Accord";
        Integer year = 2019;
        String color = "Black";

        DTO actual = new DTO(id, make, model, year, color);

        Assert.assertEquals(1, actual.getId());
        Assert.assertEquals("Honda", actual.getMake());
        Assert.assertEquals("Accord", actual.getModel());
        Assert.assertTrue(actual.getYear() == 2019);
        Assert.assertEquals("Black", actual.getColor());
    }
}
