package com.lyj.universalinterface.struct;

/**
 * Created by oldkids001 on 2018/1/19.
 * 有参数，无返回
 */

public abstract class FunctionWithPOnly<Param> extends SuFunction{
    public FunctionWithPOnly(String name) {
        super(name);
    }

    public abstract void function(Param param);
}
