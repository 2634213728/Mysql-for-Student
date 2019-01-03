

import javax.swing.*;

/*
弹出「确认删除」对话框
弹出「专业附加班级」对话框
匹配是否附带班级
 */

public class ClickAction {

    public static void clickInsertDialog(){
        JOptionPane.showMessageDialog(null,
                "请在「专业」一栏中同时填写班级，如：网络工程一班",
                "填写错误",
                JOptionPane.ERROR_MESSAGE);
    }

    public static boolean clickDeleteOne() {
        int response = JOptionPane.showConfirmDialog(null,
                "删除此项数据？此操作无法撤销",
                "删除确认", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        switch (response) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                return false;
            case JOptionPane.CLOSED_OPTION:
                return false;
            default:
                return false;
        }
    }

    public static boolean clickDeleteAll() {
        int response = JOptionPane.showConfirmDialog(null,
                "删除所有数据？此操作无法撤销",
                "删除确认", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        switch (response) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                return false;
            case JOptionPane.CLOSED_OPTION:
                return false;
            default:
                return false;
        }
    }
}
