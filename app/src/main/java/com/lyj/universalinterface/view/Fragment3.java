package com.lyj.universalinterface.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lyj.universalinterface.R;
import com.lyj.universalinterface.init.BaseFragment;
import com.lyj.universalinterface.struct.FunctionManager;

/**
 * Created by oldkids001 on 2018/1/19.
 */

public class Fragment3 extends BaseFragment{
    View view;
    public static final String INTERFACE=Fragment3.class.getName()+"F3";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment3,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=FunctionManager.getManager().startFunction(INTERFACE,"有的吗",String.class);
                Toast.makeText(getContext(), "好的，收到了。", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
