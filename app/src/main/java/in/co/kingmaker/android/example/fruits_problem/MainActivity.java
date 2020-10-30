package in.co.kingmaker.android.example.fruits_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
        btn1.setOnClickListener(view -> {
            if (editText.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Fruits count can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            clearTextViews();

            int fruits = Integer.parseInt(editText.getText().toString());
            if (fruits <= 0 || fruits % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate1 = fruits / 2 + 1;
            int fruitsRemainingAfterGate1 = fruits - fruitsGivenOnGate1;
            given1.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate1
                    )
            );
            remaining1.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate1
                    )
            );
        });

        btn2.setOnClickListener(view -> {
            if (editText.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Fruits count can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            clearTextViews();

            int fruits = Integer.parseInt(editText.getText().toString());
            if (fruits <= 0 || fruits % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate1 = fruits / 2 + 1;
            int fruitsRemainingAfterGate1 = fruits - fruitsGivenOnGate1;

            given1.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate1
                    )
            );
            remaining1.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate1
                    )
            );

            if (fruitsRemainingAfterGate1 <= 0 || fruitsRemainingAfterGate1 % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count after passing Gate 1 need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate2 = fruitsRemainingAfterGate1 / 2 + 1;
            int fruitsRemainingAfterGate2 = fruitsRemainingAfterGate1 - fruitsGivenOnGate2;

            given2.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate2
                    )
            );
            remaining2.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate2
                    )
            );
        });

        btn3.setOnClickListener(view -> {
            if (editText.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Fruits count can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            clearTextViews();

            int fruits = Integer.parseInt(editText.getText().toString());
            if (fruits <= 0 || fruits % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate1 = fruits / 2 + 1;
            int fruitsRemainingAfterGate1 = fruits - fruitsGivenOnGate1;

            given1.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate1
                    )
            );
            remaining1.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate1
                    )
            );

            if (fruitsRemainingAfterGate1 <= 0 || fruitsRemainingAfterGate1 % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count after passing Gate 1 need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate2 = fruitsRemainingAfterGate1 / 2 + 1;
            int fruitsRemainingAfterGate2 = fruitsRemainingAfterGate1 - fruitsGivenOnGate2;

            given2.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate2
                    )
            );
            remaining2.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate2
                    )
            );

            if (fruitsRemainingAfterGate2 <= 0 || fruitsRemainingAfterGate2 % 2 != 0) {
                Toast.makeText(MainActivity.this, "Fruits count after passing Gate 2 need to be a positive Even number", Toast.LENGTH_SHORT).show();
                return;
            }

            int fruitsGivenOnGate3 = fruitsRemainingAfterGate2 / 2 + 1;
            int fruitsRemainingAfterGate3 = fruitsRemainingAfterGate2 - fruitsGivenOnGate3;

            given3.setText(
                    String.format(
                            getString(R.string.given_count),
                            fruitsGivenOnGate3
                    )
            );
            remaining3.setText(
                    String.format(
                            getString(R.string.remaining_count),
                            fruitsRemainingAfterGate3
                    )
            );
        });
    }

    protected void clearTextViews() {
        given1.setText(getString(R.string.given));
        given2.setText(getString(R.string.given));
        given3.setText(getString(R.string.given));
        remaining1.setText(getString(R.string.remaining));
        remaining2.setText(getString(R.string.remaining));
        remaining3.setText(getString(R.string.remaining));
    }

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
}