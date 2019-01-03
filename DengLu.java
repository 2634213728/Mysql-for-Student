import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
/*
 * 比较有用的消息弹窗JOptionPane网址：https://blog.csdn.net/c1481118216/article/details/51921521
 * 
 */
public class DengLu extends JFrame  implements ActionListener{
	public JPanel contentPane;
	private static JTextField Tno;
	private static JTextField Tmi;
	
	String SelectQueryFieldStr;
	public static void main(String[] args) {
			try {
		            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
		            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			DengLu frame1 = new DengLu();
			frame1.setVisible(true);
			JOptionPane.showMessageDialog(null,
                    "——学生信息管理系统解密完成——");
		 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确认登录")  
				&& !Tno.getText().isEmpty()
				&& !Tmi.getText().isEmpty()){
			System.out.println("actionPerformed(). 确认登录");
			String sQueryField = Tno.getText().trim();
			String sQueryField1 = Tmi.getText().trim();
			String w="学生";
			
			if(SelectQueryFieldStr.equals(w)){
				//String url1="SELECT * from xsmima where XSId =1802;";
				String sql = "SELECT * from xsmima where XSId = ";
				sql = sql + sQueryField + ";";
				System.out.println("queryProcess(). sql = " + sql);
				DbPro DbPro =new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(sql);
				
				try {
					while(rs.next()){ 
						String q=rs.getString("XSMi");
						String p=rs.getString("XSId");
						System.out.println(q+p);
						try{
						if(sQueryField.equals(p)&&sQueryField1.equals(q)) {
							System.out.println("登录成功");
							JOptionPane.showMessageDialog(null,
			                        "欢迎使用学生信息管理系统学生端。");
							student1 student1=new student1(sQueryField);
							student1.setVisible(true);
							setVisible(false);
						}
						else{
			                System.out.println("登录失败");
			                JOptionPane.showMessageDialog(null,
			                        "请检查登录身份，账号与密码是否正确。", "登录失败", JOptionPane.ERROR_MESSAGE);
			            }
						}catch(Exception e1){
							System.out.println("e = " + e1); 
							JOptionPane.showMessageDialog(null,
								"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				} catch (HeadlessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	
			}
			else if(SelectQueryFieldStr.equals("教师")){
				//String url1="SELECT * from jsmima where jsmima.JSId =12;";
				String sql = "SELECT * from jsmima where JSId = ";
				sql = sql + sQueryField + ";";
				System.out.println("queryProcess(). sql = " + sql);
				DbPro DbPro =new DbPro();
				DbPro.connect();
				ResultSet rs = DbPro.executeQuery(sql);
				
					try {
						while(rs.next()){
							String q=rs.getString("JSMi");
							String p=rs.getString("JSId");
							try{
							if(sQueryField.equals(p)&&sQueryField1.equals(q)) {
								
								JOptionPane.showMessageDialog(null,
				                        "欢迎使用学生信息管理教师端系统。");
								teacher1 teacher=new teacher1();
								teacher.setVisible(true);
								setVisible(false);
								
							}else{
				                System.out.println("登录失败");
				                JOptionPane.showMessageDialog(null,
				                        "请检查登录身份，账号与密码是否正确。", "登录失败", JOptionPane.ERROR_MESSAGE);
				            }
							}catch(Exception e1){
								System.out.println("e = " + e1);
								JOptionPane.showMessageDialog(null,
									"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
							}
							
						}
					} catch (HeadlessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			//Tmi.setText("");
			}
		
			
		}
	/**
	 * Create the frame.
	 */
	public DengLu() {
		setResizable(false);
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u5F55\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(146, 15, 251, 51);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("安全退出");
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		button_1.setBounds(324, 208, 92, 23);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "——学生信息管理系统正在加密——");  
				//sleep();
				JOptionPane.showMessageDialog(null,
	                    "——学生信息管理系统加密完成——");
				setVisible(false);//登录界面隐藏
			}
		});
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 450, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(" ");
		comboBox.addItem("学生");
		comboBox.addItem("教师");
		
		//下拉框的制作
		comboBox.addItemListener(new ItemListener() {//下拉框事件监听  
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
		comboBox.setBounds(313, 21, 91, 25);
		panel.add(comboBox);
		
		JLabel NO = new JLabel("学号/职工号");
		NO.setFont(new Font("楷体", Font.PLAIN, 14));
		NO.setBounds(68, 23, 87, 20);
		panel.add(NO);
		
		JLabel MI = new JLabel("    密码");
		MI.setFont(new Font("楷体", Font.PLAIN, 14));
		MI.setBounds(68, 61, 87, 20);
		panel.add(MI);
		
		Tno = new JTextField();
		Tno.setBounds(165, 21, 128, 25);
		panel.add(Tno);
		Tno.setColumns(10);
		
		Tmi = new JTextField();
		Tmi.setBounds(165, 59, 128, 25);
		panel.add(Tmi);
		Tmi.setColumns(10);
		
		JButton button = new JButton("确认登录");
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(313, 60, 92, 23);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		button .addActionListener(this);
		
	}
}
