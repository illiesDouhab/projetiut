/*By Xavier Moyon and Illies Douhab

Ce qu'il y a

    Verification du type donnée entré ( Il ne faut que des int)
    Un stockage des réponses des joueurs au différentes questions avec un type Reponse
    Un Joueur (Class pour stocker les scores le nom du joueur et les reponses aux question avec le type Reponse)
    Différents Calculs (addition soustraction multiplication division)
    Différents type jeu (problemes / calcul mental)
    Différentes Récompenses
    Un Affichage de différentes maisons
    Mode Solo et mode deux joueurs ( en rivalité, le premier qui constrruit son village gagne)
    Chaque joueur possede un code couleur

    
Fonctions :

    Creer Joueur (type)
        -Contient nom, prénom, code couleur, type Question, numéro de la question
    Lancer Partie
    Choix Adversaire ( autre joueur ou IA)
    Choix type de calcul
    generation d'un calcul adapté
    Affichage Question
    Verification réponse
    !! Verification du type donnée entré et conversion( Il ne faut que des int)
        -entrerResultat 
            -estValide
            -Convertir
    Creer message de retour (Bravo / Tu as fais une erreur la réponse était ...)
    Enregistrer Question Réponse et Bonne réponse (ou pas)(Type)
        -Comment Stocker Chaque Question Sans Savoir à l'avance le nombre questions(Tableaux Taille Maximale)// Remplir directement le fichier csv avec les réponses donc plus besoin de stocker les réponses 
    Fonction pour enregistrer les meilleures scores


04/01/22 :

    Objectifs : Faire La Sauvegarde 

        -3 Fichiers De Sauvegarde :
            _Dans le premier on stock les informations du joueur 1
            _Dans le deuxieme on stock les informations du joueur 2 (Si il y en a un)
            _Dans le Troisieme on stock les Scores de tout les joueurs 

----------------------------------------------------------------------------------
 Fonctions De Calcul : 
 */
import extensions.CSVFile;
import extensions.File;
class LeVillageDeGosses extends Program{

    //Ici on initialise les valeurs associés aux opérateurs

/*_______________________________________________________________________________
                               Fonction Retire Points Joueur et coeurs
  _______________________________________________________________________________
*/

    final String NOM = "L'entité";

    final int PLUS = 1;
    final int MOINS = 2;
    final int MULTIPLICATION = 3;
    final int DIVISION = 4 ;

    final int POINTPLUS = 10;
    final int POINTMOINS = 15;
    final int POINTMULTIPLICATION = 20;
    final int POINTDIVISION = 25;

    final int COEUR = 3;
    final int NBQUEST = 5;

    final String CHEMIN = "./Historique_Joueurs.csv";
    final String HIGHSCORE="./HighScore.csv";
    final int TAILLECOLONNE=12;
    final int MAXSCORE=500;
    final int DLAY = 700;

    final int TENTATIVES=3;
    boolean finJeu=false;

/*_______________________________________________________________________________
                               Fonction Retire Points Joueur et coeurs
  _______________________________________________________________________________
*/


    int valRandom(int min , int max){//max est inclus dans notre fonction
        return (int)(min+(random())*((max+1)-min));
    }

