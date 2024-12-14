package com.ensa.marhbabik;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OptionListActivity extends AppCompatActivity {

    private ListView optionListView;
    private OptionAdapter optionAdapter;
    private List<OptionItem> optionItemList;
    private List<OptionItem> filteredList;
    private EditText searchEditText;
    private ImageView searchIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_list);

        optionListView = findViewById(R.id.option_list_view);
        searchEditText = findViewById(R.id.searchEditText);
        searchIcon = findViewById(R.id.searchIcon);

        // Create sample data
        optionItemList = new ArrayList<>();
        optionItemList.add(new OptionItem("Data Science et Cloud", "Chef de Filiere\nMoumen Aniss", R.drawable.data_science));
        optionItemList.add(new OptionItem("Software Engineering", "Chef de Filiere\nGahi Youssef", R.drawable.software_eng));
        // Add more items as needed

        // Initialize the filtered list with all items
        filteredList = new ArrayList<>(optionItemList);

        // Set up the adapter
        optionAdapter = new OptionAdapter(this, filteredList);
        optionListView.setAdapter(optionAdapter);

        // Set the search icon click listener
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchEditText.getText().toString().toLowerCase();
                filterList(searchText);
            }
        });
    }

    private void filterList(String searchText) {
        filteredList.clear();
        if (searchText.isEmpty()) {
            // If search text is empty, show all items
            filteredList.addAll(optionItemList);
        } else {
            // Filter items based on the search text
            for (OptionItem item : optionItemList) {
                if (item.getTitle().toLowerCase().contains(searchText)) {
                    filteredList.add(item);
                }
            }
        }
        optionAdapter.notifyDataSetChanged(); // Notify the adapter to refresh the list
    }
}
