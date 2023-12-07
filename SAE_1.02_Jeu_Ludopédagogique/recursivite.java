class recursivite extends Program{

    int rOccurence(String mot , char car){
        if (length(mot)==0){
            return 0;
        }else if (charAt(mot,0)==car){
            return 1+rOccurence(subString(1,length(mot)));
        }else{
            return rOccurence(subString(1,length(mot)));
        }
    }

    void testrOcurrence(){
        assertEquals(0,rOccurence("cannelle" , 'x'));
        assertEquals(2,rOccurence("cannelle" , 'n'));
        assertEquals(0,rOccurence("" , 'n'));
        assertEquals(0,rOccurence("cannelle" , ' '));
        assertEquals(1,rOccurence("cannelle" , 'c'));
        assertEquals(2,rOccurence("cannelle" , 'e'));
    }
}