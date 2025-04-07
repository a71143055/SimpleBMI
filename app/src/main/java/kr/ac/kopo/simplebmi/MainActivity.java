package kr.ac.kopo.simplebmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2, edit3;
    TextView textResult;

    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        textResult = findViewById(R.id.textResult);
        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = edit1.getText().toString();
            String height = edit2.getText().toString();
            String weight = edit3.getText().toString();

            float h = Float.parseFloat(height);
            float w = Float.parseFloat(weight);

            Button btnEvent = (Button) v;
            if(btnEvent == btnResult) {
                float bmi = w / ((h/100) * (h/100));
                textResult.setText("BMI 측정 결과 : " + name + "님의 키는 " + height + "cm, 체중은 " + weight + "kg, BMI 지수는 " + bmi + "㎏/㎡입니다.");
            }
        }
    };
}