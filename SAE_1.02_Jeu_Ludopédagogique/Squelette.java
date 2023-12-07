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


----------------------------------------------------------------------------------
 Fonctions De Calcul : 
 */
class LeVillageDeGauss extends Program{

    //Ici on initialise les valeurs associés aux opérateurs

/*_______________________________________________________________________________
                               Fonction Retire Points Joueur et coeurs
  _______________________________________________________________________________
*/

    final int PLUS = 1;
    final int MOINS = 2;
    final int MULTIPLICATION = 3;
    final int DIVISION = 4 ;

    final int POINTPLUS = 10;
    final int POINTMOINS = 15;
    final int POINTMULTIPLICATION = 20;
    final int POINTDIVISION = 25;

    final int COEUR = 3;
    final int NBQUEST = 5;/*_______________________________________________________________________________
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
        delay(1000);
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
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul);
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
        }
        
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul);
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
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul);
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
            val1=valRandom(5,100);
            val2=valRandom(1,val1);
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
        }
        boolean valide = (reponse == resultat);
        afficheResultatCalcul(resultat,valide,reponse,calcul);
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

    void afficheResultatCalcul(int resultat , boolean reussi , int reponse , String calcul){
        String couleur;
        for (int i = 0 ; i<40 ; i++){
            println();
        }
        
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
            println(calcul);
            saisie=readString();
        }while(!estValide(saisie));
        
        return toInt(saisie);
    }

/*_______________________________________________________________________________
                               Fonctions Creation Joueur
  _______________________________________________________________________________
*/

    Joueur newJoueur(String nom , String prenom){
        Joueur j = new Joueur();
        j.nom=nom;
        j.prenom=prenom;
        j.score=0;
        j.coeur=COEUR;
        j.type=TYPE.JOUEUR;
        j.scoreTempTour=0;
        //j.identifiant=dernier identifiant fichier csv+1
        return j;
    }

    void testNewJoueur(){
        Joueur joueur=newJoueur("Douhab","Illies");
        assertEquals("Douhab",joueur.nom);
        assertEquals("Illies",joueur.prenom);
        assertEquals(0,joueur.score);
        assertEquals(TYPE.JOUEUR,joueur.type);

    }

    Joueur newIA(){
        String[] nom = new String[]{"M.BASTE ","M.LEPRETRE","M.CARLE \ud83d\udc08","M.SECQ \ud83d\udd34","Mme.TEDJINI","M.LANCIERI","Mme SANTANA MAIA","M.VANUXEM","M.LEBEGUE","M.BRILLET ","M.MATHIEU","M.BENCHIBOUN \u2797","M.CHANFOUIE \ud83d\udcb0","M.DELECROIX"};
        Joueur j = new Joueur();
        j.nom=nom[valRandom(0,length(nom)-1)];
        j.prenom="IA";
        j.score=0;
        j.type=TYPE.IA;
        j.coeur=COEUR;
        //j.identifiant=dernier identifiant fichier csv+1
        return j;
    }

    void testNewIA(){
        Joueur IA=newIA();
        println(IA.nom);
        assertEquals("IA",IA.prenom);
        assertEquals(0,IA.score);
        assertEquals(TYPE.IA,IA.type);

    }

    void toString(Joueur joueur){
        print("Type : ");
        text("RED");
        print(joueur.type);
        text("WHITE");
        print("\nNom :");
        text("RED");
        print(joueur.nom );
        text("WHITE");
        print("\nPrenom :");
        text("RED");
        print(joueur.prenom );
        text("WHITE");
        print("\na un score de ");
        text("RED");
        print(joueur.score);
        text("WHITE");
        print("\n nb vie(s) :  ");
        text("RED");
        for (int i = 0 ; i<joueur.coeur; i++){
            print("\u2764\ufe0f ");
        }
        text("WHITE");
        print("\n Score Temporaire :  ");
        text("RED");
        print(joueur.scoreTempTour + "\n");
        text("WHITE");

    }

    void testToString(){
        Joueur joueur=newJoueur("Douhab \u265B","Illies");
        toString(joueur);
        Joueur IA;
        IA=newIA();
        toString(IA);
        
        
    }
    

    Joueur creerJoueur(){
        println("Veuillez entrez votre prénom : ");
        String prenom = readString();
        println("Veuillez entrez votre nom : ");    
        String nom = readString();
        return newJoueur(nom,prenom);
    }
/*_______________________________________________________________________________
                               FONCTIONS DE VERIFICATIONS DU SCORE OU DES COEURS
  _______________________________________________________________________________
*/

    boolean gagnant(Joueur [] liste){
            for (int i = 0 ; i<length(liste); i++){
                if (liste[i].score>=500){
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
                delay(2500);
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
        lst[0]=creerJoueur();
        do{
            print("Voulez-vous jouer contre une IA ou contre un autre Joueur ? : (IA / JR)");
            choix = readString();
        }while(!(equals(choix,"IA"))&&!(equals(choix,"JR")));
        if (equals(choix,"IA")){
            lst[1]=newIA();
        }else{
            lst[1]=creerJoueur();
        }
    }

/*_______________________________________________________________________________
                               ALGORITHME PRINCIPAL
  _______________________________________________________________________________
*/
    void algorithm(){
        int op=1;
        int numeroTour=0;
        
        int nb_jr=2;
        Joueur joueurCourant;
        Joueur [] lstJoueur= new Joueur[nb_jr];
        joueurDansPartie(lstJoueur);
        //lstJoueur[0]=creerJoueur();
        //lstJoueur[1]=newIA();
        toString(lstJoueur[0]);
        toString(lstJoueur[1]);
        joueurCourant=lstJoueur[numeroTour%nb_jr];
        while (!gagnant(lstJoueur)){

            println("DANS GRANDE BOUBLE");

            joueurCourant=lstJoueur[numeroTour%nb_jr];
            
            println("AU TOUR DE : ");
            println(joueurCourant.nom + joueurCourant.prenom);
            
            if (joueurCourant.type==TYPE.IA){
                println("Choisis un Opérateur : \n + = "+ PLUS + "\n - = "+ MOINS +"\n x = "+ MULTIPLICATION +"\n / = "+ DIVISION);
                println(op);
                delay(1000);
                tourIA(joueurCourant,op);
                delay(1000);
            }else{
                println("Choisis un Opérateur : \n + = "+ PLUS + "\n - = "+ MOINS +"\n x = "+ MULTIPLICATION +"\n / = "+ DIVISION);
                op=readInt();
                tourJoueur(joueurCourant,op);
            }
            
            numeroTour+=1;
        }
        
        toString(joueurCourant);
        
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