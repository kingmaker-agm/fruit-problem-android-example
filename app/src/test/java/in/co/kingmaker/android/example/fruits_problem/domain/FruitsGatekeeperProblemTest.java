package in.co.kingmaker.android.example.fruits_problem.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import in.co.kingmaker.android.example.fruits_problem.domain.dto.FruitsSeparationSolution;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FruitsGatekeeperProblemTest {
    private SeparationContract dummyStrategy, halvingStrategy;

    @Before
    public void setupDummyStrategy() throws Exception {
        dummyStrategy = mock(SeparationContract.class);
        when(dummyStrategy.getFruitsToBeGiven(anyInt())).thenAnswer(invocation -> 0);
        when(dummyStrategy.getRemainingFruits(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0, Integer.class);
            return argument;
        });
    }

    @Before
    public void setupHalvingStrategy() throws Exception {
        halvingStrategy = mock(SeparationContract.class);
        when(halvingStrategy.getFruitsToBeGiven(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0, Integer.class);
            if (argument % 2 != 0)
                throw new Exception();

            return  argument / 2;
        });
        when(halvingStrategy.getRemainingFruits(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0, Integer.class);
            if (argument % 2 != 0)
                throw new Exception();

            return  argument / 2;
        });
    }

    @Test
    public void separationStrategyInterfaceReceivesMethodCallsEqualsToLevelOfCalculations() throws Exception {
        FruitsGatekeeperProblem sut = new FruitsGatekeeperProblem(dummyStrategy);

        FruitsSeparationSolution solution = sut.calculateSeparations(5, 2);
        assertEquals(2, solution.getTotalLevels());
        assertEquals(5, solution.getSeparationAtLevel(1).getRemaining());
        assertEquals(5, solution.getSeparationAtLevel(2).getRemaining());
        assertEquals(0, solution.getSeparationAtLevel(1).getGiven());
        assertEquals(0, solution.getSeparationAtLevel(2).getGiven());

        verify(dummyStrategy, times(2)).getFruitsToBeGiven(5);
        verify(dummyStrategy, times(2)).getRemainingFruits(5);
    }

    @Test(expected = FruitsSeparationException.class)
    public void fruitSeparationExceptionIsThrownOnInAppropriateNumbers() throws FruitsSeparationException {
        FruitsGatekeeperProblem sut = new FruitsGatekeeperProblem(halvingStrategy);

        sut.calculateSeparations(18, 2);
    }
}