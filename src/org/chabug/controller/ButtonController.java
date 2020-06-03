package org.chabug.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.chabug.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ButtonController {
    public TextArea textArea;   //输出结果
    public TextField urlInput;  //url输入框
    FXMLLoader loader;
    Pane root;

    public ButtonController() {
    }

    /**
     * 检测按钮事件
     *
     * @param event
     */
    public void ButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        ChoiceBox vulID = (ChoiceBox) button.getParent().lookup("#vulId");
        ChoiceBox vulType = (ChoiceBox) button.getParent().lookup("#vulType");

        System.out.println("点击Button");
        HashMap<Object, Object> ObjMap = new HashMap<>();
        String url = urlInput.getText().toLowerCase().toString();

        if (url.isEmpty()) {
            textArea.setText("URL不能为空！");
            return;
        }

        ObjMap.put("url", url);
        try {
            String expClass = "org.chabug.exploit." + vulType.getValue().toString() + "." + vulID.getValue().toString();
            Class<?> aClass = Class.forName(expClass);
            Object obj = aClass.newInstance();
            Method exp = obj.getClass().getMethod("exp", HashMap.class);
            String res = (String) exp.invoke(obj, ObjMap);
            res = "检测结果:\n" + res;
            textArea.setText(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * vulType选择框onchange事件
     *
     * @param dragEvent
     */
    public void ChoiceDone(ActionEvent dragEvent) {
        ChoiceBox vulType = (ChoiceBox) dragEvent.getSource();
        ChoiceBox vulID = (ChoiceBox) vulType.getParent().lookup("#vulId");
        vulID.setItems(ClassUtil.getVulnID(vulType.getValue().toString()));
        vulID.getSelectionModel().selectFirst();
    }
}
