package org.okbqa.rendering.model;

import java.util.List;

import org.okbqa.rendering.renderer.QueryResultsRenderer;

public class DummyRenderer implements BindingRenderer, QueryResultsRenderer {

	public DummyRenderer() {}
	
	/*
	 * Transforms a binding into an HTML representation string
	 */
	public String render(Binding b) {
		StringBuilder sb = new StringBuilder();
		
		if (b==null) { return ""; };
		String var = b.getVar();
		String uri = b.getUriBinding();
		String label = enrich(uri);
		String endpoint = b.getSourceEndpoint();
		sb.append(String.format("<a id=\"%s\" href=\"%s\">%s</a> (%s)", var, uri, label, endpoint));
		
		return sb.toString();
	}
	
	/*
	 * Transforms query results into a HTML string representation
	 */
	public String render(QueryResults results) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		for (List<Binding> bindings: results.getBindingSets()) {
			sb.append("<tr>");
			for (Binding b: bindings) {
				sb.append("<td>");
				sb.append(render(b));
				sb.append("</td>");				
			}
			sb.append("</tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}
	
	/*
	 * Takes a URI as input, and queries some backend to obtain useful information for presentation including
	 * at least the label, probably the type and perhaps even more advanced things like:
	 * - a photo for people (a depiction makes sense for several classes)
	 * - a lat/long makes sense for locations
	 * - etc.
	 */
	public String enrich(String uri) {
		return uri.replaceAll("http://dbpedia.org/resource/","");
	}

}
