package com.lyj.universalinterface.init;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.lyj.universalinterface.MainActivity;

/**
 * Created by oldkids001 on 2018/1/19.
 * 碎片基类
 */

public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            ((MainActivity)context).setFunctionForFragment();
        }
    }
}
