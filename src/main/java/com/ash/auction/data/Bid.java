package com.ash.auction.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Bid implements Comparable<Bid> {

	private final Integer id;
	private final Long timestamp;
	private final User user;
	private final Double amount;

	public Bid(Integer id, Long timestamp, User user, Double amount) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.user = user;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public User getUser() {
		return user;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public int compareTo(Bid arg) {
		int result = arg.getAmount().compareTo(amount);
		if(result != 0){
			return result;
		}else{
			return id.compareTo(arg.getId());
		}
		
	}

}
