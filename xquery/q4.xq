declare namespace r="http://www.asws.com/rois#";
declare namespace rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
for $a in doc('../data/roisarbre.xml')//(r:Roi,r:Reine) 
return element personne { $a/@rdf:ID, $a/r:nom }

(: crée des nouvelles balises "personne" contenant l'ID en attribut rdf et le nom en balise interne  de chaque roi et reine :)


