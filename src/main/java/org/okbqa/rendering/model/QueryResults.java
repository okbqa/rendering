package org.okbqa.rendering.model;

import java.util.List;
import java.util.ArrayList;

public class QueryResults {
	private String question = "";
	private List<List<Binding>> bindings = new ArrayList<List<Binding>>();

	public QueryResults(List<List<Binding>> aBindingSets) {
		bindings = aBindingSets;
	}
	
	public List<List<Binding>> getBindingSets() {
		return bindings;
	}
	public void setBindingSets(List<List<Binding>> bindingSets) {
		this.bindings = bindingSets;
	}
	
	@Override
	public String toString() {
		return question+this.bindings;
	}
}
