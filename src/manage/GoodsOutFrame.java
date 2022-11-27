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

public class GoodsOutFrame extends JPanel implements ActionListener{
    private JButton outBtn;
    private JLabel idLabel,nameLabel,numLabel;
    private JTextField idJTextField,nameJTextField,numJTextField;
    private String goodsIdText;
    private String goodsNameText;
    private String goodsNumText;
    private String name1,date;
    private Float num1;
    private GoodsEditor getGoods;

    public GoodsOutFrame() {
        getGoods = new GoodsEditor();
        outBtn = new JButton("出库");
        outBtn.addActionListener(this);
        outBtn.setActionCommand("outGoods");
        idLabel = new JLabel("商品编号");
        nameLabel = new JLabel("商品名称");
        numLabel = new JLabel("操作数量");
        idJTextField = new JTextField(12);
        nameJTextField = new JTextField(12);
        numJTextField = new JTextField(12);
        this.setLayout(new GridLayout(4, 2, 2, 2));
        this.add(idLabel);
        this.add(idJTextField);
        this.add(nameLabel);
        this.add(nameJTextField);
        this.add(numLabel);
        this.add(numJTextField);
        this.add(outBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("outGoods")) {
            outGoods();
        }
    }

        private void outGoods() {
            try {
                goodsIdText = idJTextField.getText().trim().toString();
                int id = Integer.parseInt(idJTextField.getText());
                goodsNameText = nameJTextField.getText().trim().toString();
                goodsNumText = numJTextField.getText().trim().toString();
                Goods goods = getGoods.getGoodsId(id);
                if (goodsIdText.equals("") || goodsNameText.equals("")) {
                    JOptionPane.showMessageDialog(this, "商品编号或名称不能为空");
                } else if (goods == null) {
                    JOptionPane.showMessageDialog(this, "商品不存在");
                } else if (!Objects.equals(goods.getName(), goodsNameText)) {
                    JOptionPane.showMessageDialog(this, "商品编号与名称不匹配，请检查");
                } else {
                    float a = Float.parseFloat(goodsNumText);
                    float b = goods.getNum();
                    if (goods.getNum() - Float.parseFloat(goodsNumText) >= 0){
                        name1 = goodsNameText;
                        String location1 = goods.getLocation();
                        num1 = b-a;
                        float price1 = goods.getPrice();

                        date=goods.getDate();
                        Date datenow=new Date();
                        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                        String d=dateFormat_min.format(datenow)+"~out"+a+"/";
                        String date1=date.concat(d);

                        getGoods.updateGoods(new Goods(id, name1,location1, num1, price1,date1));
                        JOptionPane.showMessageDialog(this, "商品出库成功");
                    }else { JOptionPane.showMessageDialog(this, "商品库存不足");}
                } }catch (Exception e) {
                JOptionPane.showMessageDialog(this, "输入正确商品属性");
                e.printStackTrace();
            }
        }
    }
