class TestCsv extends Program{

    final String NOM_FICHIER = "test.csv";
    final String NOM_REPERTOIRE = "./";

    void algorithm(){
        println(choixFichier());
        String chemin="./test.csv";
        affichage(chemin);
        String [] [] tab= new String[] []{{"A1,B1,C1"},{"A2,B2,C2"}};
        saveCSV(tab , "illiesBEbou.csv");
        String[]ligInc=new String[]{"A6","B6","C6"};
        add(chemin,ligInc);
    }


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
                println("i" + i + " z " + z);
            }

            
        }
        
    }

    String cellu(String chemin,int lig,int col){
       return getCell(loadCSV(chemin),lig,col);
    }

    void affichage(String chemin){
        for (int i = 0 ; i<nbLignes(chemin); i=i+1 ){
            println();
            for(int z = 0 ; z<nbColonne(chemin); z=z+1 ){
                print(cellu(chemin,i,z)+ " | ");
            }
            
        }
        println();
    }

    int nbLignes(String cheminFichier){
        return rowCount(loadCSV(cheminFichier));
    }

    int nbColonne(String cheminFichier){
        return columnCount(loadCSV(cheminFichier));
    }

    String choixFichier(){
        String[] files=getAllFilesFromDirectory(NOM_REPERTOIRE);
        int cpt=-1;
        String file;
        do{
            cpt+=1;
            println("cpt = " + cpt + " Nom Fichier = " + files[cpt]);
        }while(!equals(files[cpt],NOM_FICHIER) && cpt<length(files)-1);
        file=files[cpt];
        return files[cpt];
    }
    


}