    void testValRandom(){
        int valTest;
        int min = 5;
        int max = 15;
        for (int i = 0 ; i<1000; i++){
            valTest=valRandom(min,max);
            assertTrue((valTest<=max)&&(valTest>=min));
            assertFalse((valTest>max)||(valTest<min));
        }
        
    }
    int calcul(int operateur , Joueur joueur){
        boolean reussi=true;
        int pointCalcul=0;
        if (operateur==PLUS){//dans ce cas il s'agit d'une addition
            reussi=resultatEtAffichageAddition(joueur);
            pointCalcul=POINTPLUS;  
        }else if (operateur==MOINS){//dans ce cas il s'agit d'une addition  
            reussi=resultatEtAffichageSoustraction(joueur);
            pointCalcul=POINTMOINS;  
        }else if (operateur==MULTIPLICATION){//dans ce cas il s'agit d'une addition  
            reussi=resultatEtAffichageMultiplication(joueur);
            pointCalcul=POINTMULTIPLICATION;
        }else if (operateur==DIVISION){//dans ce cas il s'agit d'une division
            reussi=resultatEtAffichageDivision(joueur);
            pointCalcul=POINTDIVISION;
        }
        if (!reussi){
            retirePointCoeur(joueur,pointCalcul);
            pointCalcul=0;
        }
        
        return pointCalcul;
    }


/*_______________________________________________________________________________
                               Fonction Retire Points Joueur et coeurs
  _______________________________________________________________________________
*/

void retirePointCoeur(Joueur joueur,int pointsParCalcul){
    joueur.coeur-=1;
    if (joueur.coeur<=0){
        joueur.score-=((NBQUEST*pointsParCalcul)/2);
        println("Malheureusement tu n'as pas réussi, mais tu ne t'inquiete pas tu feras mieux la prochaine fois:)");
        println("Appuyez sur entrée");
        readString();
    }
}

/*_______________________________________________________________________________
                               Fonction Resulat + Affichage Calcul
  _______________________________________________________________________________
*/

//ADDITION

    boolean resultatEtAffichageAddition(Joueur joueur){
        int resultat;
        int val1=valRandom(0,100);
        int val2=valRandom(0,100);
        int reponse;

        String calcul=val1+"+"+val2;
        resultat=val1+val2;
        if (joueur.type==TYPE.JOUEUR){
            reponse=(controleSaisieConvertCalcul(calcul));
        }else{
            if (random()>joueur.proba){
                do{
                    reponse=valRandom(resultat-20,resultat+20);
                }while(reponse==resultat || reponse < 0);
                
                
            }else{
                reponse=resultat;
            }
            println(calcul);
            delay(DLAY);
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul,joueur);
        return valide;
    }

//Test Fonctions resultatEtAffichageAddition
    /*void testResultatEtAffichageAddition(){
        int val;
        for (int i = 0 ; i < 200 ; i++){
            val=resultatEtAffichageAddition();
            assertTrue((val>=0)&&(val<=200));
        }
    }*/

//SOUSTRATION
    
    boolean resultatEtAffichageSoustraction(Joueur joueur){
        int resultat;
        int val1=valRandom(0,100);
        int val2=valRandom(0,val1);
        String calcul=val1+"-"+val2;
        resultat=val1-val2;
        int reponse;
        if (joueur.type==TYPE.JOUEUR){
            reponse=(controleSaisieConvertCalcul(calcul));
        }else{
            if (random()>joueur.proba){
                do{
                    reponse=valRandom(resultat-20,resultat+20);
                }while(reponse==resultat || reponse < 0);
                
                
            }else{
                reponse=resultat;
            }
            println(calcul);
            delay(DLAY);
        }
        
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul,joueur);
        return valide;
    }

    //Test Fonctions resultatEtAffichageSoustraction
    /*void testResultatEtAffichageSoustraction(){
        int val;
        for (int i = 0 ; i < 200 ; i++){
            val=resultatEtAffichageSoustraction();
            assertTrue((val>=0)&&(val<=100));
        }
    }*/

//MULTIPLICATION

    boolean resultatEtAffichageMultiplication(Joueur joueur){
        String question;
        int resultat;
        int val1=valRandom(0,10);
        int val2=valRandom(0,10);
        String calcul=val1+"x"+val2;
        resultat=val1*val2;
        int reponse;
        if (joueur.type==TYPE.JOUEUR){
            reponse=(controleSaisieConvertCalcul(calcul));
        }else{
            if (random()>joueur.proba){
                do{
                    reponse=valRandom(resultat-20,resultat+20);
                }while(reponse==resultat || reponse < 0);
                
                
            }else{
                reponse=resultat;
            }
            println(calcul);
            delay(DLAY);
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul,joueur);
        return valide;
    }




//Test Fonctions resultatEtAffichageMultiplication
    /*void tesResultatEtAffichageMultiplication(){
        int val;
        for (int i = 0 ; i < 200 ; i++){
            val=resultatEtAffichageMultiplication();
            assertTrue((val>=0)&&(val<=100));
        }
    }*/
    
