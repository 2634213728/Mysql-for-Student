

import javax.swing.*;

/*
������ȷ��ɾ�����Ի���
������רҵ���Ӱ༶���Ի���
ƥ���Ƿ񸽴��༶
 */

public class ClickAction {

    public static void clickInsertDialog(){
        JOptionPane.showMessageDialog(null,
                "���ڡ�רҵ��һ����ͬʱ��д�༶���磺���繤��һ��",
                "��д����",
                JOptionPane.ERROR_MESSAGE);
    }

    public static boolean clickDeleteOne() {
        int response = JOptionPane.showConfirmDialog(null,
                "ɾ���������ݣ��˲����޷�����",
                "ɾ��ȷ��", JOptionPane.YES_NO_OPTION,
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
                "ɾ���������ݣ��˲����޷�����",
                "ɾ��ȷ��", JOptionPane.YES_NO_OPTION,
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
