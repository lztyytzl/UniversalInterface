package com.lyj.universalinterface;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lyj.universalinterface.struct.FunctionManager;
import com.lyj.universalinterface.struct.FunctionNoPNoR;
import com.lyj.universalinterface.struct.FunctionWithPAndR;
import com.lyj.universalinterface.struct.FunctionWithROnly;
import com.lyj.universalinterface.view.Fragment1;
import com.lyj.universalinterface.view.Fragment2;
import com.lyj.universalinterface.view.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    FrameLayout contentView;
    TextView tab1,tab2,tab3;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tab1= (TextView) findViewById(R.id.f1);
        tab2= (TextView) findViewById(R.id.f2);
        tab3= (TextView) findViewById(R.id.f3);
        contentView= (FrameLayout) findViewById(R.id.f_content);
        fragments=new ArrayList<>();
        manager=getSupportFragmentManager();

    }

    /**
     * 实现FunctionManager
     */
    public void setFunctionForFragment() {
        FunctionManager manager=FunctionManager.getManager();
        manager.addFunction(new FunctionNoPNoR(Fragment1.INSTANCE) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "无参数无返回值", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithROnly<String>(Fragment2.INSTANCE) {
            @Override
            public String function() {
                Toast.makeText(MainActivity.this, "成功调用无参数，有返回", Toast.LENGTH_SHORT).show();
                return "无参有返回OK";
            }
        }).addFunction(new FunctionWithPAndR<String,String>(Fragment3.INTERFACE) {
            @Override
            public String function(String s) {
                Toast.makeText(MainActivity.this, "参数有返回吧?", Toast.LENGTH_SHORT).show();
                return "有参数有返回值OK";
            }
        });

    }
}
