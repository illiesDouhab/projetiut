# Rapport Technique Exploitation BDD
*Illies Douhab / Xavier Moyon*	
## ***Exercice 1 : Comprendre les données***
	

### Athlete_events.csv	
			
#### Nombre de lignes 
				
	cat athlete_events.csv | wc -l --> 271117 lignes

#### Première ligne
							
	cat athlete_events.csv | head -n1 --> "ID","Name","Sex","Age","Height","Weight","Team","NOC","Games","Year","Season","City","Sport","Event","Medal"
	
#### Séparateur de champs

	Le séparateur de champs est la virgule

#### Représentation d'une ligne

**Un retour à la ligne**
				
#### Nombre de colonnes 
				
	cat  athlete_events.csv |head -n1 | tr "," "\n" | wc -l --> 15


#### Colonne de distinction entre JO Hiver et JO ETE
				
	Season permet de distinguer les deux JO

#### Reference Jean Claude Killy

	cat  athlete_events.csv | grep "Jean-Claude Killy" | wc -l --> 6
			
#### Encodage Fichier 

	file -e encoding athlete_events.csv --> athlete_events.csv: ASCII text, with CRLF line terminators	
			
#### Importation Données
				
1. On identifie les données et leurs types

2. On crée la table import en utilisant des types textes pour récupérer toutes les données (On effectuera les conversion après pour éviter )
				
3. Pas besoin de convertir les données 

4. On indique qu'il y a un header 


### noc_regions.csv	

#### Conversion	

	cat noc_regions.csv | tr '\r\n' '\n' > new_noc_region.csv
		
#### Nombre de lignes 
	
	cat new_noc_region.csv | wc -l --> 230


#### Première ligne
	
	cat new_noc_region.csv | head -n1 --> NOC,region,notes

		
#### Séparateur de champs

	cat new_noc_region.csv | head -n1 --> NOC,region,notes

#### Représentation d'une ligne

	cat new_noc_region.csv | head -n3
		NOC,region,notes
		AFG,Afghanistan,
		AHO,Curacao,Netherlands Antilles
	

#### Nombre de colonnes 

	cat new_noc_region.csv | head -n1 | tr "," "\n" | wc -l --> 3


#### Encodage 

	file -e encoding new_noc_region.csv --> new_noc_region.csv: ASCII text

## Exercice 2 : **Importation**

### Table Import 
1. Création table import 

		Create temp Table import (
		
		 ID int,
		 Name varchar(120), 
		 Sex varchar(5) ,
		 Age text,
		 Height text,
		 Weight text,
		 Team text,
		 NOC varchar(3),
		 Games text,
		 Year int,
		 Season text,
		 City varchar(60),
		 Sport varchar(50),
		 Event varchar(250),
		 Medal text
		);
	Apres avoir consulté les données nous avons restreint le plus que possibles les types contenu dans la tables , cependant certaines colonnes néscecitait un typage plus large (dû a des exceptions)(Height , Weight , Age (Pour Age les valeur non renseigné étaient inscrite en 'NA' ne correspondant pas au type int souhaité ))

2.	Remplir La Table 
	
	La commande á utiliser pour l'importation est :
		`\copy import from data.csv with(format CSV ,delimiter ',' , Header);`
	On précise le format (CSV) , le délimiteur de colonne(' , ') ainsi que la présence d'un en-tête.
	
3. Suppression des données incorrectes
	
	Pour supprimer les données incorrectes (Années < 1920 ou/et épreuves artistique) on utilise la commandes suivantes :
		`delete from import where Year<1920 OR Sport LIKE '%Art%';`


4. Importer la table noc_région
	
	Pour l'importation on utilise la commande suivante :
		`\copy noc from new_noc_region.csv with (format CSV ,delimiter ',' , Header);`
		On précise le format (CSV) , le délimiteur de colonne(' , ') ainsi que la présence d'un en-tête.
	(Dans notre cas le document csv noc_regions.csv s'appelle new_noc_region car le fichier csv de noc_region n'était pas sur un format adéquat au départ)
	

## Exercice 3 : **Requêtage sur les fichiers de départ (import et noc)**

1. Nombre de colonnes dans import
	
	Pour connaitre le nombre de colonne dans la table import, on utilise la commande suivante :
	
		select  count(COLUMN_NAME)
		from information_schema.columns
		where table_name =  'import';
	On utilise les données de la metabase sur les colonnes (information_schema.columns) , on ne récupère que les lignes de la tables import (Where table_name = 'import') et on sélectionne le nombre de lignes (SELECT Count(COLUMN_NAME)) 

2. Nombre de lignes dans import
	
	Pour connaitre le nombre de ligne dans la table import, on utilise la commande suivante :
	
		`Select  count(*) from import;`
	Ici pas besoin d'utiliser la métabase étant donné que nous comptons les lignes et non colonnes.
3. Nombres de code NOC dans noc
	
	Pour connaitre le nombre de code NOC dans la table noc, on utilise la commande suivante :
	
		SELECT  count(DISTINCT noc) FROM noc WHERE noc is  not  null;

	Ici on compte le nombre de noc différent dans la table noc, lorsque le code n'est pas null 

4. Nombre d'athlètes différents
	Pour connaitre le nombre d'athlètes différents dans la table import, on utilise la commande suivante :

		SELECT  count(DISTINCT id) FROM import where id is  not  null;

5. Nombre de Médailles d'or 
	
	Pour connaitre le nombre de médaille d'or dans la table import, on utilise la commande suivante :

		SELECT  count(*) FROM import WHERE medal ='Gold';

6. Nombre de lignes référençant Carl Lewis

	Pour connaitre le nombre de lignes référençant Carl Lewis  dans la table import, on utilise la commande suivante :

		SELECT  *  FROM import 
		where name LIKE  '%Carl%Lewis%';

## Exercice 4 : Ventilation des Données

### Q1
#### **1. **MCD Des Jeux Olympiques****

![enter image description here](https://cdn.discordapp.com/attachments/1027631359591718962/1096522286753915021/image.png)

#### **2. MLD :**

Athlete(<u>ID</u>,Name,Sex)
	Pays(<u>NOC</u>,Region,Notes)
	Team(<u>IDTeam</u>,Team,#NOC)
	Ville(<u>IDV</u>,NomVille)
	Médaille(<u>IdM</u>,NomMedal)
	JO(<u>IdJO</u>,Season,Annee)
	SousDiscipline(<u>IdSD</u>,SDname,#idS)
	Discipline(<u>IdS</u>,Sport)
	Participe(<u>#ID,#IdTeam,#idV,#idJO,#idSD,#idM</u>, poids, taille, âge)


 **3. Ajout des données dans les tables correspondantes**



### Q2
Tout D'abord pour connaitre les information sur la taille en octet des tables on utilise la commande suivante :
	
	\d+
1. Taille en octet du fichier récupéré
2. Taille en octet de la table import
	La table import a une taille de 98 MB
3.  Taille en octet de la somme des tables créées 
4.  Taille en octet de la somme des fichiers exportés

 	
 
