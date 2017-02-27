declare namespace r="http://www.asws.com/rois#";
for $a in doc('../data/roisarbre.xml')//r:Roi
return $a/r:nom

(: retourne depuis toute les balises depuis le root les balises nom dans les balises roi :)
