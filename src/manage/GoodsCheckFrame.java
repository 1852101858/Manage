package manage;

import dataEditor.Goods;
import dataEditor.GoodsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static manage.GoodsFrame.container;


public class GoodsCheckFrame extends JPanel implements ActionListener {
 
	private JButton checkBtn,checkdataBtn;
 
	private JLabel idLabel,nameLabel,locationLabel,numLabel,priceLabel,tpriceLabel;
 
	private JTextField idJTextField,nameJTextField,locationJTextField,numJTextField,priceJTextField,tpriceJTextField;
 
	private String goodsIdText;
	private String goodsNameText;
	private String goodsLocationText;
	private String goodsNumText;
	private String goodsPriceText;
	private String goodsTpriceText;
	public static Container container;
	public static CardLayout cardlayout;
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
		priceLabel = new JLabel("商品价格");
		tpriceLabel = new JLabel("商品总价");
		idJTextField = new JTextField(12);
		nameJTextField = new JTextField(12);
		locationJTextField = new JTextField(12);
		numJTextField = new JTextField(12);
		priceJTextField = new JTextField(12);
		tpriceJTextField = new JTextField(12);
		this.setLayout(new GridLayout(7, 2, 2, 2));
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
			checkData();
		}
	}

	 
	private void findGoods() {
		try {
		goodsIdText = idJTextField.getText().trim().toString();
		int id = Integer.parseInt(idJTextField.getText());
		Goods goods = getGoods.getGoodsId(id);
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (goods != null) {
				idJTextField.setText(goods.getId()+ "");
				nameJTextField.setText(goods.getName());
				locationJTextField.setText(goods.getLocation());
				numJTextField.setText(goods.getNum() + "");
				priceJTextField.setText(goods.getPrice() + ""); 
				tpriceJTextField.setText(goods.getTprice() + "");
		} else {
			JOptionPane.showMessageDialog(this, "商品不存在");
		}

	}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "输入正确商品属性");
			e.printStackTrace();
		}
	}

	private void checkData() {
		try {
		goodsIdText = idJTextField.getText().trim().toString();
		goodsNameText = nameJTextField.getText().trim().toString();
		goodsLocationText = locationJTextField.getText().trim().toString();
		goodsNumText = numJTextField.getText().trim().toString();
		goodsPriceText = priceJTextField.getText().trim().toString();
		goodsTpriceText = tpriceJTextField.getText().trim().toString();
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (goodsNameText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品名称不能为空");
		}  else {

			Goods goods = getGoods.getGoodsId(Integer.parseInt(goodsIdText));
			String date = goods.getDate();
			DateFrame DateFrame = new DateFrame(date);
			container.add(DateFrame, "DateFrame");
			cardlayout.show(container, "DateFrame");

			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "输入正确商品属性");
			e.printStackTrace();
		}

	}}

