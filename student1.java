
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
	// 定义组件
	JLabel jLStudentInfoTable = null;//学生信息表；jlabel该标签在其显示区内垂直和水平居中对齐。
	JLabel jLSelectQueryField = null;//选择查询字段
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//学号
	JLabel jLSName = null;//姓名
	JLabel jLSSex = null;//性别
	JLabel jLSAge = null;//年龄
	JLabel jLSSpecialty = null;//专业
	JLabel jLSAddress = null;//住址

	JTextField jTFQueryField = null;//查询字段//JTextField文本框。JTextField 用来编辑单行的文本
	JTextField jTFSNo = null;//学号
	JTextField jTFSName = null;//姓名
	private JTextField jTFTime;
	JTextField jTFSSex = null;//性别
	JTextField jTFSAge = null;//年龄
	JTextField jTFSSpecialty = null;//专业
	JTextField jTFSAddress = null;//住址
	
	JButton jBQuery = null;//查询
	JButton jBQueryAll = null;//查询所有记录
	JButton jBInsert = null;//插入
	JButton jBUpdate = null;//更新
	JButton jBDeleteCurrentRecord = null;//删除当前记录
	JButton jBDeleteAllRecords = null;//删除所有记录
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//查询字段
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
	Vector studentVector = null;//vector它实现了动态数组，用于元素数量变化的对象数组。像数组一样
	Vector titleVector = null;
	Vector studentVector1 = null;
	Vector studentVector2 = null;
	//vector它实现了动态数组，用于元素数量变化的对象数组。像数组一样
	Vector titleVector1 = null;
	Vector studentVector21 = null;
	Vector titleVector2 = null;
	Vector titleVector3 = null;
	
	private static DbPro DbPro;
	String SelectQueryFieldStr = "学号";
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

	// 构造函数
	public student1(String Stu) {
		// 创建组件	
		Stu1=Stu;
		jLStudentInfoTable = new JLabel("学生信息表");
	
		studentVector = new Vector();//数组
		titleVector = new Vector();
		
		// 定义表头
		
		studentVector1 = new Vector();//数组
		studentVector2 = new Vector();//数组
		studentVector21 = new Vector();//数组
		titleVector1 = new Vector();
		titleVector2 = new Vector();
		titleVector3 = new Vector();
		// 定义表头
		titleVector2.add("记录号");
		titleVector2.add("时间");
		titleVector2.add("奖励等级");
		titleVector2.add("奖励描述");
	
		
		titleVector=titleVector2;//默认输出所有奖励记录
		
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable2 = new JTable(studentVector2, titleVector);//表格的代码
		studentJTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//禁止自适应，就会开启滚动条
		studentJTable2.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane_2 = new JScrollPane(studentJTable2);
		studentJScrollPane_2.setBounds(10, 10, 216, 127);
		//studentJScrollPane.setBounds(0, 0, 462, 83);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane_2.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane_2.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//为表格添加监听器 
		studentJScrollPane_2.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//将表格数据外显到面板
				//textField.setText((String) v.get(0));// 学号
				/*jTFSName.setText((String) v.get(1));// 姓名
				jTFSSex.setText((String) v.get(2));// 性别
				jTFSAge.setText(Integer.toString((int) v.get(3)));// 年龄
				jTFSSpecialty.setText((String) v.get(4));// 专业
				jTFSAddress.setText((String) v.get(5));// 住址*/
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
		titleVector1.add("学号");
		titleVector1.add("姓名");
		titleVector1.add("性别");
		titleVector1.add("班级");
		titleVector1.add("院系");
		titleVector1.add("生日");
		titleVector1.add("籍贯");
		titleVector1.add("学籍");
		titleVector1.add("奖励等级");
		titleVector1.add("处罚等级");
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable1 = new JTable(studentVector1, titleVector1);//表格的代码
		studentJTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//禁止自适应，就会开启滚动条
		studentJTable1.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane_1 = new JScrollPane(studentJTable1);
		studentJScrollPane_1.setBounds(0, 0, 462, 83);
		jP2.add(studentJScrollPane_1);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane_1.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane_1.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jPBottom.setLayout(null);
		
		studentJTable1.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//将表格数据外显到面板
				//textField.setText((String) v.get(0));// 学号
				/*jTFSName.setText((String) v.get(1));// 姓名
				jTFSSex.setText((String) v.get(2));// 性别
				jTFSAge.setText(Integer.toString((int) v.get(3)));// 年龄
				jTFSSpecialty.setText((String) v.get(4));// 专业
				jTFSAddress.setText((String) v.get(5));// 住址*/
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
		
		JButton button = new JButton("历史获奖情况查询");
		button.addActionListener(this);
		button.setBounds(22, 10, 138, 23);
		jP4.add(button);
		
		button_1 = new JButton("历史处罚情况查询");
		button_1.setBounds(312, 10, 138, 23);
		button_1.addActionListener(this);
		jP4.add(button_1);
		
		jBOut = new JButton("保存并退出");
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
		
		titleVector3.add("记录号");
		titleVector3.add("时间");
		titleVector3.add("处罚等级");
		titleVector3.add("处罚描述");
		titleVector3.add("处罚执行");
		//studentVector2
		
		table = new JTable(studentVector21,titleVector3);//表格的代码
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//禁止自适应，就会开启滚动条
		table.setPreferredScrollableViewportSize(new Dimension(455,150));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(228, 10, 216, 127);
		//studentJScrollPane.setBounds(0, 0, 462, 83);
		//分别设置水平和垂直滚动条自动出现
		scrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//为表格添加监听器 
		scrollPane.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);
				//将表格数据外显到面板
				//textField.setText((String) v.get(0));// 学号
				/*jTFSName.setText((String) v.get(1));// 姓名
				jTFSSex.setText((String) v.get(2));// 性别
				jTFSAge.setText(Integer.toString((int) v.get(3)));// 年龄
				jTFSSpecialty.setText((String) v.get(4));// 专业
				jTFSAddress.setText((String) v.get(5));// 住址*/
			}
		});
		panel.add(scrollPane);
		
		//
		
		jBQueryAll = new JButton("新生报到");
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
		
		button_2 = new JButton("个人信息修改");
		button_2.setBounds(249, 5, 105, 23);
		button_2.addActionListener(this);
		jP3.add(button_2);
		
		JButton btnNewButton = new JButton("开始使用");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(64, 5, 105, 23);
		jP3.add(btnNewButton);
		this.setTitle("学生管理系统");
		this.setSize(500, 451);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		DbPro = new DbPro();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("开始使用")){
			System.out.println("开始使用");
			try{
				// 建立查询条件
				String sql=url2;
					sql = sql  + Stu1+";";
				System.out.println("queryProcess(). sql = " + sql);
				DbPro DbPro =new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(sql);
				// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				studentVector1.clear();
				while(rs.next()){//生存输出的列表的所需的信息
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
					"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getActionCommand().equals("历史获奖情况查询")) {
			System.out.println("actionPerformed(). 历史获奖情况查询");
			Reward();
			
		}else if(e.getActionCommand().equals("历史处罚情况查询")) {
			System.out.println("actionPerformed(). 历史处罚情况查询");
			Punlishment();
				
		}else if(e.getActionCommand().equals("新生报到")){
				
			System.out.println("actionPerformed().新生报到");
			String op=Stu1;
			String op1="名字";
			String op2="男|女";
			String op3="1-6";
			String op4="11-14";
			String op5="2018-9-20";
			String op6="湖南-长沙";
			select1 Select=new select1(op,op1, op2,op3, op4, op5,op6);
			
		}else if(e.getActionCommand().equals("个人信息修改")){
			System.out.println("actionPerformed(). 个人信息修改");
			Vector v1=null;
			try{
				// 建立查询条件
				
				String url6="SELECT *from student WHERE student.StudentId = ";
				url6 =url6+ Stu1+";";
				System.out.println("queryAllProcess(). sql = " + url6);
				DbPro DbPro=new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(url6);
				
				// 将查询获得的记录数据，转换成适合生成JTable的数据形式
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
					"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
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
        //InitGlobalFont.InitGlobalFont(new Font("微软雅黑", Font.PLAIN, 16));
		String Stu ="1801";
		student1 getcon = new  student1(Stu);

		System.out.println("成功进入学生浏览界面");
    }
	public void Reward(){
		//SELECT * FROM reward  left outer join rewardlevel ON reward.Levels=rewardlevel.ReCode WHERE reward.StudentId=1801 ORDER BY  RecTime DESC;
		String url2 ="SELECT * FROM reward  left outer join rewardlevel ON reward.Levels=rewardlevel.ReCode WHERE reward.StudentId= ";
		try{
			// 建立查询条件
			String sql=url2;
				sql = sql  + Stu1+" ORDER BY  RecTime DESC ;";
			System.out.println("queryProcess(). sql = " + sql);
			DbPro DbPro =new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector2.clear();
			while(rs.next()){//生存输出的列表的所需的信息
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	//*******************查询操作*********************
	
	public void Punlishment(){
		//SELECT * FROM punishment  left outer join punishlevel ON punishment.Levels=punishlevel.PuCode WHERE  punishment.StudentId =1801 ORDER BY  RecTime DESC;
		String url2 ="SELECT * FROM punishment  left outer join punishlevel ON punishment.Levels=punishlevel.PuCode WHERE  punishment.StudentId = ";
		try{
			// 建立查询条件
			String sql=url2;
				sql = sql  + Stu1+" ORDER BY  RecTime DESC;";
			System.out.println("queryProcess(). sql = " + sql);
			DbPro DbPro =new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector21.clear();
			while(rs.next()){//生存输出的列表的所需的信息
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	//***********插入数据*************
	/*public void insertProcess()
	{
		String sNo = jTFSNo.getText().trim();
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sAge = jTFSAge.getText().trim();
		String sSpecialty = jTFSSpecialty.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		// 建立插入条件
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
//***********从标签窗口修改数据***********
	public void updateProcess()
	{
		String sNo = jTFSNo.getText().trim();//从标签栏读入
		String sName = jTFSName.getText().trim();
		String sSex = jTFSSex.getText().trim();
		String sAge = jTFSAge.getText().trim();
		String sSpecialty = jTFSSpecialty.getText().trim();
		String sAddress = jTFSAddress.getText().trim();
		
		// 建立更新条件
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
//**************删除当前数据
	public void deleteCurrentRecordProcess()
	{
		String sNo = jTFSNo.getText().trim();
		
		// 建立删除条件
		String sql = "delete from student where sNo = '" + sNo + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// 建立删除条件
		String sql = "delete from student;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try{
			if (DbPro.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}*/
	//数据库核心代码
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("学号")){
			outputStr = "student.StudentId";
		}else if(InputStr.equals("姓名")){
			outputStr = "student.Name";
		}else if(InputStr.equals("性别")){
			outputStr = "student.Sex";
		}else if(InputStr.equals("班级")){
			outputStr = "class.ClassName";
		}else if(InputStr.equals("院系")){
			outputStr = "department.DeName";
		}else if(InputStr.equals("生日")){
			outputStr = "student.Birthday";
		}else if(InputStr.equals("籍贯")){
			outputStr = "student.NativePlace";
		}else if(InputStr.equals("奖励")){
			outputStr = "reward.Descripment";//将奖励表输出
		}else if(InputStr.equals("处罚")){
			outputStr = "Punishment.Description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
