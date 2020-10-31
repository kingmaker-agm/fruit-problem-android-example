package in.co.kingmaker.android.example.fruits_problem.domain.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeparationDTOTest {

    @Test
    public void getGiven() {
        SeparationDTO sut = new SeparationDTO(2,8);
        assertEquals(2, sut.getGiven());
    }

    @Test
    public void getRemaining() {
        SeparationDTO sut = new SeparationDTO(2,1);
        assertEquals(1, sut.getRemaining());
    }

    @Test
    public void itCanBeComparedForEqualityWithSimilarObject() {
        SeparationDTO sut1 = new SeparationDTO(9,8);
        SeparationDTO sut2 = new SeparationDTO(9,8);
        SeparationDTO sut3 = new SeparationDTO(9,18);

        assertEquals(sut1, sut2);
        assertNotEquals(sut1, sut3);
    }
}