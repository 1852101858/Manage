package manage;

import dataEditor.Goods;
import dataEditor.GoodsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 
public class GoodsCheckFrame extends JPanel implements ActionListener {
 
	private JButton checkBtn,checkdataBtn,addBtn;
 
	private JLabel idLabel,nameLabel,locationLabel,numLabel,unitLabel,priceLabel,tpriceLabel;
 
	private JTextField idJTextField,nameJTextField,locationJTextField,numJTextField,unitJTextField,priceJTextField,tpriceJTextField;
 
	private String goodsIdText;
	private String goodsNameText;
	private String goodsLocationText;
	private String goodsNumText;
	private String goodsUnitText;
	private String goodsPriceText;
	private String goodsTpriceText;
 
	private String name1;
	private String location1;
	private Float num1;
	private String unit1;
	private Float price1;
	private Float tprice1;
 
	private GoodsEditor getGoods;

	public GoodsCheckFrame() {
		getGoods = new GoodsEditor();
		checkBtn = new JButton("查询商品");
		checkBtn.addActionListener(this);
		checkBtn.setActionCommand("checkGoods");
		checkdataBtn = new JButton("查询出入库日期");
		checkdataBtn.addActionListener(this);
		checkdataBtn.setActionCommand("checkData");

 
		idLabel = new JLabel("商品编号");
		nameLabel = new JLabel("商品名称");
		locationLabel= new JLabel("商品产地");
		numLabel = new JLabel("商品数量");
		unitLabel = new JLabel("商品单位");
		priceLabel = new JLabel("商品价格");
		tpriceLabel = new JLabel("商品总价");
		
 
		idJTextField = new JTextField(12);
		nameJTextField = new JTextField(12);
		locationJTextField = new JTextField(12);
		numJTextField = new JTextField(12);
		unitJTextField = new JTextField(12);
		priceJTextField = new JTextField(12);
		tpriceJTextField = new JTextField(12);
		this.setLayout(new GridLayout(9, 2, 2, 2));
 
		this.add(idLabel);
		this.add(idJTextField);
		this.add(nameLabel);
		this.add(nameJTextField);
		this.add(locationLabel);
		this.add(locationJTextField);
		this.add(numLabel);
		this.add(numJTextField);
		this.add(unitLabel);
		this.add(unitJTextField);
		this.add(priceLabel);
		this.add(priceJTextField);
		this.add(tpriceLabel);
		this.add(tpriceJTextField);


		this.add(checkBtn);
		this.add(checkdataBtn);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("checkGoods")) {
			findGoods();
		} else if (e.getActionCommand().equals("checkData")) {
				addGoods();
		}
	}

	 
	private void findGoods() {
		goodsIdText = idJTextField.getText().trim().toString();
		Goods goods = getGoods.getGoodsId(goodsIdText);
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (goods != null) { 
			try {

				nameJTextField.setText(goods.getName()); 
				locationJTextField.setText(goods.getLocation());
				numJTextField.setText(goods.getNum() + ""); 
				unitJTextField.setText(goods.getUnit());
				priceJTextField.setText(goods.getPrice() + ""); 
				tpriceJTextField.setText(goods.getTprice() + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "商品查询异常");
			}
		} else {
			JOptionPane.showMessageDialog(this, "商品不存在");
		}

	}



	 
	private void addGoods() {
		goodsIdText = idJTextField.getText().trim().toString();
		goodsNameText = nameJTextField.getText().trim().toString();
		goodsLocationText = locationJTextField.getText().trim().toString();
		goodsNumText = numJTextField.getText().trim().toString();
		goodsUnitText = unitJTextField.getText().trim().toString();
		goodsPriceText = priceJTextField.getText().trim().toString();
		goodsTpriceText = tpriceJTextField.getText().trim().toString();
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (goodsNameText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品名称不能为空");
		} else if (goodsNumText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品数量不能为空");
		} else if (goodsPriceText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品价格不能为空");
		} else {
 
			if (getGoods.getGoodsId(goodsIdText) != null) { 
				JOptionPane.showMessageDialog(this, "商品编号重复");
			} else {
				try {
					name1 =  goodsNumText;
					location1=  goodsLocationText;
					num1 =  Float.parseFloat(goodsNumText);
					unit1=  goodsUnitText;
					price1 = Float.parseFloat(goodsPriceText);
					tprice1 =Float.parseFloat(goodsTpriceText);
					
					getGoods.addGoods(new Goods(goodsIdText, name1,location1, num1,unit1, price1,tprice1));
					JOptionPane.showMessageDialog(this, "商品增加成功");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "输入正确的商品数量和价格");
					e.printStackTrace();
				}
			}
		}

	}
}
