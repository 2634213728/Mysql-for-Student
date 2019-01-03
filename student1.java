
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
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
																								
public class student1 extends JFrame implements ActionListener {
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

	JTextField jTFQueryField = null;//��ѯ�ֶ�//JTextField�ı���JTextField �����༭���е��ı�
	JTextField jTFSNo = null;//ѧ��
	JTextField jTFSName = null;//����
	private JTextField jTFTime;
	JTextField jTFSSex = null;//�Ա�
	JTextField jTFSAge = null;//����
	JTextField jTFSSpecialty = null;//רҵ
	JTextField jTFSAddress = null;//סַ
	
	JButton jBQuery = null;//��ѯ
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP1, jP2,jP3,jP4,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	private JScrollPane studentJScrollPane_2;
	private JScrollPane studentJScrollPane_1;
	private JScrollPane scrollPane;
	JTable studentJTable1 = null;
	JTable studentJTable2 = null;
	JScrollPane studentJScrollPane1 = null;
	Vector studentVector = null;//vector��ʵ���˶�̬���飬����Ԫ�������仯�Ķ������顣������һ��
	Vector titleVector = null;
	Vector studentVector1 = null;
	Vector studentVector2 = null;
	//vector��ʵ���˶�̬���飬����Ԫ�������仯�Ķ������顣������һ��
	Vector titleVector1 = null;
	Vector studentVector21 = null;
	Vector titleVector2 = null;
	Vector titleVector3 = null;
	
	private static DbPro DbPro;
	String SelectQueryFieldStr = "ѧ��";
	private JButton jBOut;
	String url1="SELECT " + 
			"student.StudentId, " + 
			"student.NAME, " + 
			"student.Sex, " + 
			"class.ClassName, " + 
			"department.DeName, " + 
			"student.Birthday, " + 
			"student.NativePlace, " + 
			"changelevel.Description, " + 
			"rewardlevel.Descripment, " + 
			"punishlevel.Description  " + 
			"FROM " + 
			"student " + 
			"LEFT OUTER JOIN reward ON student.StudentId = reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId = `change`.StudentId " + 
			"LEFT OUTER JOIN rewardlevel ON reward.Levels = rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId = punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels = punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class = class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id = changelevel.`Code` " + 
			"LEFT OUTER JOIN department ON student.Department = department.`Code`;";
	
	  String url2= "SELECT " + 
			"student.StudentId, " + 
			"student.NAME, " + 
			"student.Sex, " + 
			"class.ClassName, " + 
			"department.DeName, " + 
			"student.Birthday, " + 
			"student.NativePlace, " + 
			"changelevel.Description, " + 
			"rewardlevel.Descripment, " + 
			"punishlevel.Description1  " + 
			"FROM " + 
			"student " + 
			"LEFT OUTER JOIN reward ON student.StudentId = reward.StudentId " + 
			"LEFT OUTER JOIN `change` ON student.StudentId = `change`.StudentId " + 
			"LEFT OUTER JOIN rewardlevel ON reward.Levels = rewardlevel.ReCode " + 
			"LEFT OUTER JOIN punishment ON student.StudentId = punishment.StudentId " + 
			"LEFT OUTER JOIN punishlevel ON punishment.Levels = punishlevel.PuCode " + 
			"LEFT OUTER JOIN class ON student.Class = class.Id " + 
			"LEFT OUTER JOIN changelevel ON `change`.Id = changelevel.`Code` " + 
			"LEFT OUTER JOIN department ON student.Department = department.`Code` where student.StudentId =";
	private JButton button_1;
	private JButton button_2;
	String Stu1="1801";
	private JTable table;

