package com.example.bdtrunsport.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bdtrunsport.R;

public class GalleryFragment extends Fragment {

    EditText value;
    TextView resultBus,resultCng,resultSohozCar,resultSohozBike,resultPathaoBike,resultPathaoCar,resultObhaiCar,resultObhaiBike;
    Button convert;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final EditText editText = root.findViewById(R.id.value);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                editText.setText(s);
            }
        });
        value = root.findViewById(R.id.value);

        convert = root.findViewById(R.id.convertBtn);

        resultBus = root.findViewById(R.id.resultBus);
        resultCng = root.findViewById(R.id.resultCng);
        resultSohozCar = root.findViewById(R.id.resultSohozCar);
        resultSohozBike = root.findViewById(R.id.resultSohozBike);
        resultPathaoBike = root.findViewById(R.id.resultPathaoBike);
        resultPathaoCar = root.findViewById(R.id.resultPathaoCar);
        resultObhaiCar = root.findViewById(R.id.resultObhaiCar);
        resultObhaiBike = root.findViewById(R.id.resultObhaiBike);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = value.getText().toString();
                double fare = Double.parseDouble(data);

                double fareBus = (fare*2.15) + 10;
                resultBus.setText(String.valueOf(fareBus));

                double fareCng = (fare*12) + 40;
                resultCng.setText(String.valueOf(fareCng));

                double fareSohozCar = (fare*30) + 50;
                resultSohozCar.setText(String.valueOf(fareSohozCar));

                double fareSohozBike = (fare*18) + 25;
                resultSohozBike.setText(String.valueOf(fareSohozBike));

                double farePathaoBike = (fare*14) + 30;
                resultPathaoBike.setText(String.valueOf(farePathaoBike));

                double farePathaoCar = (fare*35) + 100;
                resultPathaoCar.setText(String.valueOf(farePathaoCar));

                double fareObhaiCar = (fare*30) + 100;
                resultObhaiCar.setText(String.valueOf(fareObhaiCar));

                double fareObhaiBike = (fare*22) + 80;
                resultObhaiBike.setText(String.valueOf(fareObhaiBike));

                Toast.makeText(requireContext(), "Fare rate can vary according to time.", Toast.LENGTH_SHORT).show();

            }
        });
        return root;
    }
}


