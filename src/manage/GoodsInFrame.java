package manage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataEditor.*;

public class GoodsInFrame extends JPanel implements ActionListener{
    private JButton updateBtn;
    private JLabel idLabel,nameLabel,numLabel,num1Label;
    private JTextField idJTextField,nameJTextField,numJTextField,num1JTextField,locationJTextField,priceJTextField;
    private GoodsEditor getGoods;
    public GoodsInFrame(int id,String name,String location,float num,float price,String date) {
        getGoods = new GoodsEditor();
        updateBtn = new JButton("入库原有商品");
        updateBtn.addActionListener(this);
        updateBtn.setActionCommand("updateGoods");
        idLabel = new JLabel("商品编号");
        nameLabel = new JLabel("商品名称");
        numLabel = new JLabel("原有库存");
        num1Label = new JLabel("入库数量");
        idJTextField = new JTextField(12);
        nameJTextField = new JTextField(12);
        locationJTextField = new JTextField(12);
        numJTextField = new JTextField(12);
        num1JTextField = new JTextField(12);
        priceJTextField = new JTextField(12);
        this.setLayout(new GridLayout(9, 2, 2, 2));
        this.add(idLabel);
        this.add(idJTextField);
        this.add(nameLabel);
        this.add(nameJTextField);
        this.add(numLabel);
        this.add(numJTextField);
        this.add(num1Label);
        this.add(num1JTextField);
        this.add(updateBtn);
        idJTextField.setText(id+"");
        nameJTextField.setText(name);
        locationJTextField.setText(location);
        numJTextField.setText(num+"");
        priceJTextField.setText(price + "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("updateGoods")) {
            into();}
    }

   private void into () {
            try {
                int id1 = Integer.parseInt(idJTextField.getText().trim());
                String name1 = nameJTextField.getText().trim().toString();
                String location1 = locationJTextField.getText().trim().toString();
                float num = Float.parseFloat(numJTextField.getText().trim());
                float num1 = Float.parseFloat(num1JTextField.getText().trim());
                float price1 = Float.parseFloat(priceJTextField.getText().trim());
                float num2 = num1+num;
                Goods goods = getGoods.getGoodsId(id1);
                Date datenow=new Date();
                SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String d=dateFormat_min.format(datenow)+"~in"+num1+"/～"+num2+"/";
                String date = goods.getDate();
                String date1=date.concat(d);
                    getGoods.updateGoods(new Goods(id1, name1, location1, num2, price1,date1));
                numJTextField.setText(num2+"");
                    JOptionPane.showMessageDialog(this, "商品入库成功");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "输入入库数量");
                e.printStackTrace();
            }
        }}
