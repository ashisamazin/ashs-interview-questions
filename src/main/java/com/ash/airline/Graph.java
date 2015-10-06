package com.ash.airline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

	private Set<Integer> cities;
	private List<Route> routes;

	public Graph() {
		this.cities = new HashSet<Integer>();
		this.routes = new ArrayList<Route>();
	}

	public void addRoute(int source, int destination, float cost) {
		routes.add(new Route(source, destination, cost));
	}

	public void addCity(int cityId) {
		cities.add(cityId);

	}

	// Greedy algorithm that won't return the optimum routes. For that we would
	// require a much more complex algorithm for a minimum spanning tree, of
	// which there are many online but I don't have time to implement here.
	public List<Route> getCheapestRoutes() {
		List<Route> cheapestRoutes = new ArrayList<Route>(routes);
		Collections.sort(cheapestRoutes, new Comparator<Route>() {
			public int compare(Route route1, Route route2) {
				return route1.getCost().compareTo(route2.getCost());
			}
		});
		for (int i = cheapestRoutes.size() - 1; i > 0; i--) {
			Route mostExpensiveRoute = cheapestRoutes.remove(i);
			if (!areAllCitiesCovered(cities, cheapestRoutes) || !isGraphComplete(cheapestRoutes)) {
				cheapestRoutes.add(i, mostExpensiveRoute);
			}
		}
		return cheapestRoutes;
	}

	private boolean isGraphComplete(List<Route> cheapestRoutes) {
		List<Route> tmpRoutes = new ArrayList<Route>(cheapestRoutes);
		List<Route> connectedRoutes = new ArrayList<Route>();
		connectedRoutes.add(tmpRoutes.remove(0));

		mainLoop: while (tmpRoutes.size() > 0) {
			for (int i = 0; i < tmpRoutes.size(); i++) {
				Route route1 = tmpRoutes.get(i);
				for (Route route2 : connectedRoutes) {
					if (areRoutesConnected(route1, route2)) {
						// remove route and add to connected routes
						tmpRoutes.remove(route1);
						connectedRoutes.add(route1);
						continue mainLoop;
					}
				}
			}
			return false;
		}
		return true;
	}

	private boolean areRoutesConnected(Route route1, Route route2) {
		return route1.getSource() == route2.getSource() || route1.getSource() == route2.getDestination() || route1.getDestination() == route2.getSource()
				|| route1.getDestination() == route2.getDestination();

	}

	// Method that returns whether all the cities are covered in the given
	// routes
	private boolean areAllCitiesCovered(Set<Integer> cities, List<Route> routes) {
		Set<Integer> citiesCovered = new HashSet<Integer>();
		for (Route route : routes) {
			citiesCovered.add(route.getSource());
			citiesCovered.add(route.getDestination());
		}
		return citiesCovered.containsAll(cities);
	}

}
