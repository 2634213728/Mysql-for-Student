
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import java.awt.Font;

public class select1 extends JFrame implements ActionListener {
	// �������
	JLabel jLStudentInfoTable = null;//ѧ����Ϣ��jlabel�ñ�ǩ������ʾ���ڴ�ֱ��ˮƽ���ж��롣
	JLabel jLSelectQueryField = null;//ѡ���ѯ�ֶ�
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//ѧ��
	JLabel jLSClass = null;//ѧ��
	JLabel jLSName = null;//����
	JLabel jLSSex = null;//�Ա�
	JLabel jLSAge = null;//����
	JLabel jLSSpecialty = null;//רҵ
	JLabel jLSAddress = null;//סַ

	JTextField jTFQueryField = null;//��ѯ�ֶ�//JTextField�ı���JTextField �����༭���е��ı�
	JTextField jTFSNo = null;//ѧ��
	JTextField jTFSName = null;//����
	JTextField jTFSSex = null;//�Ա�
	JTextField jTFSAge = null;//����A
	JTextField jTFSSpecialty = null;//רҵ
	JTextField jTFSAddress = null;//סַ
	JTextField jTFClass = null;//סַ
	
	//private static DbPro DbPro;
	
	JButton jBQuery = null;//��ѯ
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;//vector��ʵ���˶�̬���飬����Ԫ�������仯�Ķ������顣������һ��
	Vector titleVector = null;
	
	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "ѧ��";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	String op="1801";

	// ���캯��
	public select1(String op,String op1,String op2,String op3,String op4,String op5,String op6) {
		System.out.println(op);
		jLSNo = new JLabel("ѧ��");
		jLSNo.setBounds(5, 8, 24, 15);
		jLSName = new JLabel("����");
		jLSName.setBounds(105, 8, 24, 15);
		jLSSex = new JLabel("�Ա�");
		jLSSex.setBounds(219, 8, 24, 15);
		jLSAge = new JLabel("Ժϵ����");
		jLSAge.setBounds(80, 8, 55, 15);
		jLSSpecialty = new JLabel("����");
		jLSSpecialty.setBounds(220, 8, 33, 15);
		jLSAddress = new JLabel("סַ");
		jLSAddress.setBounds(349, 8, 24, 15);
		jLSClass = new JLabel("�༶����");
		jLSClass.setBounds(329, 8, 53, 15);
		jTFSNo = new JTextField(10);//ѧ��
		
		//jTFSNo.setText((String)op);
		jTFSNo.setBounds(34, 5, 66, 26);
		jTFSName = new JTextField(10);//����
		jTFSName.setBounds(134, 5, 66, 26);
		jTFSSex = new JTextField(10);//�Ա�
		jTFSSex.setBounds(253, 5, 66, 26);
		jTFSAge = new JTextField(10);//����
		jTFSAge.setBounds(133, 5, 66, 26);
		jTFSSpecialty = new JTextField(10);//רҵ
		jTFSSpecialty.setBounds(252, 5, 66, 26);
		jTFSAddress = new JTextField(10);//סַ
		jTFSAddress.setBounds(383, 5, 66, 26);
		jBInsert = new JButton("�������˳�");
		jBInsert.setBounds(49, 5, 109, 23);
		jBUpdate = new JButton("���²��˳�");
		jBUpdate.setBounds(325, 5, 109, 23);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		//***************************************************************8
		
		
		
		studentVector = new Vector();//����
		titleVector = new Vector();
		
		// �����ͷ
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("����");
		titleVector.add("רҵ");
		titleVector.add("סַ");
		jP4 = new JPanel();
		jP5 = new JPanel();
		jP6 = new JPanel();
		jPTop = new JPanel();
		jPTop.setBounds(0, 0, 494, 207);
		jPBottom = new JPanel();
		jPBottom.setBounds(0, 214, 494, 235);
		jP4.setLayout(null);
		
		jP4.add(jLSNo);
		jP4.add(jLSClass);
		jP4.add(jTFSNo);
		jP4.add(jLSName);
		jP4.add(jTFSName);
		jP4.add(jLSSex);
		jP4.add(jTFSSex);
		jP4.setPreferredSize(new Dimension(20,20));
		jP5.setLayout(null);
	
		jP5.add(jLSAge);
		jP5.add(jTFSAge);
		jP5.add(jLSSpecialty);
		jP5.add(jTFSSpecialty);
		jP5.add(jLSAddress);
		jP5.add(jTFSAddress);
		
		jP5.setPreferredSize(new Dimension(20,20));
		jP6.setLayout(null);
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.setPreferredSize(new Dimension(20,20));
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP4);
		
