package org.chabug;

import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class Test extends Application {
    public static void main(String[] args) {
        String str="";
        String[] s={"","",""};
        Method[] methods1 = String.class.getMethods();

        Method[] methods = Test.class.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
