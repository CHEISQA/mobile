package com.ensa.marhbabik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisie_note_2);  // Rappelez-vous d'utiliser le bon nom de fichier XML ici

        // Initialisation du bouton "Suivant"
        Button validerButton = findViewById(R.id.button_valider);

        // Ajouter un écouteur de clic pour démarrer l'activité de confirmation
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créer un Intent pour démarrer la page de confirmation
                Intent intent = new Intent(NotesActivity2.this, ConfirmationChoixActivity.class);
                startActivity(intent);  // Lancer l'activité de confirmation
            }
        });
    }
}
