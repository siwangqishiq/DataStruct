package com.xinlan.datastruct.file;

import java.io.File;

public class FileDemo
{

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        File dirFile = new File("E:\\apache-tomcat-7.0.47\\webapps\\img\\mei");
        File[] files = dirFile.listFiles();
        // for (int i = 0, size = files.length; i < size; i++)
        // {
        // File eachFile = files[i];
        // String filename = eachFile.getAbsolutePath();
        // if (filename.contains("����ľϣ"))
        // {
        // String newFilename = filename.replace("����ľϣ", "zuozuomuxi");
        // File newFile = new File(newFilename);
        // System.out.println("new FIle name-->" + newFilename);
        // eachFile.renameTo(newFile);
        // }
        // else if (filename.contains("ɼԭ����"))
        // {
        // String newFilename = filename.replace("ɼԭ����", "shanyuanxinli");
        // File newFile = new File(newFilename);
        // System.out.println("new FIle name-->" + newFilename);
        // eachFile.renameTo(newFile);
        // }
        // // System.out.println(filename);
        // }// end for i
        String ret = urls("http://10.24.64.60:8080/img/mei/", files);
        System.out.println(ret);
    }

    private static String urls(String prefix, File[] files)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, size = files.length; i < size; i++)
        {
            sb.append("\"" + prefix +files[i].getName()+ "\"");
            sb.append(",");
        }// end for i
        return sb.toString();
    }

}
