package in.co.kingmaker.android.example.fruits_problem.domain.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitsSeparationSolutionTest {
    private FruitsSeparationSolution sut1;

    @Before
    public void setUpInitialSUT() {
        sut1 = new FruitsSeparationSolution();
        sut1.addNextSeparation(new SeparationDTO(16,16));
        sut1.addNextSeparation(new SeparationDTO(8,8));
    }

    @Test
    public void onAddingAnotherLevelSeparationTheLevelIncrementsAutomatically() {
        assertEquals(2, sut1.getTotalLevels());

        sut1.addNextSeparation(new SeparationDTO(4,4));
        assertEquals(3, sut1.getTotalLevels());

        sut1.addNextSeparation(new SeparationDTO(2,2));
        sut1.addNextSeparation(new SeparationDTO(1,1));
        assertEquals(5, sut1.getTotalLevels());
    }

    @Test
    public void weCanGetTheSolutionAtVariousAvailableLevels() {
        SeparationDTO s1 = sut1.getSeparationAtLevel(1);
        SeparationDTO s2 = sut1.getSeparationAtLevel(2);

        assertEquals(s1, new SeparationDTO(16,16));
        assertEquals(s2, new SeparationDTO(8,8));
    }
}