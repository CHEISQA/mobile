package com.ensa.marhbabik.;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ensa.marhbabik.MainActivity;

public class ConfirmationChoixActivity extends AppCompatActivity {

    private TextView confirmationMessageTextView;
    private Button previousButton;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_choix); // Assurez-vous que le fichier XML est nommé correctement

        // Initialisation des widgets
        confirmationMessageTextView = findViewById(R.id.confirmationMessage);
        previousButton = findViewById(R.id.previousButton);
        confirmButton = findViewById(R.id.nextButton);

        // Récupérer l'option sélectionnée depuis l'intent
        Intent intent = getIntent();
        String selectedOption = intent.getStringExtra("selectedOption");

        // Afficher le message de confirmation avec l'option sélectionnée
        if (selectedOption != null) {
            String confirmationMessage = "Vous avez choisi : " + selectedOption + ".\nSi vous êtes sûr(e) de votre choix, veuillez cliquer sur le bouton Confirmer.";
            confirmationMessageTextView.setText(confirmationMessage);
        }

        // Gestion du bouton "Précédent"
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner à l'activité précédente
                finish();
            }
        });

        // Gestion du bouton "Confirmer"
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers une autre activité ou afficher un message final
                Intent intent = new Intent(ConfirmationChoixActivity.this, MainActivity.class); // Remplacez "FinalActivity" par votre prochaine activité
                startActivity(intent);
            }
        });
    }
}
