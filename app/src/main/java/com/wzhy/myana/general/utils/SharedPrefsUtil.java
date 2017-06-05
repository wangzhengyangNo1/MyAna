package com.wzhy.myana.general.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Set;

/**
 *
 * 偏好共享（SharedPreferences）工具类（多例）----枚举类
 * 每个实例对应一个sp文件，如，SP_APP对应file_app文件，SP_DEF对应file_def文件…
 *
 * Created by wangzhengyang on 2017/1/18.
 *
 * 使用：
 * <code>
 切换文件写入读取只需要一个“.”
 SharedPrefesUtil.SP_USER.……  //切换到file_app文件读写
 SharedPrefesUtil.SP_DEF.……   //切换到file_def文件读写

 //单个写入提交
 SharedPrefsUtil.SP_USER.writeToSP(SPKEYS.KEY_AGE, 32).commit();

 //批量写入提交
 SharedPrefsUtil.SP_USER
 .writeToUSER(SPKEYS.KEY_NAME, "张三")
 .writeToSP(SPKEYS.KEY_SEX, "男")
 .writeToSP(SPKEYS.KEY_AGE, 23)
 .commit();

 //读取
 String name = SharedPrefsUtil.SP_USER.readFromSP(SPKEYS.KEY_NAME, "");
 String sex = SharedPrefsUtil.SP_USER.readFromSP(SPKEYS.KEY_SEX, "");
 int age = SharedPrefsUtil.SP_USER.readFromSP(SPKEYS.KEY_AGE, 0);
 Log.i(TAG, "name: " + name + "\tsex: "+ sex + "\tage: " + age);

 //根据key移除
 boolean isRemoved = SharedPrefersUtil.SP_USER.remove(Util.SPKEYS.USER_NAME);

 //清除所有
 boolean isClear = SharedPrefersUtil.SP_USER.clear();

 </code>
 *
 */

public enum SharedPrefsUtil implements Util {

    SP_USER("file_user"),
    SP_CACHE("file_cache"),
    SP_COMMON("file_common");

    private final SharedPreferences SHARED_PREFS;
    private final String FILE_NAME;
    private final SharedPreferences.Editor EDITOR;

    SharedPrefsUtil(String FILE_NAME) {
        SHARED_PREFS = CONTEXT.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        EDITOR = SHARED_PREFS.edit();
        this.FILE_NAME = FILE_NAME;
    }

    /**
     * 获得文件名
     * @return 文件名
     */
    public String getFileName(){
        return FILE_NAME;
    }

    public SharedPrefsUtil writeToSP(String key, String value) {
        //if (TextUtils.isEmpty(key)) return false;
        EDITOR.putString(key, value);
        return this;
    }

    public String readFromSP(String key, String defValue) {
        //if (TextUtils.isEmpty(key)) return null;
        return SHARED_PREFS.getString(key, defValue);
    }

    public SharedPrefsUtil writeToSP(String key, boolean value) {
        //if (TextUtils.isEmpty(key)) return false;
        EDITOR.putBoolean(key, value);
        return this;
    }

    public boolean readFromSP(String key, boolean defValue) {
        //if (TextUtils.isEmpty(key)) return false;
        return SHARED_PREFS.getBoolean(key, defValue);
    }


    public SharedPrefsUtil writeToSP(String key, int value) {
        EDITOR.putInt(key, value);
        return this;
    }

    public int readFromSP(String key, int defValue) {
        return SHARED_PREFS.getInt(key, defValue);
    }

    public SharedPrefsUtil writeToSP(String key, float value) {
        EDITOR.putFloat(key, value);
        return this;
    }

    public float readFromSP(String key, float defValue) {
        return SHARED_PREFS.getFloat(key, defValue);
    }

    public SharedPrefsUtil writeToSP(String key, long value) {
        EDITOR.putLong(key, value);
        return this;
    }

    public long readFromSP(String key, long defValue) {
        return SHARED_PREFS.getLong(key, defValue);
    }

    public SharedPrefsUtil writeToSP(String key, @Nullable Set<String> values) {
        EDITOR.putStringSet(key, values);
        return this;
    }

    public Set<String> readFromSP(String key, @Nullable Set<String> defValues) {
        return SHARED_PREFS.getStringSet(key, defValues);
    }

    /**
     * 根据key移除
     * @param key
     * @return
     */
    public boolean remove(String key){
        return EDITOR.remove(key).commit();
    }

    /**
     * 清除SP文件中的所有数据
     * @return
     */
    public boolean clear(){
        return EDITOR.clear().commit();
    }

    /**
     * 提交
     * @return
     */
    public boolean commit(){
        return EDITOR.commit();
    }

}
