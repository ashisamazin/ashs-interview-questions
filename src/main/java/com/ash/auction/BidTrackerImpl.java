package com.ash.auction;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;
import com.ash.auction.store.BidStore;

//Multi-threaded implementation of the BidTracker interface that calls off to the BidStore class which retrieves 
//the data from the persistence store
public class BidTrackerImpl implements BidTracker {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	//Would normally spring configure this
	private BidStore store;

	public void bid(User user, Double amount, Item item) {
		try {
			lock.writeLock().lock();
			store.bid(user, amount, item);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Bid getWinningBid(Item item) {
		try {
			lock.readLock().lock();
			return store.getWinningBid(item);
		} finally {
			lock.readLock().unlock();
		}
	}

	public Set<Bid> getAllBids(Item item) {
		try {
			lock.readLock().lock();
			return store.getAllBids(item);
		} finally {
			lock.readLock().unlock();
		}
	}

	public Set<Item> getAllItemsUserHasBidOn(User user) {
		try {
			lock.readLock().lock();
			return store.getAllItemsUserHasBidOn(user);
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public void setStore(BidStore store) {
		this.store = store;
	}
}
