package com.ash.auction;

import java.util.Set;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;

public interface BidTracker {

	/**
	 * Record a user's bid on an item.
	 */
	public void bid(User user, Double amount, Item item);

	/**
	 * Get the current winning bid for an item
	 */
	public Bid getWinningBid(Item item);

	/**
	 * Get all the bids for an item
	 */
	public Set<Bid> getAllBids(Item item);

	/**
	 * Get all the items on which a user has bid
	 */
	public Set<Item> getAllItemsUserHasBidOn(User user);

}
