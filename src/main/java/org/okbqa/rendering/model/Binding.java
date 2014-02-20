package org.okbqa.rendering.model;

public class Binding {
	private String var = "";
	private String binding = "";
	private String endpoint = "";
    public Binding(String aVar, String aUriBinding, String aSourceEndpoint) {
		var = aVar;
		binding = aUriBinding;
		endpoint = aSourceEndpoint;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String mVar) {
		this.var = mVar;
	}
	public String getUriBinding() {
		return binding;
	}
	public void setUriBinding(String mUriBinding) {
		this.binding = mUriBinding;
	}
	public String getSourceEndpoint() {
		return endpoint;
	}
	public void setSourceEndpoint(String mSourceEndpoint) {
		this.endpoint = mSourceEndpoint;
	}
}
