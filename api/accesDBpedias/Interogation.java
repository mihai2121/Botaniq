/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesDBpedia;

import java.util.ArrayList;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.update.UpdateExecutionFactory;

/**
 *
 * @author psg
 */
public class Interogation {

    private ArrayList al1 = new ArrayList();

    public String[] ask(String ScientificName) {
        String[] s1 = new String[13];
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "prefix dbo:    <http://dbpedia.org/ontology/>\n"
                + "prefix foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "\n"
                + "select distinct ?s ?p1 ?p2 ?p3 ?p4 ?p5 ?p6 ?p7 ?p8 ?p9 where {\n"
                + "?s rdfs:label \"" + ScientificName + "\"@en.\n"
                + "?s rdfs:label ?p1 .\n"
                + "?s dbo:abstract ?p2 .\n"
                + "?s dbo:division ?p3 .\n"
                + "?s dbo:class ?p4 .\n"
                + "?s dbo:order ?p5 .\n"
                + "?s dbo:family ?p6 .\n"
                + "OPTIONAL {?s dbo:genus ?p7 }.\n"
                + "OPTIONAL {?s foaf:depiction ?p8 }.\n"
                + "?s foaf:isPrimaryTopicOf ?p9 .\n"
                + "FILTER (lang(?p1) = 'en')\n"
                + "FILTER (lang(?p2) = 'en')\n"
                + "    }\n"
                + "LIMIT 10");
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", qs.asQuery());
        ResultSet results = ResultSetFactory.copyResults(exec.execSelect());
        while (results.hasNext()) {
            QuerySolution qs1 = results.next();
            System.out.println(qs1.get("s"));
            RDFNode s11 = qs1.get("p1");//label
            s1[0] = s11.toString();
            System.out.println(s1[0]);
            s11 = qs1.get("p2");//abstract
            s1[1] = s11.toString();
            System.out.println(s1[1]);
            s11 = qs1.get("p3");//division
            s1[2] = s11.asNode().getLocalName();
            System.out.println(s1[2]);
            s11 = qs1.get("p4");//class
            s1[3] = s11.asNode().getLocalName();
            System.out.println(s1[3]);
            s11 = qs1.get("p5");//order
            s1[4] = s11.asNode().getLocalName();
            System.out.println(s1[4]);
            s11 = qs1.get("p6");//family
            s1[5] = s11.asNode().getLocalName();
            System.out.println(s1[5]);
            s11 = qs1.get("p7");//genus
            if (s11 == null) {
                System.out.println("este null");
                s1[6] = "null";
            } else {
                s1[6] = s11.asNode().getLocalName();
            }
            System.out.println(s1[6]);

            s11 = qs1.get("p8");//image
            if (s11 == null) {
                System.out.println("este null");
                s1[7] = "null";
            } else {
                s1[7] = s11.toString();
            }
            System.out.println(s1[7]);
            s11 = qs1.get("p9");//link wikipedia
            s1[8] = s11.asNode().getLocalName();
            System.out.println(s1[8]);
        }

        InterStardog ig = new InterStardog();
        String[] s2 = new String[40];
        s2 = ig.askPlantDetail(ScientificName);
        s2[1] = s1[1];
        s2[2] = s1[8];
        s2[39] = s1[7];
        return s2;
    }

    public String[] askListPlant(int start, int size) {
        String[] s1 = new String[size];
        InterStardog ig = new InterStardog();
        s1 = ig.askPlantList(start, size);
        return s1;
    }

    public String[] askListPlant(String namePlant) {
        String[] s1 = new String[20];
        InterStardog ig = new InterStardog();
        s1 = ig.askPlantList(namePlant);
        return s1;
    }
}
