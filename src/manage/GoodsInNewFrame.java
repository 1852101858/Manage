package manage;

import dataEditor.Goods;
import dataEditor.GoodsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class GoodsInNewFrame extends JPanel implements ActionListener{

    private JButton intoBtn,updateBtn;
    private JLabel idLabel,nameLabel,numLabel,priceLabel,locationLabel;
    private JTextField idJTextField,nameJTextField,numJTextField,locationJTextField,priceJTextField;
    private String goodsIdText,goodsNameText,goodsLocationText,goodsNumText,goodsPriceText;
    private String name1,location1,date;
    private Float num1,price1;
    private GoodsEditor getGoods;

    public GoodsInNewFrame() {
        getGoods = new GoodsEditor();
        intoBtn = new JButton("入库新商品");
        intoBtn.addActionListener(this);
        intoBtn.setActionCommand("inGoods");
        idLabel = new JLabel("商品编号");
        nameLabel = new JLabel("商品名称");
        locationLabel= new JLabel("商品产地");
        numLabel = new JLabel("商品数量");
        priceLabel = new JLabel("商品价格");
        idJTextField = new JTextField(12);
        nameJTextField = new JTextField(12);
        locationJTextField = new JTextField(12);
        numJTextField = new JTextField(12);
        priceJTextField = new JTextField(12);
        this.setLayout(new GridLayout(6, 2, 0, 0));
        this.add(idLabel);
        this.add(idJTextField);
        this.add(nameLabel);
        this.add(nameJTextField);
        this.add(locationLabel);
        this.add(locationJTextField);
        this.add(numLabel);
        this.add(numJTextField);
        this.add(priceLabel);
        this.add(priceJTextField);
        this.add(intoBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("inGoods")) {
            addGoods();
        }
    }

    private void addGoods() {
        try {
            goodsIdText = idJTextField.getText().trim().toString();
            int id;
            goodsNameText = nameJTextField.getText().trim().toString();
            goodsLocationText = locationJTextField.getText().trim().toString();
            goodsNumText = numJTextField.getText().trim().toString();
            goodsPriceText = priceJTextField.getText().trim().toString();
            if (goodsNameText.equals("")||goodsLocationText.equals("")||goodsNumText.equals("")||goodsPriceText.equals("")) {
                JOptionPane.showMessageDialog(this, "商品属性不能为空");
            } else if(!goodsIdText.equals("")) {//自定义id
                id = Integer.parseInt(idJTextField.getText());
                if (getGoods.getGoodsId(id) != null) {
                    JOptionPane.showMessageDialog(this, "商品编号重复");}
          else
                name1 = goodsNameText;
                location1 = goodsLocationText;
                num1 = Float.parseFloat(goodsNumText);
                price1 = Float.parseFloat(goodsPriceText);
                Date datenow=new Date();
                SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date1=dateFormat_min.format(datenow)+"~in"+num1+"/～"+num1+"/";
                getGoods.addGoods(new Goods(id, name1, location1, num1, price1,date1));
                JOptionPane.showMessageDialog(this, "商品增加成功");
            }
            else if (goodsIdText.equals("")) {//不输入id则自动分配
                ArrayList<Goods> allgoods = new GoodsEditor().getGoodsList();
                id =allgoods.size() + 1;
                name1 = goodsNameText;
                location1 = goodsLocationText;
                num1 = Float.parseFloat(goodsNumText);
                price1 = Float.parseFloat(goodsPriceText);
                Date datenow=new Date();
                SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date1=dateFormat_min.format(datenow)+"~in"+num1+"/～"+num1+"/";
                getGoods.addGoods(new Goods(id, name1, location1, num1, price1,date1));
                JOptionPane.showMessageDialog(this, "商品增加成功");
            }}
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "输入正确商品属性");
            e.printStackTrace();
        }
    }

}