		jTFClass = new JTextField(10);
		jTFClass.setBounds(386, 5, 66, 26);
		jP4.add(jTFClass);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		getContentPane().setLayout(null);
		getContentPane().add(jPTop);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(68, 30, 84, 140);
		StringBuffer sb = null;
		  sb = new StringBuffer("<html>Ժϵ���ձ�<br/><br/>���___Ժ��"
                                          + "<br/> _11__һԺ<br/> _12__��Ժ<br/> _13__��Ժ<br/> _14__��Ժ</html>");
		 jPTop.setLayout(null);
		 lblNewLabel.setText(sb.toString());
		jPTop.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(176, 39, 86, 155);
		StringBuffer sb1 = null;
		 sb1 = new StringBuffer("<html>�༶���ձ�<br/><br/>���___���"
                 + "<br/> _1___һ��<br/> _2___����<br/> _3___����<br/> _4___�İ�</htm<br/> _5___���<br/> _6___����<html>");
		 lblNewLabel_1.setText(sb1.toString());
		jPTop.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ע������");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(211, 0, 110, 32);
		jPTop.add(lblNewLabel_2);
		getContentPane().add(jPBottom);
		this.setTitle("ѧ������ϵͳ");
		this.setSize(500, 430);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
		jTFSNo.setText((String) op);//
		jTFSName.setText((String) op1);//����
		jTFSSex.setText((String) op2);//�Ա�
		jTFClass.setText(op3);//�༶
		jTFSAge.setText((String) op4);//Ժ
		jTFSSpecialty.setText((String) op5);//����
		jTFSAddress.setText((String) op6);//����*/
	}
	//hanshu
	public select1() {
		jLSNo = new JLabel("ѧ��");
		jLSNo.setBounds(5, 8, 24, 15);
		jLSName = new JLabel("����");
		jLSName.setBounds(105, 8, 24, 15);
		jLSSex = new JLabel("�Ա�");
		jLSSex.setBounds(219, 8, 24, 15);
		jLSAge = new JLabel("Ժϵ����");
		jLSAge.setBounds(80, 8, 55, 15);
		jLSSpecialty = new JLabel("����");
		jLSSpecialty.setBounds(220, 8, 33, 15);
		jLSAddress = new JLabel("סַ");
		jLSAddress.setBounds(349, 8, 24, 15);
		jLSClass = new JLabel("�༶����");
		jLSClass.setBounds(329, 8, 53, 15);
		jTFSNo = new JTextField(10);//ѧ��
		jTFSNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("�����");
				jTFSNo.setText((String)op);
			}
		});
		//String op ="jhi";************************************
		jTFSNo.setText((String)op);
		jTFSNo.addActionListener(this);
		jTFSNo.setBounds(34, 5, 66, 26);
		jTFSName = new JTextField(10);//����
		jTFSName.setBounds(134, 5, 66, 26);
		jTFSSex = new JTextField(10);//�Ա�
		jTFSSex.setBounds(253, 5, 66, 26);
		jTFSAge = new JTextField(10);//����
		jTFSAge.setBounds(133, 5, 66, 26);
		jTFSSpecialty = new JTextField(10);//רҵ
		jTFSSpecialty.setBounds(252, 5, 66, 26);
		jTFSAddress = new JTextField(10);//סַ
		jTFSAddress.setBounds(383, 5, 66, 26);
		jBInsert = new JButton("�������˳�");
		jBInsert.setBounds(49, 5, 109, 23);
		jBUpdate = new JButton("���²��˳�");
		jBUpdate.setBounds(325, 5, 109, 23);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
	
		studentVector = new Vector();//����
		titleVector = new Vector();
		
		// �����ͷ
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("����");
		titleVector.add("רҵ");
		titleVector.add("סַ");
		jP4 = new JPanel();
		jP5 = new JPanel();
		jP6 = new JPanel();
		jPTop = new JPanel();
		jPTop.setBounds(0, 0, 494, 207);
		jPBottom = new JPanel();
		jPBottom.setBounds(0, 214, 494, 235);
		jP4.setLayout(null);
		
		jP4.add(jLSNo);
		jP4.add(jLSClass);
		jP4.add(jTFSNo);
		jP4.add(jLSName);
		jP4.add(jTFSName);
		jP4.add(jLSSex);
		jP4.add(jTFSSex);
		jP4.setPreferredSize(new Dimension(20,20));
		jP5.setLayout(null);
	
		jP5.add(jLSAge);
		jP5.add(jTFSAge);
		jP5.add(jLSSpecialty);
		jP5.add(jTFSSpecialty);
		jP5.add(jLSAddress);
		jP5.add(jTFSAddress);
		
		jP5.setPreferredSize(new Dimension(20,20));
		jP6.setLayout(null);
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.setPreferredSize(new Dimension(20,20));
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP4);
		
		jTFClass = new JTextField(10);
		jTFClass.setBounds(386, 5, 66, 26);
		jP4.add(jTFClass);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		getContentPane().setLayout(null);
		getContentPane().add(jPTop);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(89, 31, 122, 155);
		StringBuffer sb = null;
		  sb = new StringBuffer("<html>Ժϵ���ձ�<br/><br/>���___Ժ��"
                                          + "<br/> _11__�����ѧԺ<br/> _12__��ľѧԺ<br/> _13__��ѧԺ<br/> _14__����ѧԺ<br/> _14__����ѧԺ</html>");
		 jPTop.setLayout(null);
		 lblNewLabel.setText(sb.toString());
		jPTop.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(237, 39, 86, 155);
		StringBuffer sb1 = null;
		 sb1 = new StringBuffer("<html>�༶���ձ�<br/><br/>���___���"
                 + "<br/> _1___һ��<br/> _2___����<br/> _3___����<br/> _4___�İ�</htm<br/> _5___���<br/> _6___����<html>");
		 lblNewLabel_1.setText(sb1.toString());
		jPTop.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ע������");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(211, 0, 110, 32);
		jPTop.add(lblNewLabel_2);
		getContentPane().add(jPBottom);
		this.setTitle("ѧ������ϵͳ");
		this.setSize(500, 430);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("���²��˳�")
				&& !jTFSNo.getText().isEmpty()
				&& !jTFSName.getText().isEmpty()
				&& !jTFSSex.getText().isEmpty()
				&& !jTFClass.getText().isEmpty()
				&& !jTFSAge.getText().isEmpty()
				&& !jTFSSpecialty.getText().isEmpty()
				&& !jTFSAddress.getText().isEmpty()){
			insertProcess();
			System.out.println("�������");
			
		}else if(e.getActionCommand().equals("�������˳�")){
			System.out.println("actionPerformed(). �������˳�");
			setVisible(false);//��¼��������
			//deleteAllRecordsProcess();
		}
	}
	
	public static void main(String[] args) {
		
		try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //InitGlobalFont.InitGlobalFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		select1 getcon = new  select1();
		//*****************
		
        
    }
	
	//***********��������*************
	public void insertProcess()
	{	
		
		String StudentId = jTFSNo.getText().trim();
		String Name = jTFSName.getText().trim();
		String Sex = jTFSSex.getText().trim();
		String Class = jTFClass.getText().trim();
		String Department = jTFSAge.getText().trim();
		String Birthday = jTFSSpecialty.getText().trim();
		String NativePlace = jTFSAddress.getText().trim();
		
		// ������������
		String sql = "insert into student values('";
		sql = sql + StudentId + "','";
		sql = sql + Name + "','";
		sql = sql + Sex + "','";
		sql = sql + Class + "','";
		sql = sql + Department + "','";
		sql = sql + Birthday + "','";
		sql = sql + NativePlace + "');";
		
		System.out.println("insertProcess(). sql = " + sql);
		DbPro DbPro=new DbPro();
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
				//JOptionPane.showMessageDialog(null, "�����ɹ�");
			}
			JOptionPane.showMessageDialog(null,
                    "�����ɹ���");
			setVisible(false);//��¼��������
			
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
//***********�ӱ�ǩ�����޸�����***********
	public void updateProcess()
	{
		String sNo = jTFSNo.getText().trim();//�ӱ�ǩ������
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sAge = jTFSAge.getText().trim();
		String sSpecialty = jTFSSpecialty.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		// ������������
		String sql = "update student set sName = '";
		sql = sql + sName + "', sSex = '";
		sql = sql + sSex + "', sAge = ";
		sql = sql + sAge + ", sSpecialty = '";
		sql = sql + sSpecialty + "', sAddress = '";
		sql = sql + sAddress + "'";
		sql = sql + " WHERE sNo = '" + sNo + "';";
		System.out.println("updateProcess(). sql = " + sql);
		try{
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		
		//queryAllProcess();
	}

	//���ݿ���Ĵ���
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("ѧ��")){
			outputStr = "sNo";
		}else if(InputStr.equals("����")){
			outputStr = "sName";
		}else if(InputStr.equals("�Ա�")){
			outputStr = "sSex";
		}else if(InputStr.equals("����")){
			outputStr = "sAge";
		}else if(InputStr.equals("רҵ")){
			outputStr = "sSpecialty";
		}else if(InputStr.equals("סַ")){
			outputStr = "sAddress";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
