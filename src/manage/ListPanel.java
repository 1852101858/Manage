package manage;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataEditor.*;

 public class ListPanel extends JPanel {
 
 
 
	Vector rowData, columnNames;
	JTable jt = null;
	JScrollPane jsp = null;

 
	public ListPanel() {
		ArrayList<Goods> books = new GoodsEditor().getGoodsList();
		columnNames = new Vector();
 
		columnNames.add("商品编号");
		columnNames.add("商品名称");
		columnNames.add("商品产地");
		columnNames.add("商品数量");
		columnNames.add("商品单位");
		columnNames.add("商品价格");
		columnNames.add("商品总价");
		rowData = new Vector();
		for (int i = 0; i < books.size(); i++) {
 
			Vector hang = new Vector();
			hang.add(books.get(i).getId());
			hang.add(books.get(i).getName());
			hang.add(books.get(i).getLocation());
			hang.add(books.get(i).getNum());
			hang.add(books.get(i).getUnit());
			hang.add(books.get(i).getPrice());
			hang.add(books.get(i).getTprice());
 
			rowData.add(hang);
		}
 
		jt = new JTable(rowData, columnNames);
 
		jsp = new JScrollPane(jt);
		this.add(jsp);
	}
}
