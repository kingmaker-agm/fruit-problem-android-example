package in.co.kingmaker.android.example.fruits_problem.domain;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import in.co.kingmaker.android.example.fruits_problem.domain.dto.FruitsSeparationSolution;
import in.co.kingmaker.android.example.fruits_problem.domain.dto.SeparationDTO;

import static org.junit.Assert.*;

public class FruitsSeparationExceptionTest {
    private FruitsSeparationSolution stub;

    @Before
    public void setupSolutionStub() {
        stub = new FruitsSeparationSolution();
        stub.addNextSeparation(new SeparationDTO(21,20));
        stub.addNextSeparation(new SeparationDTO(11,9));
    }

    @Test
    public void it_accepts_intermediate_solution_as_an_constructor_argument() {
        FruitsSeparationException sut = new FruitsSeparationException(stub, "test exception");
        assertEquals(stub, sut.intermediateSolution);

        FruitsSeparationException sut2 = new FruitsSeparationException(2, stub, "test exception");
        assertEquals(stub, sut2.intermediateSolution);
    }

    @Test
    public void it_accepts_only_intermediate_solution_and_calculates_error_level_from_intermediate_solution() {
        FruitsSeparationException sut = new FruitsSeparationException(stub, "test exception");
        assertEquals(stub.getTotalLevels() + 1, sut.exceptionsLevel);
    }
}