//DIVISION

    boolean resultatEtAffichageDivision(Joueur joueur){
        int resultat;
        int val2;
        int val1;
        do{
            val1=valRandom(5,500);
            val2=valRandom(2,val1);
        }while(val1%val2!=0);
        
        String calcul=val1+"/"+val2;
        resultat=val1/val2;
        int reponse;
        if (joueur.type==TYPE.JOUEUR){
            reponse=(controleSaisieConvertCalcul(calcul));
        }else{
            if (random()>joueur.proba){
                do{
                    reponse=valRandom(resultat-20,resultat+20);
                }while(reponse==resultat || reponse < 0);
                
                
            }else{
                
                reponse=resultat;
            }
            println(calcul);
            delay(DLAY);
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul,joueur);
        return valide;
    }

//Test Fonctions resultatEtAffichageesultatEtAffichageDivision
    /*void tesResultatEtAffichageDivision(){
        int val;
        for (int i = 0 ; i < 200 ; i++){
            val=resultatEtAffichageDivision();
            assertTrue((val>=0)&&(val<=100));
        }
    }*/
/*_______________________________________________________________________________
                               Fonctions affcihage reussite ou non
  _______________________________________________________________________________
*/

    void afficheResultatCalcul(int resultat , boolean reussi , int reponse , String calcul ,Joueur joueur){
        String couleur;
        String stringrep = ""+reponse;
        String [] newligne = creerNewLigne(joueur,calcul,stringrep,reussi);

        if (!finJeu){
            if (joueur.type == TYPE.JOUEUR ){
                add(CHEMIN,newligne);

            }
            clearScreenn();
            
            if (reussi){
                couleur="GREEN";
                println("BRAVO !! ");
                print("         "+ calcul + " = ");
                text("GREEN");
                println(reponse);
                text("WHITE");
            }
            else{
                couleur="RED";
                println("MAUVAISE REPONSE :( ");
                print("         "+ calcul + " = ");
                text("RED");
                println(reponse);
                text("WHITE");
                print(" La Bonne Réponse était : " + calcul + " = ");
                text("GREEN");
                println(resultat);
                text("WHITE");
            }
            println("Appuyez sur entrée");
            readString();
        }
    }

