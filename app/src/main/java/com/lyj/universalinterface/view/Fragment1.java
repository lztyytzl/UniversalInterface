package com.lyj.universalinterface.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyj.universalinterface.R;
import com.lyj.universalinterface.init.BaseFragment;
import com.lyj.universalinterface.struct.FunctionManager;

/**
 * Created by oldkids001 on 2018/1/19.
 */

public class Fragment1 extends BaseFragment{
    View view;
    //接口名
    public static final String  INSTANCE=Fragment1.class.getName()+"F1";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getManager().startFunction(INSTANCE);
            }
        });
    }
}
