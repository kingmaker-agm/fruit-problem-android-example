package in.co.kingmaker.android.example.fruits_problem.domain;

public interface SeparationContract {
    /**
     * The Fruits to be given for the GateKeeper
     * @param fruitsAtHand fruits count
     * @return fruits to be given for the GateKeeper
     * @throws Exception when the Fruits can't be split up
     */
    public int getFruitsToBeGiven(int fruitsAtHand) throws Exception;

    /**
     * The Fruits available at the hand after giving the GateKeeper his share
     * @param fruitsAtHand fruits count
     * @return fruits remaining after giving the GateKeeper his share
     * @throws Exception when the Fruits can't be split up
     */
    public int getRemainingFruits(int fruitsAtHand) throws Exception;
}
