package com.ash.airline;

public class Route {

	private int source;
	private int destination;
	private Float cost;

	public Route(int source, int destination, float cost) {
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}

	public Float getCost() {
		return cost;
	}

	public int getDestination() {
		return destination;
	}

	public int getSource() {
		return source;
	}

	@Override
	public String toString() {
		return source + " " + destination + " " + cost;
	}

}
