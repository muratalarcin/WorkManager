package com.muratalarcin.workmanagerkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

import com.muratalarcin.workmanagerkullanimi.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonYap.setOnClickListener(view -> {
//            WorkRequest istek = new OneTimeWorkRequest.Builder(MyWorker.class)
//                    .setInitialDelay(10, TimeUnit.SECONDS)
//                    .build();

            WorkRequest istek = new PeriodicWorkRequest
                    .Builder(MyWorkerBildirim.class, 15, TimeUnit.MINUTES)//15dk
                    .setInitialDelay(10, TimeUnit.SECONDS)//10sn
                    .build();

            WorkManager.getInstance(this).enqueue(istek);
        });

    }
}