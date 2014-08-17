package com.ash.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle {

	private Board board;

	public Puzzle() {
		this.board = new Board();
	}

	public List<Board> findSolution(int move) {
		return findSolution(Arrays.asList(board), move);
	}

	public List<Board> findSolution(List<Board> boardSequences, int move) {
		Board latestBoard = boardSequences.get(boardSequences.size() - 1);
		if (latestBoard.isComplete()) {
			return boardSequences;
		}
		move++;
		for (Square peg : latestBoard.getPegs()) {
			for (Direction direction : Direction.values()) {
				if (latestBoard.canMove(peg, direction)) {
					List<Board> newBoardSequence = new ArrayList<Board>(boardSequences);
					Board newBoard = latestBoard.move(peg, direction);
					newBoardSequence.add(newBoard);
					findSolution(newBoardSequence, move);
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle();
		List<Board> boardSequence = puzzle.findSolution(1);
		for (Board board : boardSequence) {
			System.out.println(board);
		}
	}
}
