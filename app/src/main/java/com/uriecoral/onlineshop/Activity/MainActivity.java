package com.uriecoral.onlineshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.uriecoral.onlineshop.Adapter.PopularListAdapter;
import com.uriecoral.onlineshop.Categories.ComputersActivity;
import com.uriecoral.onlineshop.Categories.GamingActivity;
import com.uriecoral.onlineshop.Categories.PhonesActivity;
import com.uriecoral.onlineshop.Domain.PopularDomain;
import com.uriecoral.onlineshop.Categories.HeadphonesActivity;
import com.uriecoral.onlineshop.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    private ArrayList<PopularDomain> items;
    private ArrayList<PopularDomain> filteredItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

        EditText searchBar = findViewById(R.id.searchBar);

        // Listen for changes in the search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Filter the popular products based on the search input
                filterPopularProducts(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void filterPopularProducts(String query) {
        filteredItems.clear();
        for (PopularDomain item : items) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        adapterPopular = new PopularListAdapter(filteredItems);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

    private void bottom_navigation() {
        // ... (your existing code)
        LinearLayout llComputers = findViewById(R.id.llComputers);
        LinearLayout llPhones = findViewById(R.id.llPhones);
        LinearLayout llGaming = findViewById(R.id.llGaming);
        LinearLayout llHeadphones = findViewById(R.id.llHeadphones);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        llComputers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ComputersActivity.class));
            }
        });
        llPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhonesActivity.class));
            }
        });
        llGaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GamingActivity.class));
            }
        });
        llHeadphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HeadphonesActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        items = new ArrayList<>();
        // Populate items with your data
        items.add(new PopularDomain("ASUS VivoBook Pro\n14X OLED", "Asus Vivobook Pro 14X OLED is a Windows 10 Home" +
                "laptop with a 14.00-inch display that has a resolution" +
                "of 2880x1800 pixels. It is powered by an Intel Core" +
                "processor and it comes with 16GB of RAM. The Asus " +
                "Vivobook Pro 14X OLED packs 1TB of SSD storage.", "pic1", 15, 5, 500));
        items.add(new PopularDomain("PS5 Digital", "The PS5 Digital Edition boasts a custom AMD Ryzen Zen 2 Octa-core processor, "+
                "RDNA 2 GPU with 36 compute units, 16 GB GDDR6 RAM," +
                "and an 825 GB PCIe Gen4 NVMe SSD. Supporting 4K resolution gameplay, " +
                "ray tracing, and lacking an optical drive, it offers backward compatibility " +
                "with most PS4 games. The console includes the DualSense wireless controller " +
                "with haptic feedback, adaptive triggers, " +
                "and Tempest 3D AudioTech for an immersive experience."
                , "pic2", 10, 5, 450));
        items.add(new PopularDomain("iPhone 14", "Packing a familiar A15 chip and a vibrant 6.1-inch " +
                "OLED display, iPhone 14 shines with improved cameras, " +
                "Cinematic mode magic, and longer battery life, " +
                "making it a worthy refresh for everyday iPhone users.", "pic3", 13, 3, 800));

        filteredItems = new ArrayList<>(items);

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPopular = new PopularListAdapter(filteredItems);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}