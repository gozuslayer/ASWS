import java.io.*;
import java.util.Iterator;
import org.apache.jena.util.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import org.apache.jena.ontology.*;
import org.apache.jena.reasoner.*;
import java.util.Scanner;

public class roisOwl {
    private static String fnameschema = "file:data/roisSchemaOwl.ttl";
    private static String fnameinstance = "file:data/roisDonnees.ttl";
    private static String NS = "http://www.bdia.com/rois#";
    
    public static void main(String args[]) {
	
	Model schema = FileManager.get().loadModel(fnameschema);
	Model data = FileManager.get().loadModel(fnameinstance);
	Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
	//reasoner.setParameter(ReasonerVocabulary.PROPtraceOn, Boolean.TRUE);
	// reasoner.setParameter(ReasonerVocabulary.PROPderivationLogging, Boolean.TRUE);
	reasoner.setDerivationLogging(true);
	reasoner = reasoner.bindSchema(schema);
	
	InfModel infmodel = ModelFactory.createInfModel(reasoner, data);
	infmodel.prepare();
	
	ValidityReport validity = infmodel.validate();
	if (validity.isValid()) {
	    System.out.println("OK");
	} else {
	    System.out.println("Conflicts");
	    for (Iterator i = validity.getReports(); i.hasNext(); ) {
		ValidityReport.Report report = (ValidityReport.Report)i.next();
		System.out.println(" - " + report);
	    }
	}
	
	Resource s = (Resource) null;
	Property p = (Property) null;
	RDFNode o = (RDFNode) null;
	
	Scanner in = new Scanner(System.in);
	
	System.out.print("Identifiant de sujet (sans espace de nom)     : ");
	String input = in.nextLine();
	if (!"".equals(input)) s = infmodel.getResource(NS+input);

	System.out.print("Identifiant de propriete (sans espace de nom) : ");
	input = in.nextLine();
	if (!"".equals(input))  {
	    p = infmodel.getProperty(NS+input);
	    // if (p.isTransitiveProperty)
	    // System.out.print(p);
	}

	System.out.print("Identifiant d'objet (sans espace de nom)      : ");
	input = in.nextLine();
	if (!"".equals(input))  o = infmodel.getResource(NS+input);


	System.out.println("* motif : (" + s + ", " +  p + ", " +  o + ") : ");
	printStatements(s, p, o, infmodel);
    }
    
    
    public static void printStatements(Resource s, Property p, RDFNode o, Model m)  {
	for (StmtIterator i = m.listStatements(s, p, o ); i.hasNext(); ) {
	    Statement stmt = i.nextStatement();
	    System.out.println(" - " + PrintUtil.print(stmt)); }
    }
}
