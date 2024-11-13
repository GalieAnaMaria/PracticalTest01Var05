package ro.pub.cs.systems.eim.practicaltest001var05;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest001Var05MainActivity extends AppCompatActivity {

    private TextView displayLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test001_var05_main);

        displayLog = findViewById(R.id.display_log);

        Button transferButton = findViewById(R.id.transfer_button);
        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticalTest001Var05MainActivity.this, AnotherActivity.class);
                String buttonLog = displayLog.getText().toString();
                intent.putExtra("button_log", buttonLog);
                startActivity(intent);
            }
        });

        Button topLeftButton = findViewById(R.id.top_left_button);
        Button topRightButton = findViewById(R.id.top_right_button);
        Button bottomLeftButton = findViewById(R.id.bottom_left_button);
        Button bottomRightButton = findViewById(R.id.bottom_right_button);
        Button centerButton = findViewById(R.id.center_button);

        // Define a listener for the buttons
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String buttonText = button.getText().toString();

                // Append the button text to displayLog with a comma separator
                String currentText = displayLog.getText().toString();
                if (!currentText.isEmpty()) {
                    currentText += ", ";
                }
                currentText += buttonText;

                displayLog.setText(currentText);
            }
        };

        // Set the same listener for all buttons
        topLeftButton.setOnClickListener(buttonClickListener);
        topRightButton.setOnClickListener(buttonClickListener);
        bottomLeftButton.setOnClickListener(buttonClickListener);
        bottomRightButton.setOnClickListener(buttonClickListener);
        centerButton.setOnClickListener(buttonClickListener);
    }
}