/*_______________________________________________________________________________
                  Fonction verification de Saisie et de Conversion
  _______________________________________________________________________________
*/

    boolean estValide(char cara){
        return ((cara>='0')&&(cara<='9'));
    }

    void testEstValideChar(){
        assertFalse(estValide('a'));
        assertFalse(estValide('A'));
        assertFalse(estValide('*'));
        assertFalse(estValide((char)('9'+1)));
        assertFalse(estValide((char)('0'-1)));
        assertTrue(estValide('5'));
        assertTrue(estValide('0'));
        assertTrue(estValide('9'));
    }

    boolean estValide(String entre){
        if (length(entre)==0){
            return false;
        }
        for (int i = 0 ; i<length(entre); i++){
            if (!estValide(charAt(entre,i))){
                return false;
            }
        }
        return true;

    }
     
    
    void testEstValideString(){
        assertTrue(estValide("10"));
        assertTrue(estValide("5"));
        assertFalse(estValide("10*"));
        assertFalse(estValide("1A*0"));
        assertFalse(estValide("BUTINFORMATIQUE"));
        assertFalse(estValide(""));
        assertFalse(estValide(" "));
    }

    int recursifPuissanceDeDix(int puissance){
        if (puissance==0){
            return 1;
        }else{
            return 10*recursifPuissanceDeDix(puissance-1);
        }
    }

    void testRecursifPuissanceDeDix(){
        assertEquals(1,recursifPuissanceDeDix(0));
        assertEquals(100,recursifPuissanceDeDix(2));
        assertEquals(10,recursifPuissanceDeDix(1));
        assertEquals(1000,recursifPuissanceDeDix(3));
        assertNotEquals(10,recursifPuissanceDeDix(0));
    }

    int toInt(String valeur){// Cette fonction peut etre utiliser si la chaine de caractère est bonne
        int resultat = 0;
        int taille=length(valeur);
        int valIntermediaire;
        for(int i = 0 ; i < length(valeur) ; i ++){
            valIntermediaire=(charAt(valeur,i) - '0');
            resultat += (valIntermediaire*(recursifPuissanceDeDix(taille-1)));
            taille-=1;
        }
        return resultat;
    }

    void testToInt(){
        assertEquals(4,toInt("4"));
        assertEquals(13,toInt("13"));
        assertEquals(255,toInt("255"));
        assertNotEquals(4,toInt("13"));
    }


    int controleSaisieConvertCalcul(String calcul){
        String saisie;
        do{
            println(calcul + " Entre Fin pour quitter");
            saisie=readString();
        }while((!equals(toUpperCase(saisie),"FIN")) && !estValide(saisie));
        if (equals(toUpperCase(saisie),"FIN")){
            finJeu=true;
            return -1;
        }
        
        return toInt(saisie);
    }

    /*boolean estValideChoix(String entre){
        if (length(entre)!=1){
            return false;
        }else if (entre<1 || entre>4){
            return false;
        }
        
        return true;

    }//a finir*/





    
    /*int controleSaisieConvertChoixCalc(String calcul){
        String saisie;
        do{
            println(calcul);
            saisie=readString();
        }while(!estValideChoix(saisie));
        
        return toInt(saisie);
    }
/*_______________________________________________________________________________
                               Fonctions Creation Joueur
  _______________________________________________________________________________
*/

    Joueur newJoueur(String nom , String prenom , char couleur){
        Joueur j = new Joueur();
        j.nom=nom;
        j.prenom=prenom;
        j.score=0;
        j.couleur=couleur;
        j.coeur=COEUR;
        j.type=TYPE.JOUEUR;
        j.scoreTempTour=0;
        //j.identifiant=dernier identifiant fichier csv+1
        return j;
    }

    void testNewJoueur(){
        Joueur joueur=newJoueur("Douhab","Illies",'v');
        assertEquals("Douhab",joueur.nom);
        assertEquals("Illies",joueur.prenom);
        assertEquals(0,joueur.score);
        assertEquals(TYPE.JOUEUR,joueur.type);

    }

    Joueur newIA(char couleur){
        String[] nom = new String[]{"M.BASTE ","M.LEPRETRE","M.CARLE \ud83d\udc08","M.SECQ \ud83d\udd34","Mme.TEDJINI","M.LANCIERI","Mme SANTANA MAIA","M.VANUXEM","M.LEBEGUE","M.BRILLET ","M.MATHIEU","M.BENCHIBOUN \u2797","M.CHANFOUIE \ud83d\udcb0","M.DELECROIX"};
        Joueur j = new Joueur();
        j.nom=nom[valRandom(0,length(nom)-1)];
        j.prenom="IA";
        j.score=0;
        j.couleur=couleur;
        j.type=TYPE.IA;
        j.coeur=COEUR;
        //j.identifiant=dernier identifiant fichier csv+1
        return j;
    }

    void testNewIA(){
        Joueur IA=newIA('b');
        println(IA.nom);
        assertEquals("IA",IA.prenom);
        assertEquals(0,IA.score);
        assertEquals(TYPE.IA,IA.type);

    }
    String couleurFonction(Joueur joueur){
        if (joueur.couleur=='v'){
            return "GREEN";
        }else{
            return "BLUE";
        }
    }
    
    void toString(Joueur joueur){
        String couleur =couleurFonction(joueur);

        text(couleur);
        print("Type : ");
        text("RED");
        print(joueur.type);
        text(couleur);
        print("\nNom :");
        text("RED");
        print(joueur.nom );
        text(couleur);
        print("\nPrenom :");
        text("RED");
        print(joueur.prenom );
        text(couleur);
        print("\na un score de ");
        text("RED");
        print(joueur.score);
        text(couleur);
        print("\n nb vie(s) :  ");
        text("RED");
        for (int i = 0 ; i<joueur.coeur; i++){
            print("\u2764\ufe0f ");
        }
        text(couleur);
        print("\n Score Temporaire :  ");
        text("RED");
        print(joueur.scoreTempTour + "\n");
        text("WHITE");

    }

    void testToString(){
        Joueur joueur=newJoueur("Douhab \u265B","Illies",'v');
        toString(joueur);
        Joueur IA;
        IA=newIA('b');
        toString(IA);
        
        
    }
    

    Joueur creerJoueur(char couleur){
        String nom;
        String prenom;
        do{
            println("Veuillez entrez votre prénom (pas plus de "+ TAILLECOLONNE+"): ");
            prenom = readString();
        }while(length(prenom)==0 || length(prenom)>TAILLECOLONNE);
        do{
            println("Veuillez entrez votre nom (pas plus de "+ TAILLECOLONNE+"): ");    
            nom = readString();
        }while(length(nom)==0 || length(prenom)>TAILLECOLONNE);
        
        return newJoueur(nom,prenom,couleur);
    }
