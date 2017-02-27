declare namespace r="http://www.asws.com/rois#";
declare namespace rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
for $a in doc('../data/roisarbre.xml')//r:fils/r:Roi/r:nom
return $a/text()
