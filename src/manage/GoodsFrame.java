package manage;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dataEditor.*;

 
 
public class GoodsFrame extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenuItem list,check,in,out,editor;
	public static Container container;
	public static CardLayout cardlayout;
	private GoodsEditorFrame goodseditorframe;
	private GoodsCheckFrame goodscheckframe;
	private GoodsInNewFrame goodsinframe;
	private GoodsOutFrame goodsoutframe;
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
		in = new JMenuItem("入库新商品");
		in.addActionListener(this);
		in.setActionCommand("in");
		out = new JMenuItem("出库");
		out.addActionListener(this);
		out.setActionCommand("out");
		menuBar.add(list);
		menuBar.add(check);
		menuBar.add(in);
		menuBar.add(out);
		this.setJMenuBar(menuBar);
 		cardlayout = new CardLayout();
		container = getContentPane();
		container.setLayout(cardlayout);
		listPanel = new ListPanel();
		container.add(listPanel, "listPanel");
		cardlayout.show(container, "listPanel");
		this.setTitle("库存管理系统");
		this.setSize(500, 520);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width - 500) / 2, (height - 520) / 2);
		this.setVisible(true);
		this.setResizable(true);
	}

	public void adminFrame() {
		menuBar = new JMenuBar();
		list= new JMenuItem("列表");
		list.addActionListener(this);
		list.setActionCommand("list");
		check = new JMenuItem("查询");
		check.addActionListener(this);
		check.setActionCommand("check");
		in = new JMenuItem("入库新商品");
		in.addActionListener(this);
		in.setActionCommand("in");
		out = new JMenuItem("出库");
		out.addActionListener(this);
		out.setActionCommand("out");
		editor = new JMenuItem("商品编辑");
		editor.addActionListener(this);
		editor.setActionCommand("editor");
		menuBar.add(list);
		menuBar.add(check);
		menuBar.add(in);
		menuBar.add(out);
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
		}else if (e.getActionCommand().equals("in")) {
			goodsinframe = new GoodsInNewFrame();
			container.add(goodsinframe, "crudPanel");
			cardlayout.show(container, "crudPanel");
		}else if (e.getActionCommand().equals("out")) {
				   goodsoutframe = new GoodsOutFrame();
				   container.add(goodsoutframe, "crudPanel");
				   cardlayout.show(container, "crudPanel");
		}else if (e.getActionCommand().equals("editor")) {
				goodseditorframe = new GoodsEditorFrame();
				container.add(goodseditorframe, "crudPanel");
				cardlayout.show(container, "crudPanel");
		}else if (e.getActionCommand().equals("check")) {
				goodscheckframe = new GoodsCheckFrame();
				container.add(goodscheckframe, "crudPanel");
				cardlayout.show(container, "crudPanel");
			}
	}
}
