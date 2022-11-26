package manage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataEditor.*;

 public class GoodsEditorFrame extends JPanel implements ActionListener {
	private JButton addBtn, deleteBtn, updateBtn, findBtn;
	private JLabel idLabel,nameLabel,locationLabel,numLabel,priceLabel,tpriceLabel;
	private JTextField idJTextField,nameJTextField,locationJTextField,numJTextField,priceJTextField,tpriceJTextField;
	private String goodsIdText;
	private String goodsNameText;
	private String goodsLocationText;
	private String goodsNumText;
	private String goodsPriceText;

	private String name1;
	private String location1;
	private Float num1;
	private Float price1;
	private GoodsEditor getGoods;

	public GoodsEditorFrame() {
		getGoods = new GoodsEditor();
		addBtn = new JButton("增加商品");
		addBtn.addActionListener(this); 
		addBtn.setActionCommand("addGoods");
		deleteBtn = new JButton("删除商品");
		deleteBtn.addActionListener(this); 
		deleteBtn.setActionCommand("deleteGoods");
		updateBtn = new JButton("修改商品");
		updateBtn.addActionListener(this); 
		updateBtn.setActionCommand("updateGoods");
		findBtn = new JButton("查询商品");
		findBtn.addActionListener(this); 
		findBtn.setActionCommand("findGoods");
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
		this.setLayout(new GridLayout(9, 2, 2, 2));
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
		this.add(addBtn);
		this.add(deleteBtn);
		this.add(updateBtn);
		this.add(findBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("addGoods")) { 
			addGoods();
		} else if (e.getActionCommand().equals("deleteGoods")) { 
			deleteGoods();
		} else if (e.getActionCommand().equals("updateGoods")) { 
			updateGoods();
		} else if (e.getActionCommand().equals("findGoods")) { 
			findGoods();
		}
	}

	 
	private void findGoods() {
		try {
		goodsIdText = idJTextField.getText().trim().toString();
		int id = Integer.parseInt(idJTextField.getText());
		Goods goods = getGoods.getGoodsId(id);
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (goods == null) {
			JOptionPane.showMessageDialog(this, "商品不存在");
		} else {
			idJTextField.setText(goods.getId()+ "");
			nameJTextField.setText(goods.getName());
			locationJTextField.setText(goods.getLocation());
			numJTextField.setText(goods.getNum() + "");
			priceJTextField.setText(goods.getPrice() + "");
			tpriceJTextField.setText(goods.getTprice() + "");
		}
	} catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "输入正确商品属性");
		 e.printStackTrace();
	 }}

	 
	private void updateGoods() { //根据id修改，id不可编辑修改
		try {
			goodsIdText = idJTextField.getText().trim().toString();
		int id = Integer.parseInt(idJTextField.getText());
		goodsNameText = nameJTextField.getText().trim().toString();
		goodsLocationText = locationJTextField.getText().trim().toString();
		goodsNumText = numJTextField.getText().trim().toString();
		goodsPriceText = priceJTextField.getText().trim().toString();
		if (goodsIdText.equals("")||goodsNameText.equals("")||goodsLocationText.equals("")||goodsNumText.equals("")||goodsPriceText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品属性不能为空");
		}  else {
			if (getGoods.getGoodsId(id) == null) {
				JOptionPane.showMessageDialog(this, "商品不存在");
			} else {

					name1 =  goodsNumText;
					location1=goodsLocationText;
					num1 =  Float.parseFloat(goodsNumText);
					price1 = Float.parseFloat(goodsPriceText);
					getGoods.updateGoods(new Goods(id, name1,location1, num1, price1));
					JOptionPane.showMessageDialog(this, "商品修改成功");
				}}} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "输入正确商品属性");
					e.printStackTrace();
				}
	}

	 
	private void deleteGoods() {
		try {
		goodsIdText = idJTextField.getText().trim().toString();
		int id = Integer.parseInt(idJTextField.getText());
		if (goodsIdText.equals("")) {
			JOptionPane.showMessageDialog(this, "商品编号不能为空");
		} else if (getGoods.getGoodsId(id) != null) {
				getGoods.deleteGoodsId(goodsIdText);
				JOptionPane.showMessageDialog(this, "商品删除成功");
		} else {
			JOptionPane.showMessageDialog(this, "商品不存在");
		}
	}catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "输入正确商品属性");
		 e.printStackTrace();
	 }}

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
					 getGoods.addGoods(new Goods(id, name1, location1, num1, price1));
					 JOptionPane.showMessageDialog(this, "商品增加成功");
				 }
		   else if (goodsIdText.equals("")) {//不输入id则自动分配
			  ArrayList<Goods> allgoods = new GoodsEditor().getGoodsList();
			  id =allgoods.size() + 1;
						  name1 = goodsNameText;
						  location1 = goodsLocationText;
						  num1 = Float.parseFloat(goodsNumText);
						  price1 = Float.parseFloat(goodsPriceText);
						  getGoods.addGoods(new Goods(id, name1, location1, num1, price1));
						  JOptionPane.showMessageDialog(this, "商品增加成功");
				  }}
			  catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "输入正确商品属性");
		 e.printStackTrace();
	 }
}}
