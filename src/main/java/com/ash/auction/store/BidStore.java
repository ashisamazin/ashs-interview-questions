package com.ash.auction.store;

import java.util.Set;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;

public interface BidStore {

	public void bid(User user, Double amount, Item item);

	public Bid getWinningBid(Item item);

	public Set<Bid> getAllBids(Item item);

	public Set<Item> getAllItemsUserHasBidOn(User user);
}
