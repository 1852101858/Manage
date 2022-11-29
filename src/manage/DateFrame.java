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

    public DateFrame(String date) {
        String line=date;
        String[] words = line.split("/");
        columnNames = new Vector();
        columnNames.add("操作日期");
        columnNames.add("操作类型");
        columnNames.add("操作数量");
        columnNames.add("剩余库存");
        rowData = new Vector();
        for (int i = 0; i < words.length; i+=4) {

            Vector hang = new Vector();
            hang.add(words[i]);
            hang.add(words[i+1]);
            hang.add(words[i+2]);
            hang.add(words[i+3]);
            rowData.add(hang);

        }
        jt = new JTable(rowData, columnNames);
        jsp = new JScrollPane(jt);
        this.add(jsp);
    }








    public void DatePanel(String date) {

}}
