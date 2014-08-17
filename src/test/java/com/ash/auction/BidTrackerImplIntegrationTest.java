package com.ash.auction;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;
import com.ash.auction.store.InMemoryBidStoreImpl;

@RunWith(MockitoJUnitRunner.class)
public class BidTrackerImplIntegrationTest {

	private User user1 = new User("ash");
	private User user2 = new User("bob");
	private User user3 = new User("jim");

	private Item item = new Item(1, "item1");

	private InMemoryBidStoreImpl store = new InMemoryBidStoreImpl();
	private BidTrackerImpl testObj = new BidTrackerImpl();

	@Before
	public void setup() {
		testObj.setStore(store);
	}

	@Test
	public void multiThreadedTest() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<BidThread> threads = new ArrayList<BidThread>();

		threads.add(new BidThread(testObj, user1, item, 7d, 10));
		threads.add(new BidThread(testObj, user2, item, 3d, 10));
		threads.add(new BidThread(testObj, user3, item, 5d, 10));

		executorService.invokeAll(threads);

		Set<Bid> bids = testObj.getAllBids(item);
		assertEquals(30, bids.size());
		Bid winningBid = testObj.getWinningBid(item);
		assertEquals(user1, winningBid.getUser());
		assertEquals(new Double(16), winningBid.getAmount());

	}

	private class BidThread implements Callable<Boolean> {

		private BidTracker bidTracker;
		private User user;
		private Item item;
		private Double startingBid;
		private Integer numberOfBids;

		public BidThread(BidTracker bidTracker, User user, Item item, Double startingBid, Integer numberOfBids) {
			super();
			this.bidTracker = bidTracker;
			this.user = user;
			this.item = item;
			this.startingBid = startingBid;
			this.numberOfBids = numberOfBids;
		}

		public Boolean call() throws Exception {
			for (int i = 0; i < numberOfBids; i++) {
				bidTracker.bid(user, startingBid + i, item);
			}
			return true;
		}

	}

}
