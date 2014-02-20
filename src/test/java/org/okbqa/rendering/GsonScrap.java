package org.okbqa.rendering;

import java.io.StringReader;

import org.okbqa.rendering.model.Binding;
import org.okbqa.rendering.model.DummyRenderer;
import org.okbqa.rendering.model.QueryResults;
import org.okbqa.rendering.renderer.QueryResultsRenderer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonScrap {

	public static void main(String[] args) {
		Binding a = new Binding("?x","http://dbpedia.org/resource/Jeju_City","http://dbpedia.org/sparql");
		
		String exBind = "{ 'var': '?x', 'binding': 'http://dbpedia.org/resource/Jeju_City', 'endpoint': 'http://dbpedia.org/sparql'}";
		Gson gson = new GsonBuilder().create();
		Binding p = gson.fromJson(new StringReader(exBind), Binding.class);
		System.out.println(p);
		System.out.println(p.getVar());
		System.out.println(p.getUriBinding());
		System.out.println(p.getSourceEndpoint());
		
		String exQr = "{'question':'what?', "
				+ "     'bindings':[ [ "
				+ "{ 'var': '?x', 'binding': 'http://dbpedia.org/resource/Jeju_City', 'endpoint': 'http://dbpedia.org/sparql'} "
				+ "]] }";
		
    	String json = "{ 'question': 'How many students does the Free University of Berlin have?','bindings': [ [ { 'var' : '?x',  'binding': '250000',  'endpoint': 'http://dbpedia.org/sparql'} ] ] }";
		QueryResults qr = gson.fromJson(new StringReader(json), QueryResults.class);
    	QueryResultsRenderer renderer = new DummyRenderer();
    	String results = renderer.render(qr);
		System.out.println(qr);
		System.out.println(results);
	}
}
