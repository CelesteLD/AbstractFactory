package es.ull.patrones.data;

import java.util.ArrayList;


public abstract class Attribute {

	private String name;
	private int index;

	public Attribute() {
	}

	public Attribute(String name, int index) {
		setName(name);
		setIndex(index);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public abstract int getValue(int j);

	public abstract String getChain(int j);

	public abstract ArrayList<Integer> getArrayInt();

	public abstract ArrayList<String> getArrayString();

	protected abstract void setChain(String chain);

	protected abstract void setValue(int i);
}
