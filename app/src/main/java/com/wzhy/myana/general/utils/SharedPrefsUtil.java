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
 *     //写入SP文件（file_app.shared_prefs文件）中
 *     boolean isSaved = SharedPrefersUtil.SP_APP.writeToSP(Util.SPKEYS.USER_NAME, "John");
 *
 *     ……
 *
 *     //从SP文件（file_app.shared_prefs文件）中读取
 *     String userName = SharedPrefersUtil.SP_APP.readFromSP(Util.SPKEYS.USER_NAME,"");
 *
 *     ……
 *
 *     //根据key移除
 *     boolean isRemoved = SharedPrefersUtil.SP_APP.remove(Util.SPKEYS.USER_NAME);
 *
 *     ……
 *
 *     //清除所有
 *     boolean isClear = SharedPrefersUtil.SP_APP.clear();
 *
 * </code>
 *
 */

public enum SharedPrefsUtil implements Util {

    SP_APP("file_app"),
    SP_DEF("file_def");

    private final SharedPreferences SHARED_PREFS;
    private final String FILE_NAME;

    SharedPrefsUtil(String FILE_NAME) {
        SHARED_PREFS = CONTEXT.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        this.FILE_NAME = FILE_NAME;
    }

    /**
     * 获得文件名
     * @return 文件名
     */
    public String getFileName(){
        return FILE_NAME;
    }

    public boolean writeToSP(String key, @Nullable String value) {
        //if (TextUtils.isEmpty(key)) return false;
        return SHARED_PREFS.edit().putString(key, value).commit();
    }

    public String readFromSP(String key, @Nullable String defValue) {
        //if (TextUtils.isEmpty(key)) return null;
        return SHARED_PREFS.getString(key, defValue);
    }

    public boolean writeToSP(String key, boolean value) {
        //if (TextUtils.isEmpty(key)) return false;
        return SHARED_PREFS.edit().putBoolean(key, value).commit();
    }

    public boolean readFromSP(String key, boolean defValue) {
        //if (TextUtils.isEmpty(key)) return false;
        return SHARED_PREFS.getBoolean(key, defValue);
    }


    public boolean writeToSP(String key, int value) {
        return SHARED_PREFS.edit().putInt(key, value).commit();
    }

    public int readFromSP(String key, int defValue) {
        return SHARED_PREFS.getInt(key, defValue);
    }

    public boolean writeToSP(String key, float value) {
        return SHARED_PREFS.edit().putFloat(key, value).commit();
    }

    public float readFromSP(String key, float defValue) {
        return SHARED_PREFS.getFloat(key, defValue);
    }

    public boolean writeToSP(String key, long value) {
        return SHARED_PREFS.edit().putLong(key, value).commit();
    }

    public long readFromSP(String key, long defValue) {
        return SHARED_PREFS.getLong(key, defValue);
    }

    public boolean writeToSP(String key, @Nullable Set<String> values) {
        return SHARED_PREFS.edit().putStringSet(key, values).commit();
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
        return SHARED_PREFS.edit().remove(key).commit();
    }

    /**
     * 清除SP文件中的所有数据
     * @return
     */
    public boolean clear(){
        return SHARED_PREFS.edit().clear().commit();
    }

}