	// ���캯��
	public student1(String Stu) {
		// �������	
		Stu1=Stu;
		jLStudentInfoTable = new JLabel("ѧ����Ϣ��");
	
		studentVector = new Vector();//����
		titleVector = new Vector();
		
		// �����ͷ
		
		studentVector1 = new Vector();//����
		studentVector2 = new Vector();//����
		studentVector21 = new Vector();//����
		titleVector1 = new Vector();
		titleVector2 = new Vector();
		titleVector3 = new Vector();
		// �����ͷ
		titleVector2.add("��¼��");
		titleVector2.add("ʱ��");
		titleVector2.add("�����ȼ�");
		titleVector2.add("��������");
	
		
		titleVector=titleVector2;//Ĭ��������н�����¼
		
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable2 = new JTable(studentVector2, titleVector);//���Ĵ���
		studentJTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//��ֹ����Ӧ���ͻῪ��������
		studentJTable2.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane_2 = new JScrollPane(studentJTable2);
		studentJScrollPane_2.setBounds(10, 10, 216, 127);
		//studentJScrollPane.setBounds(0, 0, 462, 83);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane_2.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane_2.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Ϊ�����Ӽ����� 
		studentJScrollPane_2.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//������������Ե����
				//textField.setText((String) v.get(0));// ѧ��
				/*jTFSName.setText((String) v.get(1));// ����
				jTFSSex.setText((String) v.get(2));// �Ա�
				jTFSAge.setText(Integer.toString((int) v.get(3)));// ����
				jTFSSpecialty.setText((String) v.get(4));// רҵ
				jTFSAddress.setText((String) v.get(5));// סַ*/
			}
		});
		//***************************
		
		jP1 = new JPanel();
		jP1.setBounds(212, 5, 70, 25);
		jP2 = new JPanel();
		jP2.setBounds(20, 40, 462, 83);
		jPTop = new JPanel();
		jPTop.setBounds(0, 0, 494, 142);
		jPBottom = new JPanel();
		jPBottom.setBounds(10, 188, 474, 224);
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
		jP2.setLayout(null);
		jPTop.setLayout(null);
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		titleVector1.add("ѧ��");
		titleVector1.add("����");
		titleVector1.add("�Ա�");
		titleVector1.add("�༶");
		titleVector1.add("Ժϵ");
		titleVector1.add("����");
		titleVector1.add("����");
		titleVector1.add("ѧ��");
		titleVector1.add("�����ȼ�");
		titleVector1.add("�����ȼ�");
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable1 = new JTable(studentVector1, titleVector1);//���Ĵ���
		studentJTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//��ֹ����Ӧ���ͻῪ��������
		studentJTable1.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane_1 = new JScrollPane(studentJTable1);
		studentJScrollPane_1.setBounds(0, 0, 462, 83);
		jP2.add(studentJScrollPane_1);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane_1.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane_1.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jPBottom.setLayout(null);
		
		studentJTable1.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//������������Ե����
				//textField.setText((String) v.get(0));// ѧ��
				/*jTFSName.setText((String) v.get(1));// ����
				jTFSSex.setText((String) v.get(2));// �Ա�
				jTFSAge.setText(Integer.toString((int) v.get(3)));// ����
				jTFSSpecialty.setText((String) v.get(4));// רҵ
				jTFSAddress.setText((String) v.get(5));// סַ*/
			}
		});
		getContentPane().setLayout(null);
		
		getContentPane().add(jPTop);
		getContentPane().add(jPBottom);
		jP4 = new JPanel();
		jP4.setBounds(0, 162, 474, 38);
		jPBottom.add(jP4);
		jP4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jP4.setLayout(null);
		jP4.setPreferredSize(new Dimension(20,20));
		
		JButton button = new JButton("��ʷ�������ѯ");
		button.addActionListener(this);
		button.setBounds(22, 10, 138, 23);
		jP4.add(button);
		
		button_1 = new JButton("��ʷ���������ѯ");
		button_1.setBounds(312, 10, 138, 23);
		button_1.addActionListener(this);
		jP4.add(button_1);
		
		jBOut = new JButton("���沢�˳�");
		jBOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DengLu frame1 = new DengLu();
				frame1.setVisible(true);
				setVisible(false);
			}
		});
		jBOut.setBounds(182, 10, 102, 23);
		jBOut.addActionListener(this);
		jP4.add(jBOut);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 454, 137);
		panel.setLayout(null);
		panel.add(studentJScrollPane_2);
		//jiaru
		jPBottom.add(panel);
		
		titleVector3.add("��¼��");
		titleVector3.add("ʱ��");
		titleVector3.add("�����ȼ�");
		titleVector3.add("��������");
		titleVector3.add("����ִ��");
		//studentVector2
		
		table = new JTable(studentVector21,titleVector3);//���Ĵ���
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//��ֹ����Ӧ���ͻῪ��������
		table.setPreferredScrollableViewportSize(new Dimension(455,150));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(228, 10, 216, 127);
		//studentJScrollPane.setBounds(0, 0, 462, 83);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		scrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Ϊ�����Ӽ����� 
		scrollPane.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//������������Ե����
				//textField.setText((String) v.get(0));// ѧ��
				/*jTFSName.setText((String) v.get(1));// ����
				jTFSSex.setText((String) v.get(2));// �Ա�
				jTFSAge.setText(Integer.toString((int) v.get(3)));// ����
				jTFSSpecialty.setText((String) v.get(4));// רҵ
				jTFSAddress.setText((String) v.get(5));// סַ*/
			}
		});
		panel.add(scrollPane);
		
		//
		
		jBQueryAll = new JButton("��������");
		jBQueryAll.setBounds(383, 5, 81, 23);
		//jBQueryAll.addActionListener(this);
		jBQueryAll.addActionListener(this);
		
		jP3 = new JPanel();
		jP3.setBounds(10, 152, 474, 32);
		jP3.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(jP3);
		jP3.setLayout(null);
		jP3.add(jBQueryAll);
		jP3.setPreferredSize(new Dimension(20,20));
		jTFTime = new JTextField(10);
		jTFTime.setBounds(322, 113, 66, 24);
		jP3.add(jTFTime);
		
		button_2 = new JButton("������Ϣ�޸�");
		button_2.setBounds(249, 5, 105, 23);
		button_2.addActionListener(this);
		jP3.add(button_2);
		
		JButton btnNewButton = new JButton("��ʼʹ��");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(64, 5, 105, 23);
		jP3.add(btnNewButton);
		this.setTitle("ѧ������ϵͳ");
		this.setSize(500, 451);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		DbPro = new DbPro();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ʼʹ��")){
			System.out.println("��ʼʹ��");
			try{
				// ������ѯ����
				String sql=url2;
					sql = sql  + Stu1+";";
				System.out.println("queryProcess(). sql = " + sql);
				DbPro DbPro =new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(sql);
				// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				studentVector1.clear();
				while(rs.next()){//����������б���������Ϣ
					Vector v = new Vector();
					v.add(rs.getString("StudentId"));
					v.add(rs.getString("Name"));
					v.add(rs.getString("Sex"));
					v.add(rs.getString("ClassName"));
					v.add(rs.getString("DeName"));
					v.add(rs.getString("Birthday"));
					v.add(rs.getString("NativePlace"));
					v.add(rs.getString("Description"));
					v.add(rs.getString("Descripment"));
					v.add(rs.getString("Description1"));
					v.add("asdsada");
					System.out.println(rs.getString("StudentId"));
				studentVector1.add(v);
			}
				studentJTable1.updateUI();
				DbPro.disconnect();
			}catch(SQLException sqle){
				System.out.println("sqle = " + sqle);
				JOptionPane.showMessageDialog(null,
					"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getActionCommand().equals("��ʷ�������ѯ")) {
			System.out.println("actionPerformed(). ��ʷ�������ѯ");
			Reward();
			
		}else if(e.getActionCommand().equals("��ʷ���������ѯ")) {
			System.out.println("actionPerformed(). ��ʷ���������ѯ");
			Punlishment();
				
		}else if(e.getActionCommand().equals("��������")){
				
			System.out.println("actionPerformed().��������");
			String op=Stu1;
			String op1="����";
			String op2="��|Ů";
			String op3="1-6";
			String op4="11-14";
			String op5="2018-9-20";
			String op6="����-��ɳ";
			select1 Select=new select1(op,op1, op2,op3, op4, op5,op6);
			
		}else if(e.getActionCommand().equals("������Ϣ�޸�")){
			System.out.println("actionPerformed(). ������Ϣ�޸�");
			Vector v1=null;
			try{
				// ������ѯ����
				
				String url6="SELECT *from student WHERE student.StudentId = ";
				url6 =url6+ Stu1+";";
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
		String Stu ="1801";
		student1 getcon = new  student1(Stu);

		System.out.println("�ɹ�����ѧ���������");
    }
	public void Reward(){
		//SELECT * FROM reward  left outer join rewardlevel ON reward.Levels=rewardlevel.ReCode WHERE reward.StudentId=1801 ORDER BY  RecTime DESC;
		String url2 ="SELECT * FROM reward  left outer join rewardlevel ON reward.Levels=rewardlevel.ReCode WHERE reward.StudentId= ";
		try{
			// ������ѯ����
			String sql=url2;
				sql = sql  + Stu1+" ORDER BY  RecTime DESC ;";
			System.out.println("queryProcess(). sql = " + sql);
			DbPro DbPro =new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector2.clear();
			while(rs.next()){//����������б���������Ϣ
				Vector v = new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("Descripment"));
				v.add(rs.getString("ReDescription"));
				System.out.println(rs.getString("Id"));
			studentVector2.add(v);
		}
			studentJTable2.updateUI();
			DbPro.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	//*******************��ѯ����*********************
	
	public void Punlishment(){
		//SELECT * FROM punishment  left outer join punishlevel ON punishment.Levels=punishlevel.PuCode WHERE  punishment.StudentId =1801 ORDER BY  RecTime DESC;
		String url2 ="SELECT * FROM punishment  left outer join punishlevel ON punishment.Levels=punishlevel.PuCode WHERE  punishment.StudentId = ";
		try{
			// ������ѯ����
			String sql=url2;
				sql = sql  + Stu1+" ORDER BY  RecTime DESC;";
			System.out.println("queryProcess(). sql = " + sql);
			DbPro DbPro =new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			studentVector21.clear();
			while(rs.next()){//����������б���������Ϣ
				Vector v = new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("RecTime"));
				v.add(rs.getString("Description1"));
				v.add(rs.getString("PunDescription"));
				v.add(rs.getString("Enable"));
				System.out.println(rs.getString("Id"));
				studentVector21.add(v);
		}
			DbPro.disconnect();
			table.updateUI();
			
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	//***********��������*************
	/*public void insertProcess()
	{
		String sNo = jTFSNo.getText().trim();
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sAge = jTFSAge.getText().trim();
		String sSpecialty = jTFSSpecialty.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		// ������������
		String sql = "insert into student values('";
		sql = sql + sNo + "','";
		sql = sql + sName + "','";
		sql = sql + sSex + "',";
		sql = sql + sAge + ",'";
		sql = sql + sSpecialty + "','";
		sql = sql + sAddress + "');";

		System.out.println("insertProcess(). sql = " + sql);
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
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
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
//**************ɾ����ǰ����
	public void deleteCurrentRecordProcess()
	{
		String sNo = jTFSNo.getText().trim();
		
		// ����ɾ������
		String sql = "delete from student where sNo = '" + sNo + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// ����ɾ������
		String sql = "delete from student;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}*/
	//���ݿ���Ĵ���
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("ѧ��")){
			outputStr = "student.StudentId";
		}else if(InputStr.equals("����")){
			outputStr = "student.Name";
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
			outputStr = "Punishment.Description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
