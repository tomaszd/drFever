package com.doktornutria.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DosageDetails extends AppCompatActivity {

    /**
     * Nieco inaczej sprawa wygląda jeśli chodzi o czopki i tabletki (u dzieci starszych). W ich przypadku nie zawsze możemy podać dawkę dostosowaną idealnie do masy ciała dziecka. Jak je zatem dobrać? Pomnóż masę ciała przez widełki zalecanego dawkowania – otrzymasz zakres dawek terapeutycznych. Wybierz czopek o największej gramaturze mieszczącej się w tym zakresie.
     * Dostępne czopki z ibuprofenem: 60 mg, 125 mg
     * Dostępne czopki z paracetamolem: 50 mg, 80 mg, 125 mg, 150 mg, 180 mg, 250 mg, 300 mg, 500mg
     * Np. dziecko o masie 9 kg:
     * zakres terapeutyczny ibuprofenu to 45-90 mg – wybieramy czopek 60 mg.
     * zakres terapeutyczny paracetamolu 90-135 mg – wybieramy czopek 125 mg
     * Pamiętaj, że czopków nie wolno dzielić! Nie mają one gwarancji rozkładu substancji czynnej, więc jeśli odetniesz 1/3, nie wiesz czy tak naprawdę wyrzucasz 1/3 dawki, całą, a może wcale…
     * Co do tabletek – większość dzieci starszych, jak nauczy się połykania tabletek – woli tą formę od syropu.
     * W przypadku ibuprofenu na rynku dostępne są tabletki 200 mg i 400 mg (forte, max, itp.)
     * 200 mg tabletkę możemy podać dziecku, które waży > 20 kg.
     * 400 mg tabletkę możemy podać dziecku, które waży > 40 kg.
     * Paracetamol występuje w najczęstszej 500 mg tabletce, oraz 250 mg (saszetki), 300 mg, i 1 g. Niektóre tabletki po 500 mg są podzielne – można też uzyskać 250 mg.
     * 250 mg saszetkę możemy podać dziecku, które waży > 17 kg.
     * 300 mg tabletkę możemy podać dziecku, które waży > 20 kg.
     * 500 mg tabletkę możemy podać dziecku, które waży > 33 kg.
     * 750 mg możemy podać dziecku, które waży > 50 kg.
     * 1000 mg tabletkę możemy podać dziecku, które waży > 67 kg.
     * W przypadku dużych dzieci (i dorosłych) pamiętaj, że maksymalna dobowa dawka tych leków wynosi 1600mg (4 x po 400mg) dla ibuprofenu i 4g   (4x 1000mg) dla paracetamolu.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_details);
        //final EditText editMaxParacetamol = (EditText) findViewById(R.id.editMaxParacetamol);
        //final EditText editMinParacetamol = (EditText) findViewById(R.id.editMinParacetamol);
        Intent myIntent = getIntent();


        final String dosageValue = myIntent.getStringExtra("paracetamolAmount");
        final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);
        final Button buttonParacetamolDosageAmount = (Button) findViewById(R.id.buttonParacetamolDosageAmount);
        //editMinParacetamol.setText(String.valueOf(amountOfParacetamolMin));
        //editMaxParacetamol.setText(String.valueOf(amountOfParacetamolMax));
        buttonParacetamolDosageAmount.setText("  " + String.valueOf(amountOfParacetamolMax) + " mg");

        final TextView txtMaxDawka = (TextView) findViewById(R.id.txtMaxDawka);
        txtMaxDawka.setText("MAXYMALNA DAWKA DOBOWA " + String.valueOf(4 * amountOfParacetamolMax) + " mg");


        //Pills
        Button buttonPill = (Button) findViewById(R.id.buttonPillParacetamol);
        buttonPill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetails.this, PillDosageActivity.class);
                startNewDetailedActivityWithData(myIntent, dosageValue, amountOfParacetamolMin, amountOfParacetamolMax);
            }
        });

        //syrop
        Button buttonSyrop = (Button) findViewById(R.id.buttonSiropParacetamol);
        buttonSyrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetails.this, SirupDosageActivity.class);
                startNewDetailedActivityWithData(myIntent, dosageValue, amountOfParacetamolMin, amountOfParacetamolMax);
            }
        });
        //czopki
        Button buttonCzopek = (Button) findViewById(R.id.buttonCzopekParacetamol);
        buttonCzopek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetails.this, CzopekActivity.class);
                startNewDetailedActivityWithData(myIntent, dosageValue, amountOfParacetamolMin, amountOfParacetamolMax);
            }
        });
    }

    private void startNewDetailedActivityWithData(Intent myIntent, String dosageValue, Double amountOfParacetamolMin, Double amountOfParacetamolMax) {
        myIntent.putExtra("paracetamolDetails", dosageValue);
        myIntent.putExtra("amountOfParacetamolMin", amountOfParacetamolMin);
        myIntent.putExtra("amountOfParacetamolMax", amountOfParacetamolMax);
        DosageDetails.this.startActivity(myIntent);


    }
}
