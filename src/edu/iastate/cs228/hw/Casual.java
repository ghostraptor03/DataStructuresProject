package edu.iastate.cs228.hw;

/**
 * 
 * @authorZach
 *
 */
public class Casual extends TownCell {

	public Casual(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		return null;
	}

}
