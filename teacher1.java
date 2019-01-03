
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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

public class teacher1 extends JFrame implements ActionListener {
	private static final java.lang.String p = null;
	// �������
	JLabel jLStudentInfoTable = null;//ѧ����Ϣ��jlabel�ñ�ǩ������ʾ���ڴ�ֱ��ˮƽ���ж��롣
	JLabel jLSelectQueryField = null;//ѡ���ѯ�ֶ�
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//ѧ��
	JLabel jLSName = null;//����
	JLabel jLSSex = null;//�Ա�
	JLabel jLSAge = null;//����
	JLabel jLSSpecialty = null;//רҵ
	JLabel jLSAddress = null;//סַ
	
	Vector v = new Vector();
	String op =null;

	JTextField jTFQueryField = null;//��ѯ�ֶ�//JTextField�ı���JTextField �����༭���е��ı�
	private JTextField jTFCha;
	JTextField jTFSNo = null;//ѧ��
	private JTextField jTFID;
	JTextField jTFSName = null;//����
	private JTextField jTFTime;
	JTextField jTFSSex = null;//�Ա�
	JTextField jTFSAge = null;//����
	JTextField jTFSSpecialty = null;//רҵ
	JTextField jTFSAddress = null;//סַ
	
	JButton jBQuery = null;//��ѯ
	private JButton jBQueryCha;
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;//vector��ʵ���˶�̬���飬����Ԫ�������仯�Ķ������顣������һ��
	Vector titleVector = null;
	Vector v1= null;
	
	//private static DbPro DbPro;
	String SelectQueryFieldStr = "ѧ��";
	String SelectQueryFieldStr1 = "����";
	String SelectQueryFieldStr2 = "תϵ";
	private JButton jBOut;
	private JPanel panel;
	private JComboBox<String> comboBoxJiang;
	private JLabel label_2;
	private JLabel jLSDescription;
	private JTextField jTFDescription;
	private JButton jBYes1;
	private JComboBox<String> comboBox_1;
	private JButton jBYes2;
	String url1="SELECT  " + 
			"student.StudentId, " + 
			"student.Name, " + 
			"student.Sex, " + 
			"class.ClassName, " + 
			"department.DeName, " + 
			"student.Birthday, " + 
			"student.NativePlace, " + 
			"changelevel.Description, " + 
			"`change`.Description, " + 
			"reward.RecTime, " + 
			"reward.ReDescription, " + 
			"rewardlevel.Descripment, " + 
			"punishment.RecTime, " + 
			"punishment.PunDescription, " + 
			"punishment.`Enable`, " + 
			"punishlevel.Description1 " + 
			" " + 
			"FROM student LEFT OUTER JOIN reward ON student.StudentId=reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId=`change`.StudentId  " + 
			"LEFT OUTER JOIN rewardlevel on reward.Levels=rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId=punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels=punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class=class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id=changelevel.`Code` " + 
			"LEFT OUTER JOIN department ON student.Department=department.`Code` GROUP BY student.StudentId;";
	String url2="SELECT  " + 
			"student.StudentId, " + 
			"student.Name, " + 
			"student.Sex, " + 
			"class.ClassName, " + 
			"department.DeName, " + 
			"student.Birthday, " + 
			"student.NativePlace, " + 
			"changelevel.Description, " + 
			"`change`.Description, " + 
			"reward.RecTime, " + 
			"reward.ReDescription, " + 
			"rewardlevel.Descripment, " + 
			"punishment.RecTime, " + 
			"punishment.PunDescription, " + 
			"punishment.`Enable`, " + 
			"punishlevel.Description1 " + 
			" " + 
			"FROM student LEFT OUTER JOIN reward ON student.StudentId=reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId=`change`.StudentId  " + 
			"LEFT OUTER JOIN rewardlevel on reward.Levels=rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId=punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels=punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class=class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id=changelevel.`Code` " + 
			"LEFT OUTER JOIN department ON student.Department=department.`Code`  where ";
	String url3="DELETE student,reward,class,`change`,punishment " + 
			"FROM student LEFT OUTER JOIN reward ON student.StudentId=reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId=`change`.StudentId  " + 
			"LEFT OUTER JOIN rewardlevel on reward.Levels=rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId=punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels=punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class=class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id=changelevel.`Code`;";
	String url4="DELETE student,reward,class,`change`,punishment " + 
			"FROM student LEFT OUTER JOIN reward ON student.StudentId=reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId=`change`.StudentId  " + 
			"LEFT OUTER JOIN rewardlevel on reward.Levels=rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId=punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels=punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class=class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id=changelevel.`Code` " + 
			"WHERE ";
	private JTextField textField;
	private JLabel label_3;
	private JTextField textField_1;
	private JLabel jLSTudent;
	private JTextField jTFStu;
	private JLabel label_4;
	private JTextField textField_2;
	//String STU;
	private String String;

