package edu.iastate.cs228.hw;

public class Empty extends TownCell {
	/**
	 * 
	 * @authorZach
	 *
	 */
	public Empty(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		return null;
	}

}
