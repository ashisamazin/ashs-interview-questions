package com.ash.auction.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;

public class InMemoryBidStoreImplTest {

	private BidStore testObj = new InMemoryBidStoreImpl();

	private User user1 = new User("ash");
	private User user2 = new User("bob");

	private Item item1 = new Item(1, "item1");
	private Item item2 = new Item(2, "item2");
	private Item item3 = new Item(3, "item3");

	@Test
	public void testGetAllBids() {
		testObj.bid(user1, 12d, item1);
		testObj.bid(user2, 15d, item1);

		Set<Bid> result = testObj.getAllBids(item1);
		assertEquals(2, result.size());
		Iterator<Bid> it = result.iterator();

		Bid bid1 = it.next();
		assertEquals(1, bid1.getId().intValue());
		assertEquals(user2, bid1.getUser());
		assertEquals(new Double(15), bid1.getAmount());

		Bid bid2 = it.next();
		assertEquals(0, bid2.getId().intValue());
		assertEquals(user1, bid2.getUser());
		assertEquals(new Double(12), bid2.getAmount());

	}

	@Test
	public void testSameBidsFromDifferentUsersReturnFirst() {
		testObj.bid(user1, 12d, item1);
		testObj.bid(user2, 12d, item1);

		Set<Bid> result = testObj.getAllBids(item1);
		assertEquals(2, result.size());
		Bid bid = testObj.getWinningBid(item1);
		assertEquals(user1, bid.getUser());
	}

	@Test
	public void testEditingBidsDoesNotEditUnderlyingData() {
		testObj.bid(user1, 12d, item1);

		Set<Bid> result = testObj.getAllBids(item1);
		result.add(new Bid(1, 123l, user2, 213d));

		Set<Bid> newResult = testObj.getAllBids(item1);
		assertEquals(1, newResult.size());
	}

	@Test
	public void testGetWinningBid() {
		testObj.bid(user1, 12d, item1);
		assertEquals(new Double(12), testObj.getWinningBid(item1).getAmount());
		assertEquals(user1, testObj.getWinningBid(item1).getUser());

		testObj.bid(user2, 15d, item1);
		assertEquals(new Double(15), testObj.getWinningBid(item1).getAmount());
		assertEquals(user2, testObj.getWinningBid(item1).getUser());

		testObj.bid(user1, 30d, item1);
		assertEquals(new Double(30), testObj.getWinningBid(item1).getAmount());
		assertEquals(user1, testObj.getWinningBid(item1).getUser());

	}

	@Test
	public void testBidsWhenThereHasBeenNone() {
		assertNull(testObj.getWinningBid(item2));
		assertNull(testObj.getAllBids(item2));
	}

	@Test
	public void testGetAllItemsAUserHasBidOn() {
		testObj.bid(user1, 15d, item1);
		testObj.bid(user1, 30d, item2);
		testObj.bid(user2, 35d, item3);

		Set<Item> result1 = testObj.getAllItemsUserHasBidOn(user1);
		assertEquals(2, result1.size());
		assertTrue(result1.contains(item1));
		assertTrue(result1.contains(item2));

		Set<Item> result2 = testObj.getAllItemsUserHasBidOn(user2);
		assertEquals(1, result2.size());
		assertTrue(result2.contains(item3));
	}
}