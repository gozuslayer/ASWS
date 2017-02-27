declare namespace r="http://www.asws.com/rois#";
for $a in doc('../data/roisarbre.xml')//r:Reine
return $a/r:nom/text()

(:retourne toutes les balises nom dans les balises Reines depuis le root:)
