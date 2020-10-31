package in.co.kingmaker.android.example.fruits_problem.domain;

import in.co.kingmaker.android.example.fruits_problem.domain.dto.FruitsSeparationSolution;

public class FruitsSeparationException extends Exception {
    public int exceptionsLevel;
    public FruitsSeparationSolution intermediateSolution;

    public FruitsSeparationException(FruitsSeparationSolution intermediateSolution, String message) {
        this(intermediateSolution.getTotalLevels() + 1, intermediateSolution, message);
    }

    public FruitsSeparationException(int exceptionsLevel, FruitsSeparationSolution intermediateSolution, String message) {
        super(message);
        this.exceptionsLevel = exceptionsLevel;
        this.intermediateSolution = intermediateSolution;
    }
}