/*_______________________________________________________________________________
                               FONCTIONS DE VERIFICATIONS DU SCORE OU DES COEURS
  _______________________________________________________________________________
*/

    boolean gagnant(Joueur [] liste){
            for (int i = 0 ; i<length(liste); i++){
                if (liste[i].score>=MAXSCORE){
                    return true;
                }
            }
            return false;
    }

/*_______________________________________________________________________________
                               FONCTIONS POUR CHAQUE TOUR
  _______________________________________________________________________________
*/

    void tourJoueur(Joueur joueurCourant,int op){

    
        int cpt=0;
        int scoreEnTour;
        int scoreTotTour=0;
        joueurCourant.scoreTempTour=joueurCourant.score;
        while(cpt<NBQUEST && joueurCourant.coeur>0 && !(finJeu)){
                scoreEnTour=calcul(op,joueurCourant);
                scoreTotTour+=scoreEnTour;
                joueurCourant.scoreTempTour+=scoreEnTour;
                cpt+=1;
                toString(joueurCourant);
        }
        if (joueurCourant.coeur<=0){
                scoreTotTour=0;//on retire les points dans la fonctions calcul si le joueur n'a plus de coeurs
        }
        clearScreenn();
        joueurCourant.coeur=COEUR;
        joueurCourant.score+=scoreTotTour;
        cpt=0;
        toString(joueurCourant);
        clearScreenn(); 
            
    }
    void tourIA(Joueur joueurCourant,int op){

    
        int cpt=0;
        int scoreEnTour;
        int scoreTotTour=0;
        joueurCourant.scoreTempTour=joueurCourant.score;
        while(cpt<NBQUEST && joueurCourant.coeur>0){
                scoreEnTour=calcul(op,joueurCourant);
                scoreTotTour+=scoreEnTour;
                joueurCourant.scoreTempTour+=scoreEnTour;
                cpt+=1;
                toString(joueurCourant);
                
            }
            if (joueurCourant.coeur<=0){
                scoreTotTour=0;//on retire les points dans la fonctions calcul si le joueur n'a plus de coeurs
            }
            joueurCourant.coeur=COEUR;
            joueurCourant.score+=scoreTotTour;
            cpt=0;
            toString(joueurCourant);
            
    }


    void joueurDansPartie(Joueur[] lst){
        String choix;
        lst[0]=creerJoueur('v');
        do{
            print("Voulez-vous jouer contre une IA ou contre un autre Joueur ? : (IA / JR)");
            choix = toUpperCase(readString());
        }while(!(equals(choix,"IA"))&&!(equals(choix,"JR")));
        if (equals(choix,"IA")){
            lst[1]=newIA('b');
        }else{
            lst[1]=creerJoueur('b');
        }
        clearScreenn();
    }


