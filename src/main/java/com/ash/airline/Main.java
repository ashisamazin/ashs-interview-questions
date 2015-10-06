package com.ash.airline;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner("8 16 4 5 0.35 4 7 0.37 5 7 0.28 0 7 0.16 1 5 0.32 0 4 0.38 2 3 0.17 1 7 0.19 0 2 0.26 1 2 0.36 1 3 0.29 2 7 0.34 6 2 0.40 3 6 0.52 6 0 0.58 6 4 0.93 ");

		Graph graph = new Graph();

		int numberOfCities = sc.nextInt();
		int numberOfRoutes = sc.nextInt();

		for (int i = 0; i < numberOfRoutes; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			float cost = sc.nextFloat();
			graph.addCity(source);
			graph.addCity(destination);
			graph.addRoute(source, destination, cost);
		}

		List<Route> cheapestRoutes = graph.getCheapestRoutes();
		float total = 0;
		for(Route route : cheapestRoutes){
			System.out.println(route);
			total += route.getCost();
		}
		System.out.println(total);

	}
}
