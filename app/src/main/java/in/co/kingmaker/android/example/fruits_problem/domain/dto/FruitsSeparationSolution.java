package in.co.kingmaker.android.example.fruits_problem.domain.dto;

import java.util.ArrayList;

public class FruitsSeparationSolution {
    protected ArrayList<SeparationDTO> separationDTOAtVariousLevels = new ArrayList<>();
    protected int levels = 0;

    public void addNextSeparation(SeparationDTO separationDTO) {
        separationDTOAtVariousLevels.add(levels++, separationDTO);
    }

    public SeparationDTO getSeparationAtLevel(int level) {
        return separationDTOAtVariousLevels.get(level - 1);
    }

    public int getTotalLevels() {
        return levels;
    }
}
