package manage;

import dataEditor.Goods;
import dataEditor.GoodsEditor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

public class DateFrame extends JPanel{
    Vector rowData, columnNames;
    JTable jt = null;
    JScrollPane jsp = null;
    public void DatePanel() {
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

        jt = new JTable(rowData, columnNames);
        jsp = new JScrollPane(jt);
        this.add(jsp);
    }
}
