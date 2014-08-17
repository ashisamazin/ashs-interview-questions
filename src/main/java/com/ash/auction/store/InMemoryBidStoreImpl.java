package com.ash.auction.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;

/**
 * Simple in-memory implementation of the bid store.
 */
public class InMemoryBidStoreImpl implements BidStore {

	private Map<Item, Set<Bid>> itemMap = new HashMap<Item, Set<Bid>>();

	public void bid(User user, Double amount, Item item) {
		Set<Bid> existingBids = itemMap.get(item);
		if (existingBids == null) {
			existingBids = new TreeSet<Bid>();
			itemMap.put(item, existingBids);
		}
		existingBids.add(new Bid(existingBids.size(), System.currentTimeMillis(), user, amount));
	}

	public Bid getWinningBid(Item item) {
		Set<Bid> bids = itemMap.get(item);
		if (bids != null && bids.size() > 0) {
			return bids.iterator().next();
		}
		return null;
	}

	public Set<Bid> getAllBids(Item item) {
		Set<Bid> bids = itemMap.get(item);
		if (bids != null) {
			// New set created to ensure immutabiity
			return new TreeSet<Bid>(bids);
		}
		return null;
	}

	public Set<Item> getAllItemsUserHasBidOn(User user) {
		Set<Item> items = new HashSet<Item>();
		for (Entry<Item, Set<Bid>> entry : itemMap.entrySet()) {
			Set<Bid> bids = entry.getValue();
			if (isUserInBids(bids, user)) {
				items.add(entry.getKey());
			}
		}
		return items;
	}

	private boolean isUserInBids(Set<Bid> bids, User user) {
		for (Bid bid : bids) {
			if (bid.getUser().equals(user)) {
				return true;
			}
		}
		return false;
	}

}