/*_______________________________________________________________________________
                               SAUVEGARDE
  _______________________________________________________________________________
*/


    void add(String chemin, String [] ligAdd){
        String [][]fichierTab=new String[nbLignes(chemin)+1][nbColonne(chemin)];
        recreerTab(chemin,fichierTab);
        fichierTab[nbLignes(chemin)]=ligAdd;
        saveCSV(fichierTab,chemin);
    }

    void recreerTab(String chemin, String [][]tab){
        for (int i = 0 ; i<nbLignes(chemin); i=i+1 ){
            for(int z = 0 ; z<nbColonne(chemin); z=z+1 ){
                tab[i][z]=cellu(chemin,i,z);
                
            }   
        }
    }

    void resetFile(String chemin){
        String [][]fichierTab=new String[1][nbColonne(chemin)];
        for (int i = 0 ; i<length(fichierTab,2);i++){
            fichierTab[0][i]=cellu(chemin,0,i);
        }
        saveCSV(fichierTab,chemin);
    }

    String cellu(String chemin,int lig,int col){
       return getCell(loadCSV(chemin),lig,col);
    }

    int nbLignes(String cheminFichier){
        return rowCount(loadCSV(cheminFichier));
    }

    int nbColonne(String cheminFichier){
        return columnCount(loadCSV(cheminFichier));
    }

    String [] creerNewLigne(Joueur joueur, String question, String reponse, boolean trueOrFalse){
        String [] newLine = new String[nbColonne(CHEMIN)];
        String scoreTempTour = "" + joueur.scoreTempTour;
        String coeur= "" + joueur.coeur;
        String vraiOuFaux ="";
        String sCouleur = "" + joueur.couleur;
        if(trueOrFalse == true){
            vraiOuFaux = "true";
        }else{
            vraiOuFaux = "false";
        }

        newLine[0] = joueur.nom;
        newLine[1] = joueur.prenom;
        newLine[2] = scoreTempTour;
        newLine[3] = coeur;
        newLine[4] = question;
        newLine[5] = reponse;
        newLine[6] = vraiOuFaux;
        newLine[7] = sCouleur;
        return newLine;
    }

    void enregistrerScore(Joueur [] lst , String chemin){
        String [] newLine = new String[nbColonne(chemin)];
        for (int i = 0 ; i<length(lst);i++){
            if (lst[i].type==TYPE.JOUEUR){
                newLine[0]=lst[i].nom;
                newLine[1]=lst[i].prenom;

                newLine[2]=""+lst[i].score;
            }
        }
        add(chemin,newLine);
    }

/*_______________________________________________________________________________
                               PASSAGE DE LIGNES
  _______________________________________________________________________________
*/

    void clearScreenn(){
        for (int i = 0 ; i<45 ; i++){
            println();
        }
    }

