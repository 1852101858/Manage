package manage;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dataEditor.*;

 
public class UserFrame extends JFrame implements ActionListener {
 
	private JLabel jLabelAccout, jlLabelpass; 
	private JButton loginBtn, registBtn; 
	private JTextField jFieldAccout, jFieldpass; 
	public UserEditor userIn = new UserEditor(); 
 

	public void init() {
		FlowLayout f = new FlowLayout(); 
		f.setAlignment(FlowLayout.LEFT); 
		f.setHgap(30); 
		f.setVgap(30); 
		jLabelAccout = new JLabel("账  号");
		add(jLabelAccout);
		jFieldAccout = new JTextField(12); 
		add(jFieldAccout);
		jlLabelpass = new JLabel("密  码");
		add(jlLabelpass);
		jFieldpass = new JTextField(12); 
		add(jFieldpass);
		loginBtn = new JButton("登陆"); 
		loginBtn.addActionListener(this); 
		loginBtn.setActionCommand("login"); 
		add(loginBtn);
		registBtn = new JButton();
		registBtn.setText("注册用户"); 
		registBtn.addActionListener(this); 
		registBtn.setActionCommand("regist"); 
		add(registBtn);
		setLayout(f); 
 
		this.setTitle("商品系统-登陆"); 
		this.setSize(300, 220); 
		this.setIconImage((new ImageIcon("images/logo.jpg")).getImage()); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		int width = Toolkit.getDefaultToolkit().getScreenSize().width; 
		int height = Toolkit.getDefaultToolkit().getScreenSize().height; 
		this.setLocation((width - 500) / 2, (height - 400) / 2); 
		this.setResizable(true); 
		this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accout = jFieldAccout.getText().trim().toString(); 
		String pass = jFieldpass.getText().trim().toString(); 
		if (e.getActionCommand().equals("login")) { 
			User user = userIn.getUserByAccout(accout); 
			if (user != null) { 
				if (user.getPass().equals(pass)) {
					this.dispose(); 
 
					new GoodsFrame().init(); 
				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "信息", JOptionPane.INFORMATION_MESSAGE);
				}

			} else { 
				JOptionPane.showMessageDialog(null, "用户不存在", "信息", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getActionCommand().equals("regist")) {
			if (accout.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名和密码不能为空", "信息", JOptionPane.INFORMATION_MESSAGE);
			} else {
 
				if (userIn.getUserByAccout(accout) != null) {
					JOptionPane.showMessageDialog(null, "账户重复", "信息", JOptionPane.INFORMATION_MESSAGE);
				} else {
					User user = new User(accout, pass);
					boolean flag = userIn.insertUser(user);
					if (flag) {
						JOptionPane.showMessageDialog(null, "注册成功，请登陆", "信息", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "注册异常", "信息", JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		}

	}
}
