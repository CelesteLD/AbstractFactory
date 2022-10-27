package es.ull.patrones.data;

import java.util.ArrayList;

public class Categorical extends Attribute {
	private ArrayList<String> chains = new ArrayList<String>();

	public Categorical(String name, int index) {
		super(name, index);
	}

	@Override
	public int getValue(int j) {
		return 0;
	}


	public void setChain(String chain) {
		chains.add(chain);
	}

	@Override
	protected void setValue(int i) { }

	public String getChain(int index) {
		return chains.get(index);
	}

	@Override
    public ArrayList<Integer> getArrayInt() {
		return null;
	}


	public ArrayList<String> getArrayString() {
		return chains;
	}
	
}