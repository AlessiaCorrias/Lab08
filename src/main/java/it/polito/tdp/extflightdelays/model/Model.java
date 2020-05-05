package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport, DefaultWeightedEdge> grafo; // simpleweightedgraph
	private Map<Integer, Airport> idMap;
	List<Collegamento> edges = new ArrayList<>();

	public Model() {
		idMap = new HashMap<Integer, Airport>();
	}

	public void creaGrafo(double x) {

		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		dao.fillIdMap(idMap);

		// Aggiungo vertici
		Graphs.addAllVertices(this.grafo, idMap.values());

		// Aggiungo archi

		for (Collegamento c : dao.getCollegamenti()) {
			if (c.getDistanza() >= x) {
				Graphs.addEdge(this.grafo, idMap.get(c.getAer1()), idMap.get(c.getAer2()), c.getDistanza());
				edges.add(c);
			}
		}

	}

	public String stampaGrafo() {
		String res = "";

		for (Collegamento e : edges)
			// res += e.toString() + "\n"; con id aereoporti
			
			// con nomi areoporti
			res+= "{ "+idMap.get(e.getAer1()).getAirportName() + ", "+ idMap.get(e.getAer2()).getAirportName() +" }, distanza = " + e.getDistanza()+"\n";

		return res;
	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

}