	// ���캯��
	public teacher1() {
		// �������	
		jLStudentInfoTable = new JLabel("ѧ����Ϣ��");
		jLSAge = new JLabel("ѧ���������");
		jLSAge.setBounds(5, 8, 78, 15);
		jBInsert = new JButton("����");
		jBUpdate = new JButton("����");
		jBDeleteCurrentRecord = new JButton("ɾ����ǰ��¼");
		jBDeleteAllRecords = new JButton("ɾ�����м�¼");
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
	
		studentVector = new Vector();//����
		titleVector = new Vector();
		
		// �����ͷ
		/*titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("����");
		titleVector.add("רҵ");
		titleVector.add("סַ");*/
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("�༶");
		titleVector.add("Ժϵ");
		titleVector.add("����");
		titleVector.add("����");
		titleVector.add("ѧ�����");
		titleVector.add("������� ");
		titleVector.add("����ʱ��");
		titleVector.add("��������");
		titleVector.add("�����ȼ�");
		titleVector.add("����ʱ��");
		titleVector.add("��������");
		titleVector.add("�����ȼ�");
		titleVector.add("�����Ƿ�ִ��");
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);//���Ĵ���
		studentJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//��ֹ����Ӧ���ͻῪ��������
		studentJTable.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane = new JScrollPane(studentJTable);
		studentJScrollPane.setBounds(0, 0, 462, 156);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Ϊ�����Ӽ����� 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e)
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);

				v = (Vector) studentVector.get(row);
				//������������Ե����
				op=(String) v.get(0);
				jTFStu.setText((String) v.get(0));// ѧ��
				/*jTFSName.setText((String) v.get(1));// ����
				jTFSSex.setText((String) v.get(2));// �Ա�
				jTFSAge.setText(Integer.toString((int) v.get(3)));// ����
				jTFSSpecialty.setText((String) v.get(4));// רҵ
				jTFSAddress.setText((String) v.get(5));// סַ*/
			}
		});


		jP1 = new JPanel();
		jP1.setBounds(212, 5, 70, 25);
		jP2 = new JPanel();
		jP2.setBounds(16, 25, 462, 156);
		jP4 = new JPanel();
		jP4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jP4.setBounds(0, 69, 474, 69);
		jP5 = new JPanel();
		jP5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jP5.setBounds(0, 148, 474, 32);
		jP6 = new JPanel();
		jP6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jP6.setBounds(0, 203, 474, 38);
		jPTop = new JPanel();
		jPTop.setBounds(0, 0, 494, 207);
		jPBottom = new JPanel();
		jPBottom.setBounds(10, 290, 474, 251);
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
		jP2.setLayout(null);
		jP2.add(studentJScrollPane);
		jP4.setLayout(null);
		jP4.setPreferredSize(new Dimension(20,20));
		jP5.setLayout(null);
	
		jP5.add(jLSAge);
		jP5.setPreferredSize(new Dimension(20,20));
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.add(jBDeleteCurrentRecord);
		jP6.add(jBDeleteAllRecords);
		jP6.setLayout(new FlowLayout(FlowLayout.LEFT));
		jP6.setPreferredSize(new Dimension(20,20));
		jPTop.setLayout(null);
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		jPBottom.setLayout(null);
		jPBottom.add(jP4);
		
		comboBoxJiang = new JComboBox<String>();
		comboBoxJiang.setBounds(208, 5, 66, 24);
		
		comboBoxJiang.addItem("����");  
		comboBoxJiang.addItem("����");  
		//�����������
		comboBoxJiang.addItemListener(new ItemListener() {//�������¼�����  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr1 = (String) event.getItem();  
                    System.out.println("ѡ�У�" + SelectQueryFieldStr1);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
                    break;  
                }  
            }  
        });
		jP4.add(comboBoxJiang);
		
		label_2 = new JLabel("���ͷ���");
		label_2.setBounds(148, 10, 68, 15);
		jP4.add(label_2);
		
		jLSDescription = new JLabel("��������");
		jLSDescription.setBounds(5, 46, 54, 15);
		jP4.add(jLSDescription);
		
		jTFDescription = new JTextField(10);
		jTFDescription.setBounds(64, 39, 172, 24);
		jP4.add(jTFDescription);
		
		jBYes1 = new JButton("ȷ��");
		jBYes1.setBounds(389, 42, 75, 23);
		jBYes1.addActionListener(this);
		jP4.add(jBYes1);
		
		JLabel label_1 = new JLabel("���͵ȼ�");
		label_1.setBounds(5, 10, 49, 15);
		jP4.add(label_1);
		
		textField = new JTextField(10);
		textField.setBounds(64, 6, 66, 24);
		jP4.add(textField);
		
		label_3 = new JLabel("�����Ƿ�ִ��");
		label_3.setBounds(305, 10, 75, 15);
		jP4.add(label_3);
		
		textField_1 = new JTextField(10);
		textField_1.setBounds(389, 6, 66, 24);
		jP4.add(textField_1);
		jPBottom.add(jP5);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(93, 5, 64, 21);//***********************************
		comboBox_1.addItem("תϵ");  
		comboBox_1.addItem("��ѧ");  
		comboBox_1.addItem("��ѧ"); 
		comboBox_1.addItem("��ѧ"); 
		comboBox_1.addItem("��ҵ"); 
		//�����������
		comboBox_1.addItemListener(new ItemListener() {//�������¼�����  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr2= (String) event.getItem();  
                    System.out.println("ѡ�У�" + SelectQueryFieldStr2);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		jP5.add(comboBox_1);
		
		jBYes2 = new JButton("����ȷ��");
		jBYes2.setBounds(372, 4, 81, 23);
		jBYes2.addActionListener(this);
		
		jP5.add(jBYes2);
		
		label_4 = new JLabel("��������");
		label_4.setBounds(167, 8, 54, 15);
		jP5.add(label_4);
		
		textField_2 = new JTextField(10);
		textField_2.setBounds(219, 5, 132, 24);
		jP5.add(textField_2);
		jPBottom.add(jP6);
		
		jBOut = new JButton("���沢�˳�");
		jP6.add(jBOut);
		getContentPane().setLayout(null);
		
		getContentPane().add(jPTop);
		getContentPane().add(jPBottom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 474, 38);
		jPBottom.add(panel_1);
		panel_1.setLayout(null);
		jLSNo = new JLabel("��¼��");
		jLSNo.setBounds(26, 10, 36, 15);
		panel_1.add(jLSNo);
		jTFID = new JTextField(10);
		jTFID.setBounds(67, 6, 66, 24);
		panel_1.add(jTFID);
		jLSName = new JLabel("��¼ʱ��");
		jLSName.setBounds(156, 10, 54, 15);
		panel_1.add(jLSName);
		jTFTime = new JTextField(10);
		jTFTime.setBounds(220, 6, 66, 24);
		panel_1.add(jTFTime);
		jLSelectQueryField = new JLabel("ѡ���ѯ�ֶ�");
		jLSelectQueryField.setBounds(10, 9, 72, 15);
		jLEqual = new JLabel(" = ");
		jLEqual.setBounds(150, 9, 18, 15);
		
		jTFCha = new JTextField(10);//ѡ���ѯ�����
		jTFCha.setBounds(167, 5, 72, 23);
		
		jBQueryCha = new JButton("��ѯ");
		jBQueryCha.setBounds(249, 5, 57, 23);
		jBQueryAll = new JButton("��ѯ���м�¼");
		jBQueryAll.setBounds(359, 42, 105, 23);
		// ���ü���
		jBQueryCha.addActionListener(this);
		jBQueryAll.addActionListener(this);
		//
		jCBSelectQueryField = new JComboBox<String>();
		jCBSelectQueryField.setBounds(82, 6, 67, 21);
		jCBSelectQueryField.addItem("ѧ��");  
		jCBSelectQueryField.addItem("����");  
		jCBSelectQueryField.addItem("�Ա�");
		jCBSelectQueryField.addItem("�༶");
		jCBSelectQueryField.addItem("Ժϵ");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("ѧ��");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("����");
		
		//�����������
		jCBSelectQueryField.addItemListener(new ItemListener() {//�������¼�����  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();//ѡ�е�����
                    System.out.println("ѡ�У�" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		jP3 = new JPanel();
		jP3.setBorder(new EmptyBorder(0, 0, 0, 0));
		jP3.setBounds(10, 209, 474, 72);
		getContentPane().add(jP3);
		jP3.setLayout(null);
		
		jP3.add(jLSelectQueryField);
		jP3.add(jCBSelectQueryField);
		jP3.add(jLEqual);
		jP3.add(jTFCha);
		jP3.add(jBQueryCha);
		jP3.add(jBQueryAll);
		jP3.setPreferredSize(new Dimension(20,20));
		
		jLSTudent = new JLabel("��ѯ����ѧ��");
		jLSTudent.setBounds(10, 46, 90, 15);
		jP3.add(jLSTudent);
		
		jTFStu = new JTextField(10);
		jTFStu.setBounds(82, 42, 67, 23);
		jP3.add(jTFStu);
		
		panel = new JPanel();
		panel.setBounds(10, 278, 474, 32);
		getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(null);
		this.setTitle("ѧ������ϵͳ");
		this.setSize(500, 580);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ѯ")
			&& !jTFCha.getText().isEmpty()){
			System.out.println("actionPerformed(). ��ѯ");
			String sQueryField = jTFCha.getText().trim();//trim()��������ȥ���ַ������˵Ŀհ��ַ���
			queryProcess(sQueryField);
		}else if(e.getActionCommand().equals("��ѯ���м�¼")) {
			System.out.println("actionPerformed(). ��ѯ���м�¼");
			queryAllProcess();
			jTFCha.setText("");//���JTF
		}else if(e.getActionCommand().equals("����")){
			System.out.println("actionPerformed(). ����");
			select1 getcon = new  select1();
			queryAllProcess();
		}else if(e.getActionCommand().equals("ȷ��")
				&& !jTFID.getText().isEmpty()
				&& !jTFTime.getText().isEmpty()
				&& !jTFDescription.getText().isEmpty()){
			System.out.println("actionPerformed(). ����ִ��");
				RewordProcess();
				jTFID.setText("");
				jTFTime.setText("");
				jTFDescription.setText("");
				
			//queryAllProcess();
		}else if(e.getActionCommand().equals("ɾ����ǰ��¼")){
			System.out.println("actionPerformed(). ɾ����ǰ��¼");
			String sQueryField = jTFCha.getText().trim();
			deleteCurrentRecordProcess(sQueryField);
			jTFCha.setText("");
		}else if(e.getActionCommand().equals("ɾ�����м�¼")){
			System.out.println("actionPerformed(). ɾ�����м�¼");
			deleteAllRecordsProcess();
		}
		else if(e.getActionCommand().equals("��ѯ��ʷ���ͼ�¼")){
			System.out.println("actionPerformed(). ��ѯ��ʷ���ͼ�¼");
		}
		else if(e.getActionCommand().equals("����ȷ��")){
			System.out.println("actionPerformed(). ����ȷ��");
			ChangeProcess();
			
		}
		else if(e.getActionCommand().equals("����")){
			String sQueryField=null;
			if(jTFID.getText().isEmpty()) {
				sQueryField = jTFStu.getText().trim();
			}else {
				sQueryField = jTFCha.getText().trim();
			}
			System.out.println("actionPerformed(). ����");
			try{
				// ������ѯ����
				
				String url6="SELECT *from student WHERE student.StudentId = ";
				url6 =url6+ sQueryField+";";
				System.out.println("queryAllProcess(). sql = " + url6);
				DbPro DbPro=new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(url6);
				
				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				while(rs.next()){
					String op =rs.getString("StudentId");
					String op1 =rs.getString("Name");
					String op2 =rs.getString("Sex");
					String op3 =rs.getString("Class");
					String op4 =rs.getString("Department");
					String op5 =rs.getString("Birthday");
					String op6=rs.getString("NativePlace");
					/*v1.add(rs.getString("StudentId"));
					v1.add(rs.getString("Name"));
					v1.add(rs.getString("Sex"));
					v1.add(rs.getString("Class"));
					v1.add(rs.getString("Department"));
					v1.add(rs.getString("Birthday"));
					v1.add(rs.getString("NativePlace"));*/
					
					//v.add(rs.getString("sAddress"));
					select1 getcon = new  select1(op,op1,op2,op3,op4,op5,op6);
				}
				DbPro.disconnect();
			}catch(SQLException sqle){
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null,
					"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
			//select1 getcon = new  select1(v1);
			//ChangeProcess();
			
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
		teacher1 getcon = new  teacher1();
		ClickAction getcon1 = new  ClickAction();
		System.out.println("�ɹ������ʦ�������");
    }
	//*******************��ѯ����*********************
	public void queryProcess(String sQueryField)
	{
		try{
			// ������ѯ����
			String sql=url2;
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
			if(queryFieldStr.equals("srudent.StudentId")||queryFieldStr.equals("student.Birthday")) {
				sql = sql + queryFieldStr;
				sql = sql + " = " + sQueryField+" GROUP BY student.StudentId;";	
			}
			else {
				sql = sql + queryFieldStr;
				sql = sql + " = '" + sQueryField+"'GROUP BY student.StudentId;";
			}
						
			System.out.println("queryProcess(). sql = " + sql);
			DbPro DbPro=new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable���� ����ʽ
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("StudentId"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("Sex"));
				v.add(rs.getString("ClassName"));
				v.add(rs.getString("DeName"));
				v.add(rs.getString("Birthday"));
				v.add(rs.getString("NativePlace"));
				v.add(rs.getString("Description"));
				v.add(rs.getString("Description"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("ReDescription"));
				v.add(rs.getString("Descripment"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("PunDescription"));
				v.add(rs.getString("Description1"));
				v.add(rs.getString("Enable"));
				studentVector.add(v);
			}
			studentJTable.updateUI();

			DbPro.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	//***************ȫ�����*******************
	public void queryAllProcess()
	{
		try{
			// ������ѯ����
			String sql = url1;
			System.out.println("queryAllProcess(). sql = " + sql);
			DbPro DbPro=new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("StudentId"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("Sex"));
				v.add(rs.getString("ClassName"));
				v.add(rs.getString("DeName"));
				v.add(rs.getString("Birthday"));
				v.add(rs.getString("NativePlace"));
				v.add(rs.getString("Description"));
				v.add(rs.getString("Description"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("ReDescription"));
				v.add(rs.getString("Descripment"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("PunDescription"));
				v.add(rs.getString("Description1"));
				v.add(rs.getString("Enable"));
				studentVector.add(v);
			}
			
			studentJTable.updateUI();

			DbPro.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	//***********��������*************
	public void RewordProcess()
	{
		String sql=null;
		String queryFieldStr1 = jCBSelectQueryFieldTransfer(SelectQueryFieldStr1);
		if(queryFieldStr1.equals("reward.Descripment")) {//����
			String Id = jTFID.getText().trim();
			String StudentId = jTFStu.getText().trim();
			String Levels = textField.getText().trim();
			String RecTime= jTFTime.getText().trim();
			String ReDescription = jTFDescription.getText().trim();
			//String url6="INSERT INTO reward VALUES('1','1802','1','2018','dianjing');";
			
			sql = "insert into reward values('";
			sql = sql + Id + "','";
			sql = sql + StudentId + "','";
			sql = sql + Levels+ "','";
			sql = sql + RecTime + "','";
			sql = sql + ReDescription + "');";
		}
		else{//����
			String Id = jTFID.getText().trim();
			String StudentId = jTFStu.getText().trim();
			String RecTime= jTFTime.getText().trim();
			String Levels = textField.getText().trim();
			String Enable = textField_1.getText().trim();
			String ReDescription = jTFDescription.getText().trim();
			//String url6="INSERT INTO punishment VALUES('1','1802','1','2018','yes','dianjing');";
			
			sql = "insert into punishment values('";
			sql = sql + Id + "','";
			sql = sql + StudentId + "','";
			sql = sql + Levels+ "','";
			sql = sql + RecTime + "','";
			sql = sql + Enable + "','";
			sql = sql + ReDescription + "');";
		}

		System.out.println("insertProcess(). sql = " + sql);
		DbPro DbPro=new DbPro();
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
			}else{
                System.out.println("����ʧ��");
                JOptionPane.showMessageDialog(null,
                        "�����¼���Ƿ�Ψһ��", "����ʧ��", JOptionPane.ERROR_MESSAGE);
            }
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		//queryAllProcess();
	}
	//**********************liudongcaozuo
	public void ChangeProcess()
	{
			String sql=null;
			String queryFieldStr1 = jCBSelectQueryFieldTransfer(SelectQueryFieldStr2);
			String Id = jTFID.getText().trim();
			String StudentId = jTFStu.getText().trim();
			
			String Levels = jCBSelectQueryFieldTransfer(SelectQueryFieldStr2);
			
			String RecTime= jTFTime.getText().trim();
			String Description = textField_2.getText().trim();
			//String url6="insert into `change` values('1','1804','1','2018','haowang ');";
			
			
			sql = "insert into `change` values('";
			sql = sql + Id + "','";
			sql = sql + StudentId + "','";
			sql = sql + Levels+ "','";
			sql = sql + RecTime + "','";
			sql = sql + Description + "');";
			
			System.out.println("insertProcess(). sql = " + sql);
			DbPro DbPro=new DbPro();
			try{
				if (DbPro.executeUpdate(sql) < 1) {
					System.out.println("insertProcess(). insert database failed.");
				}
			}catch(Exception e){
				System.out.println("e = " + e);
				JOptionPane.showMessageDialog(null,
					"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
	}
//***********�ӱ�ǩ�����޸�����***********
	/*public void updateProcess()
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
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}*/
//**************ɾ����ǰ����
	public void deleteCurrentRecordProcess(String sQueryField1)
	{
		String sQueryField=null;
		if(jTFID.getText().isEmpty()) {
			sQueryField = jTFStu.getText().trim();
		}else {
			sQueryField = jTFCha.getText().trim();
		}
		
		String sNo = sQueryField;
		String sql=url4;
		String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		
		if(queryFieldStr.equals("student.StudentId")||queryFieldStr.equals("student.Birthday")) {
			sql = sql + queryFieldStr;
			sql = sql + " = " + sNo+";";
			
		}
		else {
			sql = sql + queryFieldStr;
			sql = sql + " = '" + sNo+"';";
		}
		// ����ɾ������
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		DbPro DbPro=new DbPro();
		if(ClickAction.clickDeleteOne()) {
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	}

	public void deleteAllRecordsProcess()
	{
		// ����ɾ������
		String sql1 = url3;
		System.out.println("deleteAllRecordsProcess(). sql1 = " + sql1);
		DbPro DbPro=new DbPro();
		if(ClickAction.clickDeleteAll()){
		try{
			if (DbPro.executeUpdate(sql1) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	//���ݿ���Ĵ���
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("ѧ��")){
			outputStr = "student.StudentId";
		}else if(InputStr.equals("����")){
			outputStr = "student.`Name`";
		}else if(InputStr.equals("�Ա�")){
			outputStr = "student.Sex";
		}else if(InputStr.equals("�༶")){
			outputStr = "class.ClassName";
		}else if(InputStr.equals("Ժϵ")){
			outputStr = "department.DeName";
		}else if(InputStr.equals("����")){
			outputStr = "student.Birthday";
		}else if(InputStr.equals("����")){
			outputStr = "student.NativePlace";
		}else if(InputStr.equals("����")){
			outputStr = "reward.Descripment";//�����������
		}else if(InputStr.equals("����")){
			outputStr = "Punishment.Description1";
		}
		else if(InputStr.equals("תϵ")){
			outputStr = "0";
		}
		else if(InputStr.equals("��ѧ")){
			outputStr = "1";
		}
		else if(InputStr.equals("��ѧ")){
			outputStr = "2";
		}
		else if(InputStr.equals("��ѧ")){
			outputStr = "3";
		}
		else if(InputStr.equals("��ҵ")){
			outputStr = "4";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
