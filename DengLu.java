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
 * �Ƚ����õ���Ϣ����JOptionPane��ַ��https://blog.csdn.net/c1481118216/article/details/51921521
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
                    "����ѧ����Ϣ����ϵͳ������ɡ���");
		 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ�ϵ�¼")  
				&& !Tno.getText().isEmpty()
				&& !Tmi.getText().isEmpty()){
			System.out.println("actionPerformed(). ȷ�ϵ�¼");
			String sQueryField = Tno.getText().trim();
			String sQueryField1 = Tmi.getText().trim();
			String w="ѧ��";
			
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
							System.out.println("��¼�ɹ�");
							JOptionPane.showMessageDialog(null,
			                        "��ӭʹ��ѧ����Ϣ����ϵͳѧ���ˡ�");
							student1 student1=new student1(sQueryField);
							student1.setVisible(true);
							setVisible(false);
						}
						else{
			                System.out.println("��¼ʧ��");
			                JOptionPane.showMessageDialog(null,
			                        "�����¼��ݣ��˺��������Ƿ���ȷ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			            }
						}catch(Exception e1){
							System.out.println("e = " + e1); 
							JOptionPane.showMessageDialog(null,
								"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
						}
						
					}
				} catch (HeadlessException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
	
			}
			else if(SelectQueryFieldStr.equals("��ʦ")){
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
				                        "��ӭʹ��ѧ����Ϣ�����ʦ��ϵͳ��");
								teacher1 teacher=new teacher1();
								teacher.setVisible(true);
								setVisible(false);
								
							}else{
				                System.out.println("��¼ʧ��");
				                JOptionPane.showMessageDialog(null,
				                        "�����¼��ݣ��˺��������Ƿ���ȷ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
				            }
							}catch(Exception e1){
								System.out.println("e = " + e1);
								JOptionPane.showMessageDialog(null,
									"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
							}
							
						}
					} catch (HeadlessException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("��ȫ�˳�");
		button_1.setFont(new Font("����", Font.PLAIN, 15));
		button_1.setBounds(324, 208, 92, 23);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "����ѧ����Ϣ����ϵͳ���ڼ��ܡ���");  
				//sleep();
				JOptionPane.showMessageDialog(null,
	                    "����ѧ����Ϣ����ϵͳ������ɡ���");
				setVisible(false);//��¼��������
			}
		});
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 450, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(" ");
		comboBox.addItem("ѧ��");
		comboBox.addItem("��ʦ");
		
		//�����������
		comboBox.addItemListener(new ItemListener() {//�������¼�����  
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
		comboBox.setBounds(313, 21, 91, 25);
		panel.add(comboBox);
		
		JLabel NO = new JLabel("ѧ��/ְ����");
		NO.setFont(new Font("����", Font.PLAIN, 14));
		NO.setBounds(68, 23, 87, 20);
		panel.add(NO);
		
		JLabel MI = new JLabel("    ����");
		MI.setFont(new Font("����", Font.PLAIN, 14));
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
		
		JButton button = new JButton("ȷ�ϵ�¼");
		button.setFont(new Font("����", Font.PLAIN, 15));
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
