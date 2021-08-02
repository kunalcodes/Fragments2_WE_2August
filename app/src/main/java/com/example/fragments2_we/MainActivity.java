package com.example.fragments2_we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAddA;
    private Button mBtnRemoveA;
    private Button mBtnReplaceAWithBWithBackStack;
    private Button mBtnReplaceAWithBWithoutBackStack;
    private Button mBtnAddB;
    private Button mBtnRemoveB;
    private Button mBtnReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnReplaceAWithBWithBackStack = findViewById(R.id.btnReplaceAWithBWithBackStack);
        mBtnReplaceAWithBWithoutBackStack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnReplaceAWithBWithBackStack.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackStack.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnReplaceAWithBWithBackStack:
                replaceAWithBWithBackStack();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:A:
                replaceAWithB();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
        }
    }

    private void replaceAWithBWithBackStack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragB").commit();
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.replace(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

    private void replaceAWithB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void addB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void addA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

}