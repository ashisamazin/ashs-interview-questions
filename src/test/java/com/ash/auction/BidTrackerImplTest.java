package com.ash.auction;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ash.auction.data.Bid;
import com.ash.auction.data.Item;
import com.ash.auction.data.User;
import com.ash.auction.store.BidStore;

@RunWith(MockitoJUnitRunner.class)
public class BidTrackerImplTest {

	private User user1 = new User("ash");

	private Item item1 = new Item(1, "item1");
	private Item item3 = new Item(3, "item3");

	@Mock
	private BidStore store;
	@InjectMocks
	private BidTracker testObj = new BidTrackerImpl();

	@Test
	public void testBid() {
		testObj.bid(user1, 12d, item1);

		verify(store).bid(user1, 12d, item1);
	}

	@Test
	public void testGetWinningBid() {
		Bid expectedBid = mock(Bid.class);
		when(store.getWinningBid(item1)).thenReturn(expectedBid);

		Bid result = testObj.getWinningBid(item1);

		assertEquals(expectedBid, result);
	}

	@Test
	public void testGetAllBids() {
		Bid bid1 = mock(Bid.class);
		Bid bid2 = mock(Bid.class);
		Set<Bid> expectedBids = new HashSet<Bid>(Arrays.asList(bid1, bid2));
		when(store.getAllBids(item1)).thenReturn(expectedBids);

		Set<Bid> result = testObj.getAllBids(item1);

		assertEquals(expectedBids, result);
	}

	@Test
	public void testGetAllItemsUserHasBidOn() {
		Set<Item> expectedItems = new HashSet<Item>(Arrays.asList(item1, item3));
		when(store.getAllItemsUserHasBidOn(user1)).thenReturn(expectedItems);

		Set<Item> result = testObj.getAllItemsUserHasBidOn(user1);

		assertEquals(expectedItems, result);
	}

}
