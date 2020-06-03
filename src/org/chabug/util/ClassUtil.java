package org.chabug.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

public class ClassUtil {
    // 获取exp路径
    public static String PATH = ClassUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "org/chabug/exploit/";

    /**
     * 获取漏洞大分类
     *
     * @return
     */
    public static ObservableList<String> getVulnType() {
        ObservableList<String> typelist = FXCollections.observableArrayList();
        File file = new File(PATH);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                typelist.add(f.getName());
            }
        }
        return typelist;
    }

    /**
     * 获取某一分类下的漏洞编号
     *
     * @param path 分类路径
     * @return 返回ObservableList漏洞编号列表
     */
    public static ObservableList<String> getVulnID(String path) {
        ObservableList<String> IDlist = FXCollections.observableArrayList();
        File file = new File(PATH + path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                IDlist.add(f.getName().substring(0, f.getName().indexOf(".class")));
            }
        }
        return IDlist;
    }

    public static void main(String[] args) {
//        getVulnType();
//        getVulnID("weblogic");
    }
}
