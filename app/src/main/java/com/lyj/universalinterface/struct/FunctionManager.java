package com.lyj.universalinterface.struct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by oldkids001 on 2018/1/19.
 * 接口管理类
 */

public class FunctionManager {
    private static FunctionManager instance=null;

    private static synchronized void sync(){
        if (instance==null){
            instance=new FunctionManager();
        }
    }
    /**一次实例多次调用*/
    public static FunctionManager getManager(){
        if (instance==null){
            sync();
        }
        return instance;
    }

    /**私有的构造方法*/
    private FunctionManager() {
        mFunctionNoPNoR=new HashMap<>();
        mFunctionWithPAndR=new HashMap<>();
        mFunctionWithPOnly=new HashMap<>();
        mFunctionWithROnly=new HashMap<>();

    }
    /**集合存储方法名*/
    private HashMap<String,FunctionNoPNoR> mFunctionNoPNoR;
    private HashMap<String,FunctionWithPAndR> mFunctionWithPAndR;
    private HashMap<String,FunctionWithPOnly> mFunctionWithPOnly;
    private HashMap<String,FunctionWithROnly> mFunctionWithROnly;

    /**创建对应的接口*/
    public FunctionManager addFunction(FunctionNoPNoR function){
        mFunctionNoPNoR.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithPAndR function){
        mFunctionWithPAndR.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithPOnly function){
        mFunctionWithPOnly.put(function.functionName,function);
        return this;
    }

    public FunctionManager addFunction(FunctionWithROnly function){
        mFunctionWithROnly.put(function.functionName,function);
        return this;
    }

    /**
     *
     * @param functionName 方法名
     */
    public void startFunction(String functionName) {
        if (!TextUtils.isEmpty(functionName)){
            return ;
        }
        if (mFunctionNoPNoR!=null){
            FunctionNoPNoR f=mFunctionNoPNoR.get(functionName);
            if (f!=null){
                f.function();
            }
            if (f==null){
                try {
                    throw new Exception("方法名不能为空"+functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param functionName 方法名
     * @param param 参数
     * @param <Param> 参数类型
     */
    public <Param> void startFunction(String functionName, Param param) {
        if (!TextUtils.isEmpty(functionName)){
            return ;
        }
        if (mFunctionWithPOnly!=null){
            FunctionWithPOnly f=mFunctionWithPOnly.get(functionName);
            if (f!=null){
                f.function(param);
            }
            if (f==null){
                try {
                    throw new Exception("方法名不能为空"+functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param functionName 方法名
     * @param
     * @param <Result> 返回值类型
     * @return
     */
    public <Result> Result startFunction(String functionName,Class<Result> r) {
        if (!TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithROnly!=null){
            FunctionWithROnly f=mFunctionWithROnly.get(functionName);
            if (f!=null){
                if (r!=null){
                    //cast  Casts an object to the class or interface represented
                    // 将对象转换为 类或者 接口
                    return r.cast(f.function());
                }
                return (Result) f.function();
            }
            if (f==null){
                try {
                    throw new Exception("方法名不能为空"+functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     *
     * @param functionName 方法名
     * @param param 参数
     * @param r 返回值
     * @param <Result> 返回值类型
     * @param <Param> 参数类型
     * @return
     */
    public <Result,Param> Result startFunction(String functionName,Param param,Class<Result> r) {
        if (!TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithPAndR!=null){
            FunctionWithPAndR f=mFunctionWithPAndR.get(functionName);
            if (f!=null){
                if (r!=null){
                    return r.cast(f.function(param));
                }
                return (Result) f.function(param);
            }
            if (f==null){
                try {
                    throw new Exception("方法名不能为空"+functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
