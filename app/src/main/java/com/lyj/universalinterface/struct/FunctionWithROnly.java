package com.lyj.universalinterface.struct;

/**
 * Created by oldkids001 on 2018/1/19.
 * 无参数，有返回值
 */

public abstract class FunctionWithROnly<Result> extends SuFunction {
    public FunctionWithROnly(String name) {
        super(name);
    }

    public abstract Result function();

}
