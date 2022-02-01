package com.example.bdtrunsport.ui.termsCons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bdtrunsport.R;
import com.example.bdtrunsport.ui.termsCons.TermsConsViewModel;

public class termsCons extends Fragment {

    private TermsConsViewModel termsCons;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        termsCons =
                ViewModelProviders.of(this).get(TermsConsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_terms_cons, container, false);
        final TextView textView = root.findViewById(R.id.text_termsCons);
        termsCons.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}