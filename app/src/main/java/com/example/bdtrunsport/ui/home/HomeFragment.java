package com.example.bdtrunsport.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bdtrunsport.R;
import com.example.bdtrunsport.UniversityBus2;
import com.example.bdtrunsport.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

    Activity context;

    //  image_slider_two
    SliderView sliderView;
    int[] images = {
            R.drawable.img1,
            R.drawable.img3,
            R.drawable.img2
    };

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        homeViewModel =ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


//        image_slider
        sliderView = root.findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        return root;
    }
    public void onStart(){
        super.onStart();
        final LinearLayout busroute=(LinearLayout) context.findViewById(R.id.busroute);
        final LinearLayout findbus=(LinearLayout)context.findViewById(R.id.findbus);
        final LinearLayout map=(LinearLayout)context.findViewById(R.id.map);
        final LinearLayout train=(LinearLayout) context.findViewById(R.id.train);
        final LinearLayout universityBtn=(LinearLayout) context.findViewById(R.id.universityBtn);
        final LinearLayout banner =(LinearLayout) context.findViewById(R.id.banner);
        final LinearLayout busT =(LinearLayout) context.findViewById(R.id.busT);
        final LinearLayout lonchT =(LinearLayout) context.findViewById(R.id.lonchT);
        final LinearLayout flightT =(LinearLayout) context.findViewById(R.id.flightT);

        busroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, com.example.bdtrunsport.BusRecycleView.class);
                startActivity(intent);
            }
        });

        findbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, com.example.bdtrunsport.BusRecycleView.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, com.example.bdtrunsport.GoogleMaps.class);
                startActivity(intent);
            }
        });
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, com.example.bdtrunsport.Train_Tracking2.class);
                startActivity(intent);
            }
        });
        universityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(context, UniversityBus2.class);
                startActivity(intent1);
            }
        });

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

        busT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
        flightT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
        lonchT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}