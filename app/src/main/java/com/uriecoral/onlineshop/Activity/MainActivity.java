package com.uriecoral.onlineshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initRecyclerview();
        bottom_navigation();
    }

    private void bottom_navigation() {
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
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("ASUS VivoBook Pro\n14X OLED", "Asus Vivobook Pro 14X OLED is a Windows 10 Home" +
                "laptop with a 14.00-inch display that has a resolution" +
                "of 2880x1800 pixels. It is powered by a Intel Core" +
                "processor and it comes with 16GB of RAM. The Asus " +
                "Vivobook Pro 14X OLED packs 1TB of SSD storage.", "pic1", 15, 5, 500));
        items.add(new PopularDomain("Ps-5 Digital", "The PS5 Digital Edition boasts a custom AMD Ryzen Zen 2 Octa-core processor, "+
                "RDNA 2 GPU with 36 compute units, 16 GB GDDR6 RAM," +
                "and an 825 GB PCIe Gen4 NVMe SSD. Supporting 4K resolution gameplay, " +
                "ray tracing, and lacking an optical drive, it offers backward compatibility " +
                "with most PS4 games. The console includes the DualSense wireless controller " +
                "with haptic feedback, adaptive triggers, " +
                "and Tempest 3D AudioTech for an immersive experience."
                , "pic2", 10, 5, 450));
        items.add(new PopularDomain("IPhone 14", "Packing a familiar A15 chip and a vibrant 6.1-inch " +
                "OLED display, iPhone 14 shines with improved cameras, " +
                "Cinematic mode magic, and longer battery life, " +
                "making it a worthy refresh for everyday iPhone users.", "pic3", 13, 3, 800));

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPopular = new PopularListAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

}