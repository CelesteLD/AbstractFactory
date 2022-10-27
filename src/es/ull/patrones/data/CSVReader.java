package es.ull.patrones.data;

import java.util.ArrayList;

public class CSVReader {

  
  private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
  private int nRows = 0, nCols = 0;
  private String nameFile = null;

  public CSVReader() {
		readFile();
	}
	
	public void setRows(int nRows) {
		this.nRows = nRows;
	}

	public void setCols(int nCols) {
		this.nCols = nCols;
	}

	public int getRows() {
		return nRows;
	}

	public int getCols() {
		return nCols;
	}
	
	public void setFileName(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getFileName () {
		return nameFile;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

  public void readFile() {

		String contents = HTTPFileDownloader.downloadFromURL("https://cnecovid.isciii.es/covid19/resources/casos_hosp_uci_def_sexo_edad_provres_60_mas.csv");
		
		String [] rows = contents.split("\n"); // Contando el número de filas
		setRows(rows.length);

		for (int i = 0; i < rows.length; i++) {
			String [] cols = rows[i].split(","); // Contando el número de columnas
			if (i == 0) {
				setCols(cols.length);
			}
		}
			
		for (int i = 0; i < nCols; i++) {
			if (i == 0 || i == 1 || i == 2 || i == 3) {
				attributes.add(new Categorical(rows[i], i)); // 1, 2, 3, 4
			} else {
				attributes.add(new Numeric(rows[i], i));
			}
		}

		for (int i = 1; i < nRows; i++) {
			String [] cols = rows[i].split(",");
			for (int j = 0; j < nCols; j++) {
				if (j == 0 || j == 1 || j == 2 || j == 3) {
					attributes.get(j).setChain(cols[j]);
				} else {
					attributes.get(j).setValue(Integer.parseInt(cols[j]));
				}
			}
		}
	}	

	public void printFile() {
		for (int i = 0; i < nRows - 1; i++) {
			for (int j = 0; j < nCols; j++) {
				if (j == 0 || j == 1 || j == 2 || j == 3) {
					System.out.print(attributes.get(j).getChain(i) + " ");
				} else {
					System.out.print(attributes.get(j).getValue(i) + " ");
				}
			}
			System.out.println();
		}
	}
}
