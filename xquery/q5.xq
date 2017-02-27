declare namespace r="http://www.asws.com/rois#";
declare namespace rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
for $a in doc('../data/roisarbre.xml')//*[r:Reine],
	$b in $a/r:Reine/r:fils/r:Roi
	where $a/@rdf:resource= "rois#" $b/@rdf:ID
return $b
