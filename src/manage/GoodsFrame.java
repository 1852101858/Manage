package manage;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dataEditor.*;

 
 
public class GoodsFrame extends JFrame implements ActionListener {
 
	private JMenuBar menuBar;
 
	private JMenuItem list,check,updata,editor;
 
	private Container container;
 
	private CardLayout cardlayout;
 
	private GoodsEditorFrame goodseditorframe;
	private GoodsCheckFrame goodscheckframe;
	private GoodsChangeFrame goodschangeframe;
	private ListPanel listPanel;
 
 
	private GoodsEditor bookDao = new GoodsEditor();


	public void initFrame() {
		menuBar = new JMenuBar();
		list= new JMenuItem("列表");
		list.addActionListener(this); 
		list.setActionCommand("list");
		check = new JMenuItem("查询");
		check.addActionListener(this); 
		check.setActionCommand("check");
		updata = new JMenuItem("出入库");
		updata.addActionListener(this);
		updata.setActionCommand("updata");
		editor = new JMenuItem("商品编辑");
		editor.addActionListener(this); 
		editor.setActionCommand("editor");
		menuBar.add(list);
		menuBar.add(check);
		menuBar.add(updata);
		this.setJMenuBar(menuBar);
 		cardlayout = new CardLayout();
		container = getContentPane();
		container.setLayout(cardlayout);
		listPanel = new ListPanel();
		container.add(listPanel, "listPanel");
		cardlayout.show(container, "listPanel");
		this.setTitle("库存管理系统");
		this.setSize(600, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width - 500) / 2, (height - 400) / 2);
		this.setVisible(true);
		this.setResizable(false);
	}

	public void adminFrame() {
		menuBar = new JMenuBar();
		list= new JMenuItem("列表");
		list.addActionListener(this);
		list.setActionCommand("list");
		check = new JMenuItem("查询");
		check.addActionListener(this);
		check.setActionCommand("check");
		updata = new JMenuItem("出入库");
		updata.addActionListener(this);
		updata.setActionCommand("updata");
		editor = new JMenuItem("商品编辑");
		editor.addActionListener(this);
		editor.setActionCommand("editor");
		menuBar.add(list);
		menuBar.add(check);
		menuBar.add(updata);
        menuBar.add(editor);
		this.setJMenuBar(menuBar);
		cardlayout = new CardLayout();
		container = getContentPane();
		container.setLayout(cardlayout);
		listPanel = new ListPanel();
		container.add(listPanel, "listPanel");
		cardlayout.show(container, "listPanel");
		this.setTitle("库存管理系统");
		this.setSize(600, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width - 500) / 2, (height - 400) / 2);
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			   if (e.getActionCommand().equals("list")) {
			listPanel = new ListPanel();
			container.add(listPanel, "listPanel");
			cardlayout.show(container, "listPanel");
		} else if (e.getActionCommand().equals("updata")) {
			goodschangeframe = new GoodsChangeFrame();
			container.add(goodschangeframe, "crudBookPanel");
			cardlayout.show(container, "crudBookPanel");
		}else if (e.getActionCommand().equals("editor")) {
				goodseditorframe = new GoodsEditorFrame();
				container.add(goodseditorframe, "crudBookPanel");
				cardlayout.show(container, "crudBookPanel");
			}
			else if (e.getActionCommand().equals("check")) {
				goodscheckframe = new GoodsCheckFrame();
				container.add(goodscheckframe, "crudBookPanel");
				cardlayout.show(container, "crudBookPanel");
			}
	}
}
