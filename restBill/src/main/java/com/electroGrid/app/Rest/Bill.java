package com.electroGrid.app.Rest;
import javax.persistence.*;
@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long BillID;
	@Column
	private String CusID;
	@Column
	private long noOfWatts;
	@Column
	private String amount;
	@Column
	private long total;
	@Column
	public long getBillID() {
		return BillID;
	}
	public void setBillID(long billID) {
		BillID = billID;
	}
	public String getCusID() {
		return CusID;
	}
	public void setCusID(String cusID) {
		CusID = cusID;
	}
	public long getNoOfWatts() {
		return noOfWatts;
	}
	public void setNoOfWatts(long noOfWatts) {
		this.noOfWatts = noOfWatts;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
