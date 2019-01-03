
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
	// 定义组件
	JLabel jLStudentInfoTable = null;//学生信息表；jlabel该标签在其显示区内垂直和水平居中对齐。
	JLabel jLSelectQueryField = null;//选择查询字段
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//学号
	JLabel jLSClass = null;//学号
	JLabel jLSName = null;//姓名
	JLabel jLSSex = null;//性别
	JLabel jLSAge = null;//年龄
	JLabel jLSSpecialty = null;//专业
	JLabel jLSAddress = null;//住址

	JTextField jTFQueryField = null;//查询字段//JTextField文本框。JTextField 用来编辑单行的文本
	JTextField jTFSNo = null;//学号
	JTextField jTFSName = null;//姓名
	JTextField jTFSSex = null;//性别
	JTextField jTFSAge = null;//年龄A
	JTextField jTFSSpecialty = null;//专业
	JTextField jTFSAddress = null;//住址
	JTextField jTFClass = null;//住址
	
	//private static DbPro DbPro;
	
	JButton jBQuery = null;//查询
	JButton jBQueryAll = null;//查询所有记录
	JButton jBInsert = null;//插入
	JButton jBUpdate = null;//更新
	JButton jBDeleteCurrentRecord = null;//删除当前记录
	JButton jBDeleteAllRecords = null;//删除所有记录
	
	//JComboBox jCBSelectQueryField = null;
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;//vector它实现了动态数组，用于元素数量变化的对象数组。像数组一样
	Vector titleVector = null;
	
	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "学号";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	String op="1801";

	// 构造函数
	public select1(String op,String op1,String op2,String op3,String op4,String op5,String op6) {
		System.out.println(op);
		jLSNo = new JLabel("学号");
		jLSNo.setBounds(5, 8, 24, 15);
		jLSName = new JLabel("姓名");
		jLSName.setBounds(105, 8, 24, 15);
		jLSSex = new JLabel("性别");
		jLSSex.setBounds(219, 8, 24, 15);
		jLSAge = new JLabel("院系编码");
		jLSAge.setBounds(80, 8, 55, 15);
		jLSSpecialty = new JLabel("生日");
		jLSSpecialty.setBounds(220, 8, 33, 15);
		jLSAddress = new JLabel("住址");
		jLSAddress.setBounds(349, 8, 24, 15);
		jLSClass = new JLabel("班级编码");
		jLSClass.setBounds(329, 8, 53, 15);
		jTFSNo = new JTextField(10);//学号
		
		//jTFSNo.setText((String)op);
		jTFSNo.setBounds(34, 5, 66, 26);
		jTFSName = new JTextField(10);//姓名
		jTFSName.setBounds(134, 5, 66, 26);
		jTFSSex = new JTextField(10);//性别
		jTFSSex.setBounds(253, 5, 66, 26);
		jTFSAge = new JTextField(10);//年龄
		jTFSAge.setBounds(133, 5, 66, 26);
		jTFSSpecialty = new JTextField(10);//专业
		jTFSSpecialty.setBounds(252, 5, 66, 26);
		jTFSAddress = new JTextField(10);//住址
		jTFSAddress.setBounds(383, 5, 66, 26);
		jBInsert = new JButton("放弃并退出");
		jBInsert.setBounds(49, 5, 109, 23);
		jBUpdate = new JButton("更新并退出");
		jBUpdate.setBounds(325, 5, 109, 23);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		//***************************************************************8
		
		
		
		studentVector = new Vector();//数组
		titleVector = new Vector();
		
		// 定义表头
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("年龄");
		titleVector.add("专业");
		titleVector.add("住址");
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
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel.setBounds(68, 30, 84, 140);
		StringBuffer sb = null;
		  sb = new StringBuffer("<html>院系对照表<br/><br/>编号___院号"
                                          + "<br/> _11__一院<br/> _12__二院<br/> _13__三院<br/> _14__四院</html>");
		 jPTop.setLayout(null);
		 lblNewLabel.setText(sb.toString());
		jPTop.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(176, 39, 86, 155);
		StringBuffer sb1 = null;
		 sb1 = new StringBuffer("<html>班级对照表<br/><br/>编号___班号"
                 + "<br/> _1___一班<br/> _2___二班<br/> _3___三班<br/> _4___四班</htm<br/> _5___五班<br/> _6___六班<html>");
		 lblNewLabel_1.setText(sb1.toString());
		jPTop.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("注意事项");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(211, 0, 110, 32);
		jPTop.add(lblNewLabel_2);
		getContentPane().add(jPBottom);
		this.setTitle("学生管理系统");
		this.setSize(500, 430);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
		jTFSNo.setText((String) op);//
		jTFSName.setText((String) op1);//名字
		jTFSSex.setText((String) op2);//性别
		jTFClass.setText(op3);//班级
		jTFSAge.setText((String) op4);//院
		jTFSSpecialty.setText((String) op5);//生日
		jTFSAddress.setText((String) op6);//籍贯*/
	}
	//hanshu
	public select1() {
		jLSNo = new JLabel("学号");
		jLSNo.setBounds(5, 8, 24, 15);
		jLSName = new JLabel("姓名");
		jLSName.setBounds(105, 8, 24, 15);
		jLSSex = new JLabel("性别");
		jLSSex.setBounds(219, 8, 24, 15);
		jLSAge = new JLabel("院系编码");
		jLSAge.setBounds(80, 8, 55, 15);
		jLSSpecialty = new JLabel("生日");
		jLSSpecialty.setBounds(220, 8, 33, 15);
		jLSAddress = new JLabel("住址");
		jLSAddress.setBounds(349, 8, 24, 15);
		jLSClass = new JLabel("班级编码");
		jLSClass.setBounds(329, 8, 53, 15);
		jTFSNo = new JTextField(10);//学号
		jTFSNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("检测中");
				jTFSNo.setText((String)op);
			}
		});
		//String op ="jhi";************************************
		jTFSNo.setText((String)op);
		jTFSNo.addActionListener(this);
		jTFSNo.setBounds(34, 5, 66, 26);
		jTFSName = new JTextField(10);//姓名
		jTFSName.setBounds(134, 5, 66, 26);
		jTFSSex = new JTextField(10);//性别
		jTFSSex.setBounds(253, 5, 66, 26);
		jTFSAge = new JTextField(10);//年龄
		jTFSAge.setBounds(133, 5, 66, 26);
		jTFSSpecialty = new JTextField(10);//专业
		jTFSSpecialty.setBounds(252, 5, 66, 26);
		jTFSAddress = new JTextField(10);//住址
		jTFSAddress.setBounds(383, 5, 66, 26);
		jBInsert = new JButton("放弃并退出");
		jBInsert.setBounds(49, 5, 109, 23);
		jBUpdate = new JButton("更新并退出");
		jBUpdate.setBounds(325, 5, 109, 23);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
	
		studentVector = new Vector();//数组
		titleVector = new Vector();
		
		// 定义表头
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("年龄");
		titleVector.add("专业");
		titleVector.add("住址");
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
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel.setBounds(89, 31, 122, 155);
		StringBuffer sb = null;
		  sb = new StringBuffer("<html>院系对照表<br/><br/>编号___院号"
                                          + "<br/> _11__计算机学院<br/> _12__土木学院<br/> _13__商学院<br/> _14__孔子学院<br/> _14__物理学院</html>");
		 jPTop.setLayout(null);
		 lblNewLabel.setText(sb.toString());
		jPTop.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(237, 39, 86, 155);
		StringBuffer sb1 = null;
		 sb1 = new StringBuffer("<html>班级对照表<br/><br/>编号___班号"
                 + "<br/> _1___一班<br/> _2___二班<br/> _3___三班<br/> _4___四班</htm<br/> _5___五班<br/> _6___六班<html>");
		 lblNewLabel_1.setText(sb1.toString());
		jPTop.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("注意事项");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(211, 0, 110, 32);
		jPTop.add(lblNewLabel_2);
		getContentPane().add(jPBottom);
		this.setTitle("学生管理系统");
		this.setSize(500, 430);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("更新并退出")
				&& !jTFSNo.getText().isEmpty()
				&& !jTFSName.getText().isEmpty()
				&& !jTFSSex.getText().isEmpty()
				&& !jTFClass.getText().isEmpty()
				&& !jTFSAge.getText().isEmpty()
				&& !jTFSSpecialty.getText().isEmpty()
				&& !jTFSAddress.getText().isEmpty()){
			insertProcess();
			System.out.println("允许操作");
			
		}else if(e.getActionCommand().equals("放弃并退出")){
			System.out.println("actionPerformed(). 放弃并退出");
			setVisible(false);//登录界面隐藏
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
        //InitGlobalFont.InitGlobalFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		select1 getcon = new  select1();
		//*****************
		
        
    }
	
	//***********插入数据*************
	public void insertProcess()
	{	
		
		String StudentId = jTFSNo.getText().trim();
		String Name = jTFSName.getText().trim();
		String Sex = jTFSSex.getText().trim();
		String Class = jTFClass.getText().trim();
		String Department = jTFSAge.getText().trim();
		String Birthday = jTFSSpecialty.getText().trim();
		String NativePlace = jTFSAddress.getText().trim();
		
		// 建立插入条件
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
				//JOptionPane.showMessageDialog(null, "操作成功");
			}
			JOptionPane.showMessageDialog(null,
                    "操作成功。");
			setVisible(false);//登录界面隐藏
			
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		
		
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
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		
		//queryAllProcess();
	}

	//数据库核心代码
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("学号")){
			outputStr = "sNo";
		}else if(InputStr.equals("姓名")){
			outputStr = "sName";
		}else if(InputStr.equals("性别")){
			outputStr = "sSex";
		}else if(InputStr.equals("年龄")){
			outputStr = "sAge";
		}else if(InputStr.equals("专业")){
			outputStr = "sSpecialty";
		}else if(InputStr.equals("住址")){
			outputStr = "sAddress";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
