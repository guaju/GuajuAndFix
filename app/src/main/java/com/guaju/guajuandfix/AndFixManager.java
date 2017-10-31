package com.guaju.guajuandfix;

import android.content.Context;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by guaju on 2017/10/27.
 * 一个管理andfix热修复的管理类
 */

public class AndFixManager {
    private static  AndFixManager  afManager;
    PatchManager patchManager;
    private String versionName;

    private AndFixManager(Context context,String versionName){
        patchManager = new PatchManager(context);
        this.versionName=versionName;

    }

    public static AndFixManager getInstance(Context context,String versionName){
        if (afManager==null){
            synchronized (AndFixManager.class){
                if (afManager==null){
                    afManager=new AndFixManager(context,versionName);
                }
            }
        }
            return afManager;
    }
    //初始化andfix
    public void initAndFix(){
        //versionName是为了判断是不是属于一个体系
        if (patchManager==null){
            return;
        }
        patchManager.init(versionName);
        patchManager.loadPatch();

    }

    //判断服务器是否有可以补丁
    public  void  checkHasPatch() throws IOException {
        //如果补丁存在，那么下载
        if (MyApplication.isHasPatch){
             //to do download
            downLoadPatch();

        }

    }

    private void downLoadPatch() throws IOException {
//         //模拟下载完成，找到这个patch
        String  dir= Environment.getExternalStorageDirectory()+"/AndFixPatch/";
//        File dirFile=new File(dir);
//        if (!dirFile.exists()) {
//            dirFile.mkdirs();
//        }
        File patchFile=new File(dir,"guajuAndFix.apatch");
//        if (!patchFile.exists()){
//            patchFile.createNewFile();
//        }else{
//            //删除
//            patchFile.delete();
//            //再创建
//            patchFile.createNewFile();
//        }
//
        String  path=  patchFile.getAbsolutePath();


        loadPatch(path);

    }
    //这个是装载补丁
    private void loadPatch(String path) throws IOException {

        patchManager.addPatch(path);//path of the patch file that was downloaded

    }


}
