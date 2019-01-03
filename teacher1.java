
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
	
	Vector v = new Vector();
	String op =null;

	JTextField jTFQueryField = null;//查询字段//JTextField文本框。JTextField 用来编辑单行的文本
	private JTextField jTFCha;
	JTextField jTFSNo = null;//学号
	private JTextField jTFID;
	JTextField jTFSName = null;//姓名
	private JTextField jTFTime;
	JTextField jTFSSex = null;//性别
	JTextField jTFSAge = null;//年龄
	JTextField jTFSSpecialty = null;//专业
	JTextField jTFSAddress = null;//住址
	
	JButton jBQuery = null;//查询
	private JButton jBQueryCha;
	JButton jBQueryAll = null;//查询所有记录
	JButton jBInsert = null;//插入
	JButton jBUpdate = null;//更新
	JButton jBDeleteCurrentRecord = null;//删除当前记录
	JButton jBDeleteAllRecords = null;//删除所有记录
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;//vector它实现了动态数组，用于元素数量变化的对象数组。像数组一样
	Vector titleVector = null;
	Vector v1= null;
	
	//private static DbPro DbPro;
	String SelectQueryFieldStr = "学号";
	String SelectQueryFieldStr1 = "奖励";
	String SelectQueryFieldStr2 = "转系";
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

	// 构造函数
	public teacher1() {
		// 创建组件	
		jLStudentInfoTable = new JLabel("学生信息表");
		jLSAge = new JLabel("学生流动情况");
		jLSAge.setBounds(5, 8, 78, 15);
		jBInsert = new JButton("插入");
		jBUpdate = new JButton("更新");
		jBDeleteCurrentRecord = new JButton("删除当前记录");
		jBDeleteAllRecords = new JButton("删除所有记录");
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
	
		studentVector = new Vector();//数组
		titleVector = new Vector();
		
		// 定义表头
		/*titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("年龄");
		titleVector.add("专业");
		titleVector.add("住址");*/
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("班级");
		titleVector.add("院系");
		titleVector.add("生日");
		titleVector.add("籍贯");
		titleVector.add("学籍变更");
		titleVector.add("变更描述 ");
		titleVector.add("奖励时间");
		titleVector.add("奖励描述");
		titleVector.add("奖励等级");
		titleVector.add("处罚时间");
		titleVector.add("处罚描述");
		titleVector.add("处罚等级");
		titleVector.add("处罚是否执行");
		//studentTable= new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);//表格的代码
		studentJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//禁止自适应，就会开启滚动条
		studentJTable.setPreferredScrollableViewportSize(new Dimension(455,150));
		studentJScrollPane = new JScrollPane(studentJTable);
		studentJScrollPane.setBounds(0, 0, 462, 156);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//为表格添加监听器 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e)
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);

				v = (Vector) studentVector.get(row);
				//将表格数据外显到面板
				op=(String) v.get(0);
				jTFStu.setText((String) v.get(0));// 学号
				/*jTFSName.setText((String) v.get(1));// 姓名
				jTFSSex.setText((String) v.get(2));// 性别
				jTFSAge.setText(Integer.toString((int) v.get(3)));// 年龄
				jTFSSpecialty.setText((String) v.get(4));// 专业
				jTFSAddress.setText((String) v.get(5));// 住址*/
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
		
		comboBoxJiang.addItem("奖励");  
		comboBoxJiang.addItem("处罚");  
		//下拉框的制作
		comboBoxJiang.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr1 = (String) event.getItem();  
                    System.out.println("选中：" + SelectQueryFieldStr1);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
                    break;  
                }  
            }  
        });
		jP4.add(comboBoxJiang);
		
		label_2 = new JLabel("奖惩方案");
		label_2.setBounds(148, 10, 68, 15);
		jP4.add(label_2);
		
		jLSDescription = new JLabel("奖惩描述");
		jLSDescription.setBounds(5, 46, 54, 15);
		jP4.add(jLSDescription);
		
		jTFDescription = new JTextField(10);
		jTFDescription.setBounds(64, 39, 172, 24);
		jP4.add(jTFDescription);
		
		jBYes1 = new JButton("确认");
		jBYes1.setBounds(389, 42, 75, 23);
		jBYes1.addActionListener(this);
		jP4.add(jBYes1);
		
		JLabel label_1 = new JLabel("奖惩等级");
		label_1.setBounds(5, 10, 49, 15);
		jP4.add(label_1);
		
		textField = new JTextField(10);
		textField.setBounds(64, 6, 66, 24);
		jP4.add(textField);
		
		label_3 = new JLabel("处罚是否执行");
		label_3.setBounds(305, 10, 75, 15);
		jP4.add(label_3);
		
		textField_1 = new JTextField(10);
		textField_1.setBounds(389, 6, 66, 24);
		jP4.add(textField_1);
		jPBottom.add(jP5);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(93, 5, 64, 21);//***********************************
		comboBox_1.addItem("转系");  
		comboBox_1.addItem("休学");  
		comboBox_1.addItem("复学"); 
		comboBox_1.addItem("退学"); 
		comboBox_1.addItem("毕业"); 
		//下拉框的制作
		comboBox_1.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr2= (String) event.getItem();  
                    System.out.println("选中：" + SelectQueryFieldStr2);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		jP5.add(comboBox_1);
		
		jBYes2 = new JButton("流动确认");
		jBYes2.setBounds(372, 4, 81, 23);
		jBYes2.addActionListener(this);
		
		jP5.add(jBYes2);
		
		label_4 = new JLabel("流动描述");
		label_4.setBounds(167, 8, 54, 15);
		jP5.add(label_4);
		
		textField_2 = new JTextField(10);
		textField_2.setBounds(219, 5, 132, 24);
		jP5.add(textField_2);
		jPBottom.add(jP6);
		
		jBOut = new JButton("保存并退出");
		jP6.add(jBOut);
		getContentPane().setLayout(null);
		
		getContentPane().add(jPTop);
		getContentPane().add(jPBottom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 474, 38);
		jPBottom.add(panel_1);
		panel_1.setLayout(null);
		jLSNo = new JLabel("记录号");
		jLSNo.setBounds(26, 10, 36, 15);
		panel_1.add(jLSNo);
		jTFID = new JTextField(10);
		jTFID.setBounds(67, 6, 66, 24);
		panel_1.add(jTFID);
		jLSName = new JLabel("记录时间");
		jLSName.setBounds(156, 10, 54, 15);
		panel_1.add(jLSName);
		jTFTime = new JTextField(10);
		jTFTime.setBounds(220, 6, 66, 24);
		panel_1.add(jTFTime);
		jLSelectQueryField = new JLabel("选择查询字段");
		jLSelectQueryField.setBounds(10, 9, 72, 15);
		jLEqual = new JLabel(" = ");
		jLEqual.setBounds(150, 9, 18, 15);
		
		jTFCha = new JTextField(10);//选择查询的语句
		jTFCha.setBounds(167, 5, 72, 23);
		
		jBQueryCha = new JButton("查询");
		jBQueryCha.setBounds(249, 5, 57, 23);
		jBQueryAll = new JButton("查询所有记录");
		jBQueryAll.setBounds(359, 42, 105, 23);
		// 设置监听
		jBQueryCha.addActionListener(this);
		jBQueryAll.addActionListener(this);
		//
		jCBSelectQueryField = new JComboBox<String>();
		jCBSelectQueryField.setBounds(82, 6, 67, 21);
		jCBSelectQueryField.addItem("学号");  
		jCBSelectQueryField.addItem("姓名");  
		jCBSelectQueryField.addItem("性别");
		jCBSelectQueryField.addItem("班级");
		jCBSelectQueryField.addItem("院系");
		jCBSelectQueryField.addItem("生日");
		jCBSelectQueryField.addItem("籍贯");
		jCBSelectQueryField.addItem("学籍");
		jCBSelectQueryField.addItem("奖励");
		jCBSelectQueryField.addItem("处罚");
		
		//下拉框的制作
		jCBSelectQueryField.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();//选中的文字
                    System.out.println("选中：" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
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
		
		jLSTudent = new JLabel("查询对象学号");
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
		this.setTitle("学生管理系统");
		this.setSize(500, 580);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")
			&& !jTFCha.getText().isEmpty()){
			System.out.println("actionPerformed(). 查询");
			String sQueryField = jTFCha.getText().trim();//trim()函数用于去除字符串两端的空白字符。
			queryProcess(sQueryField);
		}else if(e.getActionCommand().equals("查询所有记录")) {
			System.out.println("actionPerformed(). 查询所有记录");
			queryAllProcess();
			jTFCha.setText("");//清空JTF
		}else if(e.getActionCommand().equals("插入")){
			System.out.println("actionPerformed(). 插入");
			select1 getcon = new  select1();
			queryAllProcess();
		}else if(e.getActionCommand().equals("确认")
				&& !jTFID.getText().isEmpty()
				&& !jTFTime.getText().isEmpty()
				&& !jTFDescription.getText().isEmpty()){
			System.out.println("actionPerformed(). 奖惩执行");
				RewordProcess();
				jTFID.setText("");
				jTFTime.setText("");
				jTFDescription.setText("");
				
			//queryAllProcess();
		}else if(e.getActionCommand().equals("删除当前记录")){
			System.out.println("actionPerformed(). 删除当前记录");
			String sQueryField = jTFCha.getText().trim();
			deleteCurrentRecordProcess(sQueryField);
			jTFCha.setText("");
		}else if(e.getActionCommand().equals("删除所有记录")){
			System.out.println("actionPerformed(). 删除所有记录");
			deleteAllRecordsProcess();
		}
		else if(e.getActionCommand().equals("查询历史奖惩记录")){
			System.out.println("actionPerformed(). 查询历史奖惩记录");
		}
		else if(e.getActionCommand().equals("流动确认")){
			System.out.println("actionPerformed(). 流动确认");
			ChangeProcess();
			
		}
		else if(e.getActionCommand().equals("更新")){
			String sQueryField=null;
			if(jTFID.getText().isEmpty()) {
				sQueryField = jTFStu.getText().trim();
			}else {
				sQueryField = jTFCha.getText().trim();
			}
			System.out.println("actionPerformed(). 更新");
			try{
				// 建立查询条件
				
				String url6="SELECT *from student WHERE student.StudentId = ";
				url6 =url6+ sQueryField+";";
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
		teacher1 getcon = new  teacher1();
		ClickAction getcon1 = new  ClickAction();
		System.out.println("成功进入教师浏览界面");
    }
	//*******************查询操作*********************
	public void queryProcess(String sQueryField)
	{
		try{
			// 建立查询条件
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
			// 将查询获得的记录数据，转换成适合生成JTable的数 据形式
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	//***************全部输出*******************
	public void queryAllProcess()
	{
		try{
			// 建立查询条件
			String sql = url1;
			System.out.println("queryAllProcess(). sql = " + sql);
			DbPro DbPro=new DbPro();
			DbPro.connect();
			ResultSet rs = DbPro.executeQuery(sql);
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	//***********插入数据*************
	public void RewordProcess()
	{
		String sql=null;
		String queryFieldStr1 = jCBSelectQueryFieldTransfer(SelectQueryFieldStr1);
		if(queryFieldStr1.equals("reward.Descripment")) {//奖励
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
		else{//处罚
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
                System.out.println("更改失败");
                JOptionPane.showMessageDialog(null,
                        "请检查记录号是否唯一。", "更改失败", JOptionPane.ERROR_MESSAGE);
            }
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
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
					"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
	}
//***********从标签窗口修改数据***********
	/*public void updateProcess()
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
	}*/
//**************删除当前数据
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
		// 建立删除条件
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	}

	public void deleteAllRecordsProcess()
	{
		// 建立删除条件
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
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	//数据库核心代码
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("学号")){
			outputStr = "student.StudentId";
		}else if(InputStr.equals("姓名")){
			outputStr = "student.`Name`";
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
			outputStr = "Punishment.Description1";
		}
		else if(InputStr.equals("转系")){
			outputStr = "0";
		}
		else if(InputStr.equals("休学")){
			outputStr = "1";
		}
		else if(InputStr.equals("复学")){
			outputStr = "2";
		}
		else if(InputStr.equals("退学")){
			outputStr = "3";
		}
		else if(InputStr.equals("毕业")){
			outputStr = "4";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
