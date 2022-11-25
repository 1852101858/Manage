package manage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataEditor.*;

public class GoodsChangeFrame extends JPanel implements ActionListener{

    private JButton intoBtn, outBtn;

    private JLabel idLabel,nameLabel,numLabel;

    private JTextField idJTextField,nameJTextField,numJTextField;

    private String goodsIdText;
    private String goodsNameText;
    private String goodsNumText;

    private String name1;
    private Float num1;


    private GoodsEditor getGoods;

    public GoodsChangeFrame() {
        getGoods = new GoodsEditor();

        intoBtn = new JButton("入库");
        intoBtn.addActionListener(this);
        intoBtn.setActionCommand("addGoods");
        outBtn = new JButton("出库");
        outBtn.addActionListener(this);
        outBtn.setActionCommand("deleteGoods");

        idLabel = new JLabel("商品编号");
        nameLabel = new JLabel("商品名称");
        numLabel = new JLabel("操作数量");


        idJTextField = new JTextField(12);
        nameJTextField = new JTextField(12);
        numJTextField = new JTextField(11);
        this.setLayout(new GridLayout(9, 2, 2, 2));

        this.add(idLabel);
        this.add(idJTextField);
        this.add(nameLabel);
        this.add(nameJTextField);
        this.add(numLabel);
        this.add(numJTextField);

        this.add(intoBtn);
        this.add(outBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addGoods")) {
            into();
        } else if (e.getActionCommand().equals("deleteGoods")) {
            deleteGoods();
        }
    }




    private void deleteGoods() {
        goodsIdText = idJTextField.getText().trim().toString();
        goodsNameText = nameJTextField.getText().trim().toString();
        goodsNumText = numJTextField.getText().trim().toString();
        Goods goods = getGoods.getGoodsId(goodsIdText);
        if (goodsIdText.equals("")) {
            JOptionPane.showMessageDialog(this, "商品编号不能为空");
        } else if (goods != null) {
            try {
                float a = Float.parseFloat(goodsNumText);
                float b = goods.getNum();
                name1 = goodsNameText;
                String location1 = goods.getLocation();
                if (goods.getNum() - Float.parseFloat(goodsNumText) >= 0){
                    num1 = a-b;
                }
                String unit1 = goods.getLocation();
                float price1 = goods.getPrice();

                getGoods.updateGoods(new Goods(goodsIdText, name1,location1, num1,unit1, price1));
                JOptionPane.showMessageDialog(this, "商品出库成功");


            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "商品入库异常");
            }
        } else {
            JOptionPane.showMessageDialog(this, "商品不存在");
        } }


    private void into() {
        goodsIdText = idJTextField.getText().trim().toString();
        goodsNameText = nameJTextField.getText().trim().toString();
        goodsNumText = numJTextField.getText().trim().toString();
        Goods goods = getGoods.getGoodsId(goodsIdText);
        if (goodsIdText.equals("")) {
            JOptionPane.showMessageDialog(this, "商品编号不能为空");
        } else if (goods != null) {
            try {
                float a = Float.parseFloat(goodsNumText);
                float b = goods.getNum();
                name1 = goodsNameText;
                String location1 = goods.getLocation();
                num1 = a+b;
                String unit1 = goods.getLocation();
                float price1 = goods.getPrice();

                getGoods.updateGoods(new Goods(goodsIdText, name1,location1, num1,unit1, price1));
                JOptionPane.showMessageDialog(this, "商品入库成功");


            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "商品入库异常");
            }
        } else {
            JOptionPane.showMessageDialog(this, "商品不存在");
        }

    }
}
