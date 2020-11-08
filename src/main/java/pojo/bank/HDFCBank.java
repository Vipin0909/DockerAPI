package pojo.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class HDFCBank {

	private String bank;
	private Branch branch;
	private ArrayList<HashMap<String,Object>> finance;
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branchmap) {
		this.branch = branchmap;
	}
	public ArrayList<HashMap<String, Object>> getFinance() {
		return finance;
	}
	public void setFinance(ArrayList<HashMap<String, Object>> finance) {
		this.finance = finance;
	}
	
	
	
}
