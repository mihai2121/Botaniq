package accesDBpedia;

import com.wade.botaniq.models.User;
import java.util.ArrayList;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;


/**
 *
 * @author psg
 */
public class InterStardog {

    private ArrayList al1 = new ArrayList();

    public String[] askPlantDetail(String ScientificName) {
        String[] s1g = new String[40];
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "prefix mos: <http://www.semanticweb.org/psg/plant/>\n"
                + "\n"
                + "select distinct ?s ?p0 ?p3 ?p4 ?p5 ?p6 ?p7 ?p8 ?p9 ?p10 ?p11 ?p12 ?p13 ?p14 ?p15 ?p16 ?p17 ?p18 ?p19 ?p20 ?p21"
                + "?p22 ?p23 ?p24 ?p25 ?p26 ?p27 ?p28 ?p29 ?p30 ?p31 ?p32 ?p33 ?p34 ?p35 ?p36 ?p37 ?p38"
                + " where {\n"
                + "?s mos:scientificName \"" + ScientificName + "\".\n"
                + "?s mos:abrev ?p0.\n"
                + "?s mos:scientificName ?p3 .\n"
                + "OPTIONAL {?s mos:commonName ?p4} .\n"
                + "?s mos:genus ?p5 .\n"
                + "?s mos:family ?p6 .\n"
                + "?s mos:order ?p7 .\n"
                + "?s mos:class ?p8 .\n"
                + "?s mos:division ?p9 .\n"
                + "OPTIONAL {?s mos:duration ?p10} .\n"
                + "OPTIONAL {?s mos:growthHabit ?p11} .\n"
                + "OPTIONAL {?s mos:factSheet ?p12} .\n"
                + "OPTIONAL {?s mos:plantGuide ?p13} .\n"
                + "OPTIONAL {?s mos:flowerColor ?p14} .\n"
                + "OPTIONAL {?s mos:growthRate ?p15} .\n"
                + "OPTIONAL {?s mos:heigthMax ?p16} .\n"
                + "OPTIONAL {?s mos:leafRetention ?p17} .\n"
                + "OPTIONAL {?s mos:lifespan ?p18} .\n"
                + "OPTIONAL {?s mos:toxicity ?p19} .\n"
                + "OPTIONAL {?s mos:soilCoarse ?p20} .\n"
                + "OPTIONAL {?s mos:SoilMedium ?p21} .\n"
                + "OPTIONAL {?s mos:SoilFine ?p22} .\n"
                + "OPTIONAL {?s mos:drougthTolerance ?p23} .\n"
                + "OPTIONAL {?s mos:fertilityRequirement ?p24} .\n"
                + "OPTIONAL {?s mos:phMin ?p25} .\n"
                + "OPTIONAL {?s mos:phMax ?p26} .\n"
                + "OPTIONAL {?s mos:shadeTolerance ?p27} .\n"
                + "OPTIONAL {?s mos:bloomPeriod ?p28} .\n"
                + "OPTIONAL {?s mos:fruitPeriod ?p29} .\n"
                + "OPTIONAL {?s mos:propogateByRoot ?p30} .\n"
                + "OPTIONAL {?s mos:propogateByBulbs ?p31} .\n"
                + "OPTIONAL {?s mos:propogateByContainer ?p32} .\n"
                + "OPTIONAL {?s mos:propogateByCorms ?p33} .\n"
                + "OPTIONAL {?s mos:propogateByCutting ?p34} .\n"
                + "OPTIONAL {?s mos:propogateBySeed ?p35} .\n"
                + "OPTIONAL {?s mos:propogateBySod ?p36} .\n"
                + "OPTIONAL {?s mos:propogateBySprings ?p37} .\n"
                + "OPTIONAL {?s mos:propogateByTuber ?p38} .\n"
                + "    }\n"
                + "LIMIT 1");
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://localhost:5820/PlantDB/query", qs.asQuery());
        ResultSet results = ResultSetFactory.copyResults(exec.execSelect());

