package com.ash.airline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main2 {

	static void calculateShortestPath(Scanner in) {

		int source = in.nextInt();
		int destination = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();

		// General idea is construct a graph, then use Dijkstra's algo to
		// compute shortest path
		Graph graph = new Graph();
		for (int i = 0; i < n; i++) {
			String mi = in.next();
			int rim = in.nextInt();
			int tia = in.nextInt();
			int tib = in.nextInt();
			graph.addAirport(i, mi, rim, tia, tib);

		}

		for (int i = 0; i < m; i++) {
			int routeSource = in.nextInt();
			int routeDestination = in.nextInt();
			int cost = in.nextInt();
			graph.addRoute(routeSource, routeDestination, cost);
		}

		int timeTaken = graph.getMinimumTimeTaken(source, destination);
		System.out.println(timeTaken);

		List<Integer> airports = graph.getMinimumAirports(source, destination);
		for (Integer airportId : airports) {
			System.out.print(airportId + " ");
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		calculateShortestPath(in);

	}

	private static class Graph {
		private List<Airport> airports;
		private List<Route> routes;

		public void addRoute(int source, int destination, int time) {
			routes.add(new Route(source, destination, time));
		}

		public void addAirport(int airportId, String mi, int rim, int tia, int tib) {
			airports.add(new Airport(airportId, mi, rim, tia, tib));
		}

		public List<Integer> getMinimumAirports(int source, int destination) {
			// TODO add comparator so routes are ordered by shortest first
			NavigableSet<Route> routesToCheck = new TreeSet<Route>();

			// Go through each route from the source destination and select the
			// lowest cost, then keep recursively comparing the routes for the
			// shortest overall route
			for (Route r : routes) {
				if (r.getSource() == source) {
					routesToCheck.add(r);
				}
			}
			return findShortestPath(routesToCheck);
		}

		private List<Integer> findShortestPath(NavigableSet<Route> routesToCheck) {
			while (!routesToCheck.isEmpty()) {
				Route shortestRoute = routesToCheck.pollFirst();
				//TODO implement Dijkstra

			}
			return null;
		}

		public int getMinimumTimeTaken(int source, int destination) {
			// TODO get shortest route then return total time
			return 0;
		}

	}

	private static class Route implements Comparable<Route>{

		private int source;
		private int destination;
		private int time;

		public Route(int source, int destination, int time) {
			this.source = source;
			this.destination = destination;
			this.time = time;
		}

		public int getTime() {
			return time;
		}

		public int getDestination() {
			return destination;
		}

		public int getSource() {
			return source;
		}

		@Override
		public String toString() {
			return source + " " + destination + " " + time;
		}

		public int compareTo(Route o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}