/*_______________________________________________________________________________
                               ALGORITHME PRINCIPAL
  _______________________________________________________________________________
*/
    void partie(){
        int op=1;
        String opera;
        int numeroTour=0;
        
        int nb_jr=2;
        Joueur joueurCourant;
        Joueur [] lstJoueur= new Joueur[nb_jr];
        joueurDansPartie(lstJoueur);//Ici on va creer les joueurs present
        toString(lstJoueur[0]);
        println("Appuyez sur entrée");
        readString();
        clearScreenn();
        toString(lstJoueur[1]);
        println("Appuyez sur entrée");
        readString();
        clearScreenn();
        boolean fin;
        joueurCourant=lstJoueur[numeroTour%nb_jr];
        sceanrio(lstJoueur);
        println("Appuyez sur entrée");
        readString();
        while (!gagnant(lstJoueur) && !(finJeu)){


            joueurCourant=lstJoueur[numeroTour%nb_jr];
            
            println("AU TOUR DE : ");
            text(couleurFonction(joueurCourant));
            println(joueurCourant.nom +" "+ joueurCourant.prenom);
            
            if (joueurCourant.type==TYPE.IA){
                println("Choisis un Opérateur : \n + ou "+ PLUS + "\n - ou "+ MOINS +"\n x ou "+ MULTIPLICATION +"\n / ou "+ DIVISION);
                println(op);
                delay(DLAY);
                tourIA(joueurCourant,op);
        
            }else{
                do{
                    println("Choisis un Opérateur : \n + ou "+ PLUS + "\n - ou "+ MOINS +"\n x ou "+ MULTIPLICATION +"\n / ou "+ DIVISION + " Entre Fin pour quitter");
                    opera=readString(); 
                }while(!verificationOp(opera));
                if (!finJeu){
                    op = convertToInt(charAt(opera,0));
                    tourJoueur(joueurCourant,op);
                }
                
                
                
            }
            
            numeroTour+=1;
        }
        afficherClassement(lstJoueur);
        enregistrerScore(lstJoueur , HIGHSCORE);
        resetFile(CHEMIN);
        
        //reumepartie(joueurCourant,)
        
    }

    boolean verificationOp(String operation){
        if (length(operation)<1){
            return false;
        }else if (equals(toUpperCase(operation),"FIN")){
            finJeu=true;
            return true;
        
        }else if (charAt(operation,0)=='+' || charAt(operation,0)=='*' || charAt(operation,0)=='-' || charAt(operation,0)=='/' || charAt(operation,0)==(char)('0'+PLUS) || charAt(operation,0)==(char)('0'+MOINS)  || charAt(operation,0)==(char)('0'+MULTIPLICATION)  || charAt(operation,0)==(char)('0'+DIVISION) && (length(operation)==1)){
            return true;
        }
        return false;
    }

    int convertToInt(char op){
        if (op == '+' || op==(char)('0'+PLUS)){
            return PLUS;
        }
        else if (op == '-' || op==(char)('0'+MOINS)){
            return MOINS;
        }
        else if (op == '*' || op==(char)('0'+MULTIPLICATION)){
            return MULTIPLICATION;
        }
        else if (op == '/' || op==(char)('0'+DIVISION)){
            return DIVISION;
        }
        return 1;
    }

    String[][] resumePartie(Joueur [] lst){
        
        int numLig=1;
        CSVFile file  = loadCSV(CHEMIN);
        String[][] tabfile = new String[nbLignes(CHEMIN)][nbColonne(CHEMIN)];

        if (lst[1].type==TYPE.IA){
            for (int i = 0; i < rowCount(file); i++){
                for (int j = 0; j < columnCount(file); j++){
                    tabfile[i][j] =  getCell(file,i,j);
                    while(length(tabfile[i][j])<12){
                            tabfile[i][j]+=" ";
                    }
                    tabfile[i][j]+="|";
                }
             }
        }else{
            for (int z = 0; z < columnCount(file); z++){
                    tabfile[0][z] =  getCell(file,0,z);
                    while(length(tabfile[0][z])<12){
                            tabfile[0][z]+=" ";
                    }
                    tabfile[0][z]+="|";
            }

            for (int i = 0; i < rowCount(file); i++){
                if (equals(getCell(file,i,columnCount(file)-1),"" +lst[0].couleur)){
                    for (int j = 0; j < columnCount(file); j++){
                    
                        tabfile[numLig][j] =  getCell(file,i,j);
                        while(length(tabfile[numLig][j])<12){
                            tabfile[numLig][j]+=" ";
                        }   
                        tabfile[numLig][j]+="|";

                    }
                    numLig+=1;
                }
                
                
            }
            for (int i = 0; i < rowCount(file); i++){
                if (equals(getCell(file,i,columnCount(file)-1),"" +lst[1].couleur)){
                    for (int j = 0; j < columnCount(file); j++){
                        tabfile[numLig][j] =  getCell(file,i,j);
                        
                        while(length(tabfile[numLig][j])<12){
                            tabfile[numLig][j]+=" ";
                        }
                        tabfile[numLig][j]+="|";
                        
                    }
                    numLig+=1;
            }
        
            }    
        }
        return tabfile;
    }
        

    

    void affichageTb(String [][] resume){
        
        for (int i = 0 ; i < length(resume,1); i ++){
            for (int j = 0 ; j < length(resume,2); j ++){
                print(resume[i][j]);
            }
            println();
        }
    }

    void afficherClassement(Joueur [] lst){
        affichageTb(resumePartie(lst));
    }

    void algorithm(){
        println("BONJOUR ET BIENVENUE");
        String choix;
        String [][] classement;
        String motDePasse="WeLoveEL";
        String entreeMdp;
        int essai=-1;
        boolean fini=false;
        do{

        
            do{
                
                
                println("Que Souhaitez vous faire");
                println("1 / Jouer \n 2 / Afficher les Scores \n 3 / Afficher le podium \n 4 / Sortir");
                choix=readString();
            }while(!equals(choix,"1")&&!equals(choix,"2")&&!equals(choix,"3")&&!equals(choix,"4"));
            if (equals(choix,"1")){
                finJeu=false;
                partie();
            }else if (equals(choix,"4")){
                fini=true;;
            }else{
                
                do{
                    essai+=1;
                    println("Entrez votre mot de passe pour accéder au Tableau des scores :  (Plus que " + (TENTATIVES-essai) + " tentatives)");
                    entreeMdp=readString();
                }while((!equals(entreeMdp,motDePasse)&&(essai<TENTATIVES-1)));
                
                if (essai<TENTATIVES-1){
                    essai=-1;
                    if (equals(choix,"2")){
                        classement=genererTabHighScore();
                        trier(classement);
                        afficherScore(classement);
                    }else{
                        classement=genererTabHighScore();
                        trier(classement);
                        afficherPodium(classement);
                    }
                }
            }
        }while(!fini);
        println("Merci d'avoir participé au VillageDeGosses \n made by Douhab Illies &  Moyon Xavier \n Nous ésperons que notre jeu vous a plu et que nous nous reverrons bientot pour de nouvelles aventures de Mathématiques ;) ");

        
        
    }

    
    String [][] genererTabHighScore(){
        CSVFile file  = loadCSV(HIGHSCORE);
        String[][] tabfile = new String[nbLignes(HIGHSCORE)][nbColonne(HIGHSCORE)];
        for (int i = 0; i < rowCount(file); i++){
               
            for (int j = 0; j < columnCount(file); j++){
                    
                tabfile[i][j] =  getCell(file,i,j);

            }
        }
        return tabfile;
                

    }
    void trier(String [][] tab){
        int idxMin;
        String [] valInter;
        for (int i = 1; i<length(tab,1)-1;i++){
            idxMin=i;
            for (int z = i+1; z<length(tab,1);z++){
                if (toInt(tab[idxMin][2])>toInt(tab[z][2])){
                    idxMin=z;
                }
            }
            valInter=tab[idxMin];
            tab[idxMin]=tab[i];
            tab[i]=valInter;
            
        }
    }

    void afficherScore(String [][] tab){
        String valeur;
        println();
        for (int j = 0; j < length(tab,2); j++){
                valeur=tab[0][j];
                while(length(valeur)<12){
                        valeur+=" ";
                }
                valeur+="|";
                print(valeur);
            }
            println();
        for (int i = length(tab,1)-1; i >=1; i--){
            for (int j = 0; j < length(tab,2); j++){
                valeur=tab[i][j];
                while(length(valeur)<12){
                        valeur+=" ";
                }
                valeur+="|";
                print(valeur);
            }
            println();
        }
    }

    void afficherPodium(String [][] tab){
        String valeur;
        println();
        for (int j = 0; j < length(tab,2); j++){
                valeur=tab[0][j];
                while(length(valeur)<12){
                        valeur+=" ";
                }
                valeur+="|";
                print(valeur);
            }
            println();
        int cpt=1;
        while(cpt<length(tab) && cpt<4){
            for (int j = 0; j < length(tab,2); j++){
                valeur=tab[length(tab)-(cpt)][j];
                while(length(valeur)<12){
                        valeur+=" ";
                }
                valeur+="|";
                print(valeur);
            }
            cpt+=1;
            println();
        }
    }



    void sceanrio(Joueur [] j){
        afficherFichier("./Chteau");


        entieParle(j[1].nom + " et vous avez été téporté sur L'ile des Gosses, pour paticiper un jeu." );
        entieParle("Si vous souhaitez retourner dans votre monde vous devrez choisir un opérateur et repondre correctement aux questions posée");
        entieParle("Vue qu'il n'y a qu'un teleporteur le gagnant sera celui qui obtient 500 point en premier.");
    }


    void entieParle(String phrase){
	println(NOM + " : " + phrase);
	delay(300);
    }


    void afficherFichier(String chemin){
	File unTexte = newFile(chemin);
        while(ready(unTexte)){
            println(readLine(unTexte));
        }
    }


    /*void algorithm(){
        Joueur ia;
        for (int i = 0 ; i<20 ; i++){
            ia=newIA();
            toString(ia);
        }
    }*/


}


/*TO do List :
    -Systeme de joueur(changement)
    -Systeme de Recompenses
    -Systeme Graphique
    -Systeme Sauvegarde

*/

















































































































