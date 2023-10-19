package com.example.SteapAppV2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepappv2.R;
import com.example.stepappv2.databinding.FragmentHomeBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView stepCountsView;
    private Button startButton;
    private Button countButton;
    private ProgressBar progressBar;
    private String counterString = "0";
    private int counter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        stepCountsView = (TextView) root.findViewById(R.id.counter);
        stepCountsView.setText(counterString);
        progressBar = (CircularProgressIndicator) root.findViewById(R.id.progressBar);
        progressBar.setMax(100);

        final TextView textView = binding.stepsText;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        startButton = (Button) root.findViewById(R.id.startButton);
        countButton = (Button) root.findViewById(R.id.countButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter = 0;
                progressBar.setProgress(counter);
                counterString = Integer.toString(counter);
                stepCountsView.setText(counterString);
            }
        });

        countButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter += 1;
                progressBar.setProgress(counter);
                counterString = Integer.toString(counter);
                stepCountsView.setText(counterString);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}