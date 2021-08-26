package com.jly.bean;

public class Product {
	private int p_id, p_inventory, p_s_id, p_sub_id;
	private String p_name, p_local, p_intro;
	private double p_price;
	private char p_status;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_inventory() {
		return p_inventory;
	}
	
	public void setP_inventory(int p_inventory) {
			this.p_inventory = p_inventory;
		}

		public int getP_s_id() {
			return p_s_id;
		}

		public void setP_s_id(int p_s_id) {
			this.p_s_id = p_s_id;
		}

		public int getP_sub_id() {
			return p_sub_id;
		}

		public void setP_sub_id(int p_sub_id) {
			this.p_sub_id = p_sub_id;
		}

		public String getP_name() {
			return p_name;
		}

		public void setP_name(String p_name) {
			this.p_name = p_name;
		}

		public String getP_local() {
			return p_local;
		}

		public void setP_local(String p_local) {
			this.p_local = p_local;
		}

	
		public String getP_intro() {
			return p_intro;
		}

		public void setP_intro(String p_intro) {
			this.p_intro = p_intro;
		}

		public double getP_price() {
			return p_price;
		}

		public void setP_price(double p_price) {
			this.p_price = p_price;
		}

		public char getP_status() {
			return p_status;
		}

		public void setP_status(char p_status) {
			this.p_status = p_status;
		}

	}

