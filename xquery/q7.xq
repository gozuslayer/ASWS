declare namespace r="http://www.asws.com/rois#";
declare namespace rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
for $d in doc('../data/roisarbre.xml')//*[@rdf:ID=1]/*[r:fils]/r:nom
return $d