        while (results.hasNext()) {
            QuerySolution qs1g = results.next();
            System.out.println(qs1g.get("s"));
            RDFNode s11 = qs1g.get("p0");//abrev
            s1g[0] = s11.toString();
            System.out.println(s1g[0]);
            s11 = qs1g.get("p3");//scientific name
            s1g[3] = s11.toString();
            System.out.println(s1g[1]);
            s11 = qs1g.get("p4");//common name
            if (s11 != null) {
            s1g[4] = s11.toString();
            }
            System.out.println(s1g[2]);
            s11 = qs1g.get("p5");//genus
            s1g[5] = s11.toString();
            System.out.println(s1g[3]);
            s11 = qs1g.get("p6");//
            s1g[6] = s11.toString();
            System.out.println(s1g[3]);
            s11 = qs1g.get("p7");//
            s1g[7] = s11.toString();
            System.out.println(s1g[3]);
            s11 = qs1g.get("p8");//
            s1g[8] = s11.toString();
            System.out.println(s1g[3]);
            s11 = qs1g.get("p9");//
            s1g[9] = s11.toString();
            System.out.println(s1g[3]);
            s11 = qs1g.get("p10");//
            if (s11 != null) {
                s1g[10] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p11");//
            if (s11 != null) {
                s1g[11] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p12");//
            if (s11 != null) {
                s1g[12] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p13");//
            if (s11 != null) {
                s1g[13] = s11.toString();
                System.out.println(s1g[3]);
            }

            s11 = qs1g.get("p14");//
            if (s11 != null) {
                s1g[14] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p15");//
            if (s11 != null) {
                s1g[15] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p16");//
            if (s11 != null) {
                s1g[16] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p17");//
            if (s11 != null) {
                s1g[17] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p18");//
            if (s11 != null) {
                s1g[18] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p19");//
            if (s11 != null) {
                s1g[19] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p20");//
            if (s11 != null) {
                s1g[20] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p21");
            if (s11 != null) {
                s1g[21] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p22");//
            if (s11 != null) {
                s1g[22] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p23");//
            if (s11 != null) {
                s1g[23] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p24");//
            if (s11 != null) {
                s1g[24] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p25");//
            if (s11 != null) {
                s1g[25] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p26");//
            if (s11 != null) {
                s1g[26] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p27");//
            if (s11 != null) {
                s1g[27] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p28");//
            if (s11 != null) {
                s1g[28] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p29");//
            if (s11 != null) {
                s1g[29] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p30");//
            if (s11 != null) {
                s1g[30] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p31");//
            if (s11 != null) {
                s1g[31] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p32");//
            if (s11 != null) {
                s1g[32] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p33");//
            if (s11 != null) {
                s1g[33] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p34");//
            if (s11 != null) {
                s1g[34] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p35");//
            if (s11 != null) {
                s1g[35] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p36");//
            if (s11 != null) {
                s1g[36] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p37");//
            if (s11 != null) {
                s1g[37] = s11.toString();
                System.out.println(s1g[3]);
            }
            s11 = qs1g.get("p38");//
            if (s11 != null) {
                s1g[38] = s11.toString();
                System.out.println(s1g[3]);
            }
        }
//        ResultSetFormatter.out(results);
        return s1g;
    }

    public String[] askPlantList(int start, int size) {
        String[] s1g = new String[size];
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "prefix mos: <http://www.semanticweb.org/psg/plant/>\n"
                + "\n"
                + "select distinct ?s ?o "
                + "where{?s ?p ?o .\n"
                + " ?s mos:scientificName ?o."
                + "    }\n"
                + "LIMIT "+Integer.toString(size)+ " OFFSET "+Integer.toString(start));
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://localhost:5820/PlantDB/query", qs.asQuery());
        ResultSet results = ResultSetFactory.copyResults(exec.execSelect());
        int i = 0;
        while (results.hasNext() && i < size) {

            QuerySolution qs1g = results.next();
            RDFNode s11 = qs1g.get("o");//scientific name
            s1g[i] = s11.toString();
            System.out.println(s1g[i]);
            i++;
        }
        return s1g;
    }
    
    public String[] askPlantList(String namePlant) {
        String[] s1g = new String[20];
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "prefix mos: <http://www.semanticweb.org/psg/plant/>\n"
                + "\n"
                + "select distinct ?s ?o "
                + "where{?s ?p ?o .\n"
                + " ?s mos:commonName "+namePlant+ "."
                + "    }\n"
                + "LIMIT 20");
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://localhost:5820/PlantDB/query", qs.asQuery());
        ResultSet results = ResultSetFactory.copyResults(exec.execSelect());
        int i = 0;
        while (results.hasNext() && i < 20) {
            QuerySolution qs1g = results.next();
            RDFNode s11 = qs1g.get("o");//scientific name
            s1g[i] = s11.toString();
            System.out.println(s1g[i]);
            i++;
        }
        return s1g;
    }
    
 
    public void createUser(User user){
        String qs = ""
               + "prefix mos: <http://www.semanticweb.org/psg/plant/>\n"
                + "prefix foaf: <http://xmlns.com/foaf/0.1/>\n"

                + "\n"
                + "INSERT DATA "
        +"{mos:ID00007 foaf:name \"simplu ion\"}";
 
UpdateProcessor upp = UpdateExecutionFactory.createRemote(UpdateFactory.create(qs),"http://localhost:5820/UsersDB/update");
        upp.execute();
    }
}
