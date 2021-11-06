package com.example.againstcrit;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.againstcrit.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static final String TAG = "FirstFragment";

    private void methodInGitHub(){
      System.out.println("");
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //aaaa
        //bbbb
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return new 12345();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append("jskkgvaucygahsvcluisgdcuv");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Log.d(TAG, "两个时间差距大于一秒 onclick开始处理");
                Intent intent = new Intent(getContext(),TestActivity.class);
                startActivity(intent);
            }
        };
        ssb.setSpan(clickableSpan,5,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.buttonFirst.setText(ssb);
        binding.buttonFirst.setMovementMethod(LinkMovementMethod.getInstance());
        binding.buttonFirst.setOnTouchListener(new View.OnTouchListener() {
            long lastEventTime = -1000;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d(TAG, "事件时间："+motionEvent.getDownTime());
                    if((motionEvent.getDownTime() - lastEventTime) < 1000){
                        Log.d(TAG, "两个时间差距" +( motionEvent.getDownTime() - lastEventTime)+ "不到一秒 不给onclick处理");
                        lastEventTime = motionEvent.getDownTime();
                        return true;
                    }
                    lastEventTime = motionEvent.getDownTime();
                }
                return false;
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "两个时间差距大于一秒 按键的onclick开始处理");
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
