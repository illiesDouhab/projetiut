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

2. On crée la table import 
				
3. Pas besoin de convertir les données ?

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


