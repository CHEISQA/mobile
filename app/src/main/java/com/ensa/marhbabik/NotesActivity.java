package com.ensa.marhbabik;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {

    private EditText[] noteInputs;
    private Button validerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisie_note); // Assurez-vous que le fichier XML est correct

        // Initialisation des champs de saisie
        noteInputs = new EditText[]{
                findViewById(R.id.noteModule1),
                findViewById(R.id.noteModule2),
                findViewById(R.id.noteModule3),
                findViewById(R.id.noteModule4),
                findViewById(R.id.noteModule5),
                findViewById(R.id.noteModule6)
        };

        // Bouton "Suivant"
        validerButton = findViewById(R.id.button_valider);
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifierSaisieNotes()) {
                    // Passer à l'activité suivante
                    Intent intent = new Intent(NotesActivity.this, NotesActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(NotesActivity.this, "Veuillez remplir toutes les notes.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Vérifie si toutes les notes ont été saisies.
     *
     * @return true si toutes les notes sont remplies, sinon false
     */
    private boolean verifierSaisieNotes() {
        for (EditText noteInput : noteInputs) {
            String noteText = noteInput.getText().toString().trim();
            if (TextUtils.isEmpty(noteText)) {
                return false;
            }
        }
        return true;
    }
}
