package net.guides.springboot2.springboot2jpacrudexample.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

	private long id;
	private String symbol;
	private String side;
	private BigDecimal stopPrice;
	private BigDecimal price;
	private BigDecimal quantity;
	private Date createDate;
	private Date updateDate;
	private Date dueDate;
	private String status;

	public Order() {

	}

	public Order(String symbol, String side, BigDecimal stopPrice, BigDecimal price, BigDecimal quantity, Date createDate, Date updateDate, Date dueDate, String status) {
		this.symbol = symbol;
		this.side = side;
		this.stopPrice = stopPrice;
		this.price = price;
		this.quantity = quantity;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "symbol", nullable = false)
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name = "side", nullable = false)
	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Column(name = "stop_price", nullable = false)
	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	@Column(name = "price", nullable = false)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@CreatedDate
	@Column(name = "create_date", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@LastModifiedDate
	@Column(name = "update_date", nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date createDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "due_date", nullable = true)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", symbol=" + symbol + ", side=" + side + ", stopPrice=" + stopPrice + ", price=" + price
				+ ", quantity=" + quantity + ", createDate=" + createDate + ", dueDate=" + dueDate + ", status=" + status
				+ "]";
	}
	
}
