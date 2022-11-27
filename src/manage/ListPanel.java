package manage;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dataEditor.*;

import static manage.GoodsFrame.container;

public class ListPanel extends JPanel {
 	Vector rowData, columnNames;
	JTable jt = null;
	JScrollPane jsp = null;
	 static DefaultTableModel tableModel;
	 private GoodsInFrame goodsinframe;

	 public ListPanel() {
		ArrayList<Goods> allgoods = new GoodsEditor().getGoodsList();
		columnNames = new Vector();
		columnNames.add("商品编号");
		columnNames.add("商品名称");
		columnNames.add("商品产地");
		columnNames.add("商品数量");
		columnNames.add("商品价格");
		columnNames.add("商品总价");
		rowData = new Vector();
		for (int i = 0; i < allgoods.size(); i++) {
			Vector hang = new Vector();
			hang.add(allgoods.get(i).getId());
			hang.add(allgoods.get(i).getName());
			hang.add(allgoods.get(i).getLocation());
			hang.add(allgoods.get(i).getNum());
			hang.add(allgoods.get(i).getPrice());
			hang.add(allgoods.get(i).getTprice());
			rowData.add(hang);
		}


		tableModel = new DefaultTableModel(rowData,columnNames);
		jt=new JTable(tableModel){
			public boolean isCellEditable(int row, int column)
			{
				return false;}//表格不允许被编辑
		};
		 jt.setRowSelectionAllowed(true);//允许选择行
		 jt.setFont(new Font("Song", Font.CENTER_BASELINE, 15));
		 jt.setRowHeight(30);
		 jt.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e)
			 {
				 if (e.getClickCount() == 2) {
					 int a = jt.getSelectedRow();
					int id = allgoods.get(a).getId();
					 String name1 = allgoods.get(a).getName();
					 String location1 = allgoods.get(a).getLocation();
					 Float num1 = allgoods.get(a).getNum();
					 Float price1 = allgoods.get(a).getPrice();
					 String date=allgoods.get(a).getDate();
					 GoodsEditor getGoods = null;
					 goodsinframe = new GoodsInFrame(id,name1,location1,num1,price1,date);
					 container.add(goodsinframe, "crudBookPanel");
					 GoodsFrame.cardlayout.show(container, "crudBookPanel");
				 }}});

		 jsp = new JScrollPane(jt,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS  );
		jsp.setEnabled(false);
		this.add(jsp);
	 }
 }
