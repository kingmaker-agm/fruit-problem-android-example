package in.co.kingmaker.android.example.fruits_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    TextView given1, given2, given3, remaining1, remaining2, remaining3;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        attachButtonListeners();
    }

    private void attachButtonListeners() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    protected void calculateFruitsSeparation(int initialFruitsCount, int level) throws IllegalArgumentException, IllegalStateException {
        int[] allowedLevels = {1,2,3};
        if (Arrays.stream(allowedLevels).noneMatch(i -> i == level))
            throw new IllegalArgumentException("The Level value of 1-3 are only allowed");

        for(int lvl = 1, fruitsAtCurrentLevel = initialFruitsCount; lvl <= level; lvl++) {
            if (fruitsAtCurrentLevel < 0 || fruitsAtCurrentLevel % 2 != 0)
                throw new IllegalStateException("Fruits count after passing Gate " + level + " need to be a positive Even number");

            int fruitsGivenAtCurrentLevel  = fruitsAtCurrentLevel / 2 + 1;
            fruitsAtCurrentLevel -= fruitsGivenAtCurrentLevel;
            setGivenValue(fruitsGivenAtCurrentLevel, lvl);
            setRemainingValue(fruitsAtCurrentLevel, lvl);
        }
    }

    /**
     * Set the Fruits given Text in the respective level TextView
     *
     * @param fruitsCount The Fruits Count to be shown in the given TextView
     * @param level The Level of the Gate
     * @throws IllegalArgumentException when wrong level value is provided
     */
    protected void setGivenValue(int fruitsCount, int level) throws IllegalArgumentException {
        TextView target;
        switch (level) {
            case 1:
                target = given1;
                break;
            case 2:
                target = given2;
                break;
            case 3:
                target = given3;
                break;
            default:
                throw new IllegalArgumentException("The Level value of 1-3 are only allowed");
        }
        target.setText(
                String.format(
                        getString(R.string.given_count),
                        fruitsCount
                )
        );
    }

    /**
     * Set the Fruits remaining Text in the respective level TextView
     *
     * @param fruitsCount The Fruits Count to be shown in the remaining TextView
     * @param level The Level of the Gate
     * @throws IllegalArgumentException when wrong level value is provided
     */
    protected void setRemainingValue(int fruitsCount, int level) throws IllegalArgumentException {
        TextView target;
        switch (level) {
            case 1:
                target = remaining1;
                break;
            case 2:
                target = remaining2;
                break;
            case 3:
                target = remaining3;
                break;
            default:
                throw new IllegalArgumentException("The Level value of 1-3 are only allowed");
        }
        target.setText(
                String.format(
                        getString(R.string.remaining_count),
                        fruitsCount
                )
        );
    }

    /**
     * display the message on the screen
     *
     * @param message message to be shown
     */
    protected void showMessage(String message) {
        this.showToastMessage(message, Toast.LENGTH_SHORT);
    }

    /**
     * display the Toast message on the screen
     *
     * @param message message to be shown
     * @param duration duration (Toast) of the visibility of the message
     */
    protected void showToastMessage(String message, int duration) {
        Toast.makeText(MainActivity.this, message, duration).show();
    }

    /**
     * check whether the Fruits count field is empty
     *
     * @return true if the field is empty, false otherwise
     */
    protected boolean isFruitsFieldEmpty() {
        return editText.getText().toString().equals("");
    }

    /**
     * clear the results in the Screen (given & remaining values)
     */
    protected void clearTextViews() {
        given1.setText(getString(R.string.given));
        given2.setText(getString(R.string.given));
        given3.setText(getString(R.string.given));
        remaining1.setText(getString(R.string.remaining));
        remaining2.setText(getString(R.string.remaining));
        remaining3.setText(getString(R.string.remaining));
    }

    /**
     * bind the views to the attributes
     */
    protected void initializeViews() {
        editText = findViewById(R.id.et_fruits);
        given1 = findViewById(R.id.tv_given1);
        given2 = findViewById(R.id.tv_given2);
        given3 = findViewById(R.id.tv_given3);
        remaining1 = findViewById(R.id.tv_remaining1);
        remaining2 = findViewById(R.id.tv_remaining2);
        remaining3 = findViewById(R.id.tv_remaining3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
    }

    @Override
    public void onClick(View view) {
        if (isFruitsFieldEmpty()) {
            showMessage("Fruits count can't be empty");
            return;
        }

        clearTextViews();

        int level = -1;
        switch (view.getId()) {
            case R.id.btn1:
                level = 1;
                break;
            case R.id.btn2:
                level = 2;
                break;
            case R.id.btn3:
                level = 3;
                break;
            default:
                return;
        }

        try {
            this.calculateFruitsSeparation(
                    Integer.parseInt(editText.getText().toString()),
                    level
            );
        } catch (IllegalStateException e) {
            showMessage(e.getMessage());
        }
    }
}