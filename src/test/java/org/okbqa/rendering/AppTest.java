package org.okbqa.rendering;

import java.util.ArrayList;
import java.util.List;

import org.okbqa.rendering.model.Binding;
import org.okbqa.rendering.model.DummyRenderer;
import org.okbqa.rendering.model.QueryResults;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Binding a = new Binding("?x","http://dbpedia.org/resource/Jeju_City","http://dbpedia.org/sparql");
        Binding b = new Binding("?y","http://dbpedia.org/resource/South_Korea","http://dbpedia.org/sparql");
        List<Binding> bindings = new ArrayList<Binding>();
        bindings.add(a); bindings.add(b);
        List<List<Binding>> sets = new ArrayList<List<Binding>>();
        sets.add(bindings);
        QueryResults qr = new QueryResults(sets);
        DummyRenderer renderer = new DummyRenderer();
        String output = renderer.render(qr);
        System.out.println(output);
        String desired = "<table><tr>"
        		+ "<td><a id=\"?x\" href=\"http://dbpedia.org/resource/Jeju_City\">Jeju_City</a> (http://dbpedia.org/sparql)</td>"
        		+ "<td><a id=\"?y\" href=\"http://dbpedia.org/resource/South_Korea\">South_Korea</a> (http://dbpedia.org/sparql)</td>"
        		+ "</tr></table>";
    	assertTrue( output.equals(desired) );
    }
}
