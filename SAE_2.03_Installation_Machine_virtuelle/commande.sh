#!/bin/bash 

#Creation d'un fichier CSS du nom de style.css

touch style.css;

#toutes les lignes pour nécaissaire pour le fichier CSS qui vont se mettre 

echo "
/* Définition des couleurs */
:root {
  --primary-color: #0077C0;
  --secondary-color: #ECECEC;
  --text-color: #333333;
}
/* Style de la page */
body {
  font-family: Arial, sans-serif;
  background-color: var(--secondary-color);
  color: var(--text-color);
  line-height: 1.5;
  padding: 30px;
}

/* Style des titres */
h1, h2, h3 {
  color: var(--primary-color);
  font-weight: bold;
}

h1 {
  font-size: 2.5em;
}

h2 {
  font-size: 2em;
}

h3 {
  font-size: 1.5em;
}

/* Style des listes */
ul, ol {
  margin: 20px 0;
  padding-left: 40px;
}

li {
  margin-bottom: 10px;
}

/* Style des liens */
a {
  color: var(--primary-color);
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

/* Style des citations */
blockquote {
  margin: 20px 0;
  padding: 10px 20px;
  background-color: #F7F7F7;
  border-left: 5px solid var(--primary-color);
}

/* Style du code */
code {
  background-color: #F7F7F7;
  padding: 2px 4px;
  border: 1px solid #DDD;
  font-family: Consolas, monospace;
  font-size: 0.9em;
}

pre {
  background-color: #F7F7F7;
  padding: 10px;
  border: 1px solid #DDD;
  font-family: Consolas, monospace;
  font-size: 0.9em;
  overflow-x: auto;
}

/* Style des tableaux */
table {
  border-collapse: collapse;
  margin: 20px 0;
  width: 100%;
}

th, td {
  border: 1px solid #DDD;
  padding: 5px;
}

th {
  background-color: var(--primary-color);
  color: #FFF;
  font-weight: bold;
}

/* Style des images */

img {
  width: 600px;
  
}" >> style.css;






#Commande qui va creer le document pdf avec la table of content
pandoc --standalone --toc  -o ./SAE_2.03_PDF.pdf ./SAE_2.03.md;

#Commande qui va creer le document html avec la table of content et va utiliser un css
pandoc --standalone --toc --css=./style.css -o ./SAE_2.03_HTML.html ./SAE_2.03.md --metadata title="SAE_2.03";


