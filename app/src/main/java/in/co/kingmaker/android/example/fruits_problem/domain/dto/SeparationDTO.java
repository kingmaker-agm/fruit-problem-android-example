package in.co.kingmaker.android.example.fruits_problem.domain.dto;

import androidx.annotation.Nullable;

public class SeparationDTO {
    protected int given;
    protected int remaining;

    public SeparationDTO(int given, int remaining) {
        this.given = given;
        this.remaining = remaining;
    }

    public int getGiven() {
        return given;
    }

    public int getRemaining() {
        return remaining;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SeparationDTO)
            return ((SeparationDTO) obj).given == this.given && ((SeparationDTO) obj).remaining == this.remaining;

        return super.equals(obj);
    }
}
