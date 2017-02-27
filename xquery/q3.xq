declare namespace r="http://www.asws.com/rois#";
for $a in doc('../data/roisarbre.xml')//(r:Roi,r:Reine) 
return $a/r:nom/text()

(: retourne les balises nom dans les balises Roi et Reine dans tout le doc :)
