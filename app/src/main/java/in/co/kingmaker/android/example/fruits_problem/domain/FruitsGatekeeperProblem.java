package in.co.kingmaker.android.example.fruits_problem.domain;

import in.co.kingmaker.android.example.fruits_problem.domain.dto.FruitsSeparationSolution;
import in.co.kingmaker.android.example.fruits_problem.domain.dto.SeparationDTO;

public class FruitsGatekeeperProblem {
    protected SeparationContract separationLogic;

    public FruitsGatekeeperProblem(SeparationContract separationLogic) {
        this.separationLogic = separationLogic;
    }

    public FruitsSeparationSolution calculateSeparations(int fruitsCount, int levels) throws FruitsSeparationException {
        FruitsSeparationSolution result = new FruitsSeparationSolution();

        for (int level = 1; level <= levels; level++) {
            try {
                int fruitsToGive = separationLogic.getFruitsToBeGiven(fruitsCount);
                fruitsCount = separationLogic.getRemainingFruits(fruitsCount);
                result.addNextSeparation(new SeparationDTO(fruitsToGive, fruitsCount));
            } catch (Exception e) {
                throw new FruitsSeparationException(result, e.getMessage());
            }
        }

        return result;
    }
}
