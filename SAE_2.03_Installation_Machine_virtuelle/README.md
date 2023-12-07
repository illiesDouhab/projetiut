# **SAE 2.03 by Illies Douhab / Xavier Moyon / Nathan Vasset**

Vous trouverez ci-joint un fichier commande.sh ainsi que un fichier SAE_2.03.md. Pour creer le fichier HTML et PDF executer la commande `./commande.sh` (assurez-vous d'etre dans le répertoire du fichier)

## **Guide D'instalation**
Ce guide présente les différentes étapes pour installer Debian.

### **Prérequis** 
Pour l'instalation de Debian 
- Une machine compatible debian 
- Un support d'installation tels que un DVD, ou une clef bootable préconfigurer, sinon vous pouvez la configurer en installant l'iso et creer une clef bootable grace au logicele [RUFUS](https://rufus.ie/fr/) 
- Une conexion Internet est recommandé pour télécharger les paquets supplémentaires pendant l'installation 

Maintenant de lancer votre machine avec votre support, de l'executer lors du lancement de la machine et de suivre les étapes du MarkDown (SAE_2.03.md)

Pour pouvoir voir le fichier pandoc :
- Installtion de pandoc :  `sudo apt insyall pandoc `
- Installer PdfLatex : `sudo apt-get install texlive-fonts-recommended `
- Executer la commande `./commande.sh`


### **Question de la sae**
Toutes les questions posé lors des SAE sont présentes dans le MarkDown entre les différente étape d'installation.

### **la commande `./commande.sh`**
la commande `./commande.sh` permet de creer les fichier HTML et PDF grace a deux ligne de commande :
- `pandoc --standalone --toc  -o ./SAE_2.03_PDF.pdf ./SAE_2.03.md;`
- `pandoc --standalone --toc --css=./style.css -o ./SAE_2.03_HTML.html ./SAE_2.03.md --metadata title="SAE_2.03";`

`**./commande.sh` est programme de convertion de fichier entre les formats de balisage 


# **Lien Video Explicative En Anglais**

https://www.youtube.com/watch?v=sQVC-XPwBXs
