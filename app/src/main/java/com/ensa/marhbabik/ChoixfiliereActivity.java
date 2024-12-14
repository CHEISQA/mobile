package com.ensa.marhbabik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixfiliereActivity extends AppCompatActivity {

    private EditText studentNameEditText;
    private EditText studentFirstnameEditText;
    private EditText studentEmailEditText;
    private EditText studentApogeeEditText;
    private RadioGroup radioGroupOptions;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_filiere); // Assurez-vous que le fichier XML est nommé correctement

        // Initialisation des widgets
        studentNameEditText = findViewById(R.id.student_name_edittext);
        studentFirstnameEditText = findViewById(R.id.student_firstname_edittext);
        studentEmailEditText = findViewById(R.id.student_email_edittext);
        studentApogeeEditText = findViewById(R.id.student_apogee_edittext);
        radioGroupOptions = findViewById(R.id.radio_group_options);
        validateButton = findViewById(R.id.btn_validate);

        // Désactiver les champs non modifiables
        disableEditText(studentNameEditText);
        disableEditText(studentFirstnameEditText);
        disableEditText(studentEmailEditText);
        disableEditText(studentApogeeEditText);

        // Configuration du bouton de validation
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = radioGroupOptions.getCheckedRadioButtonId();

                if (selectedOptionId != -1) {
                    RadioButton selectedOption = findViewById(selectedOptionId);
                    String selectedText = selectedOption.getText().toString();

                    // Passer à la page de confirmation
                    Intent intent = new Intent(ChoixfiliereActivity.this, ConfirmationChoixActivity.class);
                    intent.putExtra("selectedOption", selectedText);
                    startActivity(intent);
                }
            }
        });
    }

    // Méthode pour désactiver la modification d'un EditText
    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setClickable(false);
    }
}
