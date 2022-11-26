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

 public class ListPanel extends JPanel {
 	Vector rowData, columnNames;
	JTable jt = null;

	JScrollPane jsp = null;

	 static DefaultTableModel tableModel;

	 public ListPanel() {
		ArrayList<Goods> allgoods = new GoodsEditor().getGoodsList();
		columnNames = new Vector();
		columnNames.add("商品编号");
		columnNames.add("商品名称");
		columnNames.add("商品产地");
		columnNames.add("商品数量");
		columnNames.add("商品单位");
		columnNames.add("商品价格");
		columnNames.add("商品总价");
		rowData = new Vector();
		for (int i = 0; i < allgoods.size(); i++) {
			Vector hang = new Vector();
			hang.add(allgoods.get(i).getId());
			hang.add(allgoods.get(i).getName());
			hang.add(allgoods.get(i).getLocation());
			hang.add(allgoods.get(i).getNum());
			hang.add(allgoods.get(i).getUnit());
			hang.add(allgoods.get(i).getPrice());
			hang.add(allgoods.get(i).getTprice());
			String a=allgoods.get(i).getId().toString();
			rowData.add(hang);

		}


		 tableModel = new DefaultTableModel(rowData,columnNames);
		jt=new JTable(tableModel){
			public boolean isCellEditable(int row, int column)
			{
				return false;}//表格不允许被编辑
		};
		jt.setRowSelectionAllowed(true);
		 jt.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e)
			 {
				 if (e.getClickCount() == 2) {
					 int a = jt.getSelectedRow();
					 JOptionPane.showMessageDialog(null, a, "信息", JOptionPane.INFORMATION_MESSAGE);
				 }}});



		 jsp = new JScrollPane(jt);
		//jsp.setEnabled(false);
		this.add(jsp);
	 }
 }
