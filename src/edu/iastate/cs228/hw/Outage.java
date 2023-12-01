package edu.iastate.cs228.hw;

/**
 * 
 * @authorZach
 *
 */
public class Outage extends TownCell {

	public Outage(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		return null;
	}

}
