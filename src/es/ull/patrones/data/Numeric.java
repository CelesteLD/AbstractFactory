package es.ull.patrones.data;

import java.util.ArrayList;

public class Numeric extends Attribute {

	private final ArrayList<Integer> values;
	
	public Numeric(String name, int index) {
		super(name, index);
		values = new ArrayList<>();
	}
	
	public void setValue(int valor) {
		values.add(valor);
	}

	public int getValue(int position) {
		return values.get(position);
	}

	@Override
	public String getChain(int j) {
		return null;
	}

	@Override
	public ArrayList<Integer> getArrayInt() {
		return values;
	}

	@Override
	public ArrayList<String> getArrayString() {
		return null;
	}

	@Override
	protected void setChain(String chain) {	}
  
}