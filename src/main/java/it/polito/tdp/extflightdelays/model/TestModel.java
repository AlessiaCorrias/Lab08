package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		/*Collegamento c = new Collegamento (1,2,3);
		Collegamento c2 = new Collegamento (2,1,3);
		
		System.out.println(c.getK());
		System.out.println(c2.getK());
		*/
		model.creaGrafo(1000);
		
		//System.out.println(String.format("Grafo creato! %d vertici, %d archi",model.nVertici(), model.nArchi()));
		System.out.println(model.stampaGrafo());

	}

}
