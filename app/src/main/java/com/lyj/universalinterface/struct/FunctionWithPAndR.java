package com.lyj.universalinterface.struct;

/**
 * Created by oldkids001 on 2018/1/19.
 * 有参数，有返回值
 */

public abstract class FunctionWithPAndR<Result,Param> extends SuFunction {
    public FunctionWithPAndR(String name) {
        super(name);
    }

    public abstract Result function(Param param);
}
