Rapport_Final_Illies_Xavier_Nahtan

# SAE2.03

Bonjour, nous sommes _**Douhab Illies**_, _**Vasset Nathan**_ et _**Moyon Xavier**_, nous sommes heureux de vous présenter notre projet de SAE.


# Configuration de notre Machine

## La Configuration Matériel de Notre Machine Virtuelle

1.  Type : **[Linux](https://www.journaldunet.fr/web-tech/guide-de-l-entreprise-digitale/1091588-kernel-linux-open-source-8/)**
La famille de systèmes d'exploitation Linux ou GNU/Linux est basée sur le noyau Linux et appartient à la catégorie des systèmes d'exploitation open source de type Unix.

2.  Version : **[Debian 64 bit](https://www.debian.org/releases/jessie/mips/ch01s03.html.fr)**,
Debian est un système d'exploitation construit par le projet Debian, qui se distingue par son utilisation du noyau Linux et par les logiciels inclus dans Debian qui sont des logiciels libres.

![Sélection Type et Version](https://cdn.discordapp.com/attachments/1077716382319386807/1078663816717549618/image.png)
  
3. Mémoire vive (RAM) : **[2048](https://www.kingston.com/fr/blog/pc-performance/difference-between-memory-storage)**
La RAM de votre PC, ou mémoire vive, est un type de réservoir de stockage d’informations temporaire utilisé par le processeur. Par conséquent, elle est essentielle pour le fonctionnement de l’ordinateur.

![Mémoire Vive](https://media.discordapp.net/attachments/1077716382319386807/1078663924477612032/image.png)
  
4. Disque dur : **[20 Go entier](https://www.kingston.com/fr/blog/pc-performance/difference-between-memory-storage)**  
Le stockage est la composante de votre ordinateur qui permet de conserver et d'accéder aux données à long terme.

![Disque dur](https://media.discordapp.net/attachments/1077716382319386807/1078663924746027049/image.png)

### Questions :

1.  > Que signifie **64-bit** dans “Debian 64-bit”

     *Tout d’abord [Debian](https://www.debian.org/releases/jessie/mips/ch01s01.html.fr) est un système d'exploitation libre et open source basé sur Linux, il propose beaucoup de logiciel open source, et aussi de nombreux outils de gestion de paquets pour mettre à jour, installer , supprimer des logiciels.
“[64-bit](https://lecrabeinfo.net/32-ou-64-bits-comment-savoir.html)" fait référence à architecture du processeur utilisé pour exécuter le systeme d’exploitation Deabian, l’architecture peut traiter des données en blocs de 64 bits en même temps, contrairement à une architecture 32 bits. Ce qui permet d’obtenir de meilleur performance avec cette architecture*
    

    
  2.  > Quel est la configuration réseau utilisée par défaut ?

      ***[DHCP](https://learn.microsoft.com/fr-fr/windows-server/networking/technologies/dhcp/dhcp-top)**  **(Dynamic Host Configuration Protocol)** est la configuration réseau utilisé par défaut, cette dernière permet de configurer les adresse IP automatiquement des leurs connexion au réseau local*
    

 
3.  > Quel est le nom du fichier XML contenant la configuration de votre machine

- *Le [XML](https://www.journaldunet.fr/web-tech/dictionnaire-du-webmastering/1203615-xml-extensible-markup-language-definition-traduction/) **(Extensible Markup Language)** est un langage utilisant des balises, il décrit et structure des données.*

    *Vous pouvez trouver le fichier de configuration XML á cet emplacement : usr/local/virtual_machine/infoetu/@login/sae203/**sae203.vbox-prev***
    
- *Le nom du fichier est le suivant : **sae203.vbox-prev***


4.  > Sauriez vous le modifier directement le fichier pour mettre 2 processeurs à votre machine ?

     *Tout d'abord ajouter un processeur dans une machine permet d'augmenter les performances de cette machine, ainsi plusieurs taches peuvent s'exécuter en parallèle*

     *Si vous souhaitez ajouter un nouveau processeur a votre machine vous pouvez modifier ce fichier afin d’y ajouter ceci :*
        
        `Count="2"`
        
       *Vous devez ajouter cette commande dans cette partie du fichier XML :*
        
        
         <CPU count="2">
        
        
        

## Installation de l’OS

Nous avons installé l’OS avec la configuration suivante :

-   Nom de la machine (à l’installation) : **serveur**
-   Pays/langue : **France**
    
    ![Sélection Langage](https://media.discordapp.net/attachments/1077716382319386807/1078656129489440818/image.png)
    
- [Miroir](linuxtricks.fr/news/10-logiciels-libres/393-mirrorservice-org-un-miroir-linux-qui-depote/) : [http://debian.polytech-lille.fr](http://debian.polytech-lille.fr) : Un miroir est un type de serveur (HTTP, FTP ou RSYNC) qui stocke et diffuse des ISO ou des paquets de distributions Linux.
    
    ![Sélection Miroir](https://media.discordapp.net/attachments/1077716382319386807/1078657236081070110/image.png)
    
-   [Compte administrateur](https://help.ubuntu.com/kubuntu/desktopguide/fr/root-and-sudo.html) : **root** / **root**
Le super-utilisateur (root) dans GNU/Linux est l'utilisateur qui a les droits d'accès administratifs à votre système. Les utilisateurs normaux n'ont pas ces droits pour des raisons de sécurité. 

    ![Creation root](https://media.discordapp.net/attachments/1077716382319386807/1078656384473780354/image.png)
    
-   Un Compte utilisateur : User / user / user  
    ![Creation User](https://media.discordapp.net/attachments/1077716382319386807/1078656485581660160/image.png)
    
   - [Partition](https://www.data-labcenter.fr/news-et-reportages/conseils-et-generalites/le-partitionnement-dun-disque-dur/) : 1 seule partition recouvrant le disque entier : 
    
    ![Partition du disque dure](https://media.discordapp.net/attachments/900428634664370268/1088465312808177725/image.png?width=720&height=538)




    
-   **Sélection des logiciels de démarrage :**
    
    -   environnement de bureau Debian
    -   [MATE](https://wiki.debian.org/fr/MATE#:~:text=Qu'est%20ce%20que%20MATE,autres%20syst%C3%A8mes%20d'exploitations%20Unix.) (penser à décocher Gnome)
    -   [serveur web](https://www.lemagit.fr/definition/Serveur-Web)
    -   [serveur ssh](https://doc.ubuntu-fr.org/ssh)
    -   utilitaire usuels du système  
    (les utilitaires usuels du système sont des logiciels intégrés au système récent, ces programmes permettent notamment de faciliter la gestion du système)
        
        ![Choix Logiciels](https://media.discordapp.net/attachments/1077716382319386807/1078657914190975066/image.png)

### Questions

1.  > Qu’est-ce qu’un fichier iso bootable ?
    
	-   _Un fichier iso est un fichier d’archive qui contient une copie identique des données trouvées sur un disque optique_.
    -   _Un fichier iso est considéré comme bootable lorsque qu’il peut être exécuté dès le lancement de la machine avant même le chargent de l’OS de la machine_.  
        –\> Un ficher iso bootable est donc une copie identique des données trouvées sur un disque optique et qui peut être exécuté dès le lancement de la machine avant même le chargement de l’OS
2.  > Qu’est-ce que MATE ? GNOME ?
    
    _MATE et GNOME sont des environnements de bureau graphique qui rendent l’utilisation du système plus intuitive, ils sont présents sur plusieurs systèmes comme Linux ou Unix par exemple_
    
3.  > Qu’est-ce qu’un serveur web ?
    
    _Un [serveur web](https://developer.mozilla.org/fr/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server) est un programme informatique qui tourne sur un ordinateur connecté à Internet, et dont le rôle est de répondre aux requêtes HTTP émises par les navigateurs. Il a pour fonction d'envoyer des fichiers, tels que des pages HTML, des images, des fichiers CSS, des scripts, etc., aux ordinateurs des utilisateurs qui les ont demandés._
    
4.  > Qu’est-ce qu’un serveur ssh ?
    
     _Le [serveur SSH](https://www.journaldunet.fr/web-tech/dictionnaire-du-webmastering/1203479-ssh-secure-shell-definition-traduction/), ou Secure Shell, est un programme informatique qui permet de se connecter et de communiquer en toute sécurité avec un ordinateur distant. Il fonctionne en utilisant le protocole SSH pour établir une connexion cryptée entre un client SSH et le serveur SSH distant._
    
5.  > Qu’est-ce qu’un serveur mandataire ?

    _le nom serveur mandataire est le nom français du "[proxy server](https://www.varonis.com/fr/blog/serveur-proxy)", le serveur mandataire  est un serveur intermédiaire sur Internet qui stocke temporairement les données afin de faciliter leur accès._
   

## Préparation du système

### Ajout de droits administrateur á un utilisateur (@user)

-   On doit tout d’abord être en tant qu’administrateur, pour cela on exécute la commande suivante :
    
    `su -`
    
-   Ensuite entrer la commande suivante vous permettant d’ajouter l’utilisateur au groupe administrateurs (sudo)
    
    `usermod -aG sudo @user`
    

#### Question

1.  > Comment peut-on savoir à quels groupes appartient l’utilisateur user ?

      _Chaque utilisateur appartient à un ou plusieurs groupe(s) (s'il appartient à plusieurs groupes l'un d'entre eux sera son principal groupe)._
       *Pour savoir quel groupe appartient un utilisateur , il faut regarder dans le fichier **/etc/group** .
    Ou alors on uttilise la commande suivante :*
    
    ```
    groups @user 
    ```
    

### Installation des suppléments invités

   Pour monter le cd on utilise la commande suivante :  
          `sudo mount /dev/cdrom /mnt`


![cdrom](https://media.discordapp.net/attachments/1077716382319386807/1078667114887528448/image.png)

Ensuite on utilise la commande suivante pour installer les suppléments :

```
sudo /mnt/VBoxLinuxAdditions.run
```


![additions](https://media.discordapp.net/attachments/1077716382319386807/1078667398720278558/image.png)

#### Questions

1.  > Quel est la version du noyau Linux utilisé par votre VM ? N’oubliez pas, comme pour toutes les questions, de justifier votre réponse
    
    
    *Le [noyau Linux](https://linux.goffinet.org/administration/processus-et-demarrage/noyau-linux/) est le composant central du système d'exploitation Linux. Il est développé sous licence libre et open source et joue un rôle essentiel en gérant les ressources matérielles de l'ordinateur, tout en permettant aux logiciels de communiquer avec le matériel en question
    Pour connaitre la version de noyaux linux on utilise la commande suivant :*
    
    `uname -mr`  
    
    ![uname -mr](https://media.discordapp.net/attachments/1077716382319386807/1078666411414671421/image.png)
    
    *On obtient donc que la version du noyau est la suivante : **`5.10.0-21-amd64`**
    
    -   *Le 5 pointe vers la version principale du noyau*
    -   *Le .10 pointe vers la version majeur*
    -   *Le .0 pointe vers la version mineur*
    -   *Le -21 représente le niveau des correctifs et le niveau des bugs*
    
2.  > À quoi servent les suppléments invités ? Donner 2 principales raisons de les installer.
    
    *Les [suppléments invités](https://docs.oracle.com/cd/E26217_01/E35193/html/qs-guest-additions.html) sont une série d’extensions permettant d’améliorer l’utilisation de notre machine virtuelle, notamment en permettant d’adapter la résolution de l’affichage automatique par rapport a notre machine physique ainsi que de permettre d’effectuer des “copier-coller” / déplacer des éléments de notre machine physique vers notre machine virtuelle et inversement.*
    
3.  > À quoi sert la commande `mount` (Dans notre cas et dans le cas général)
    
    *Dans notre cas cette commande sert a configurer/mettre en place les extensions et dans le cas générale elle sert pour mettre en place des fichier de configuration( **iso** par exemple )*
    
## Installation Logiciel Utile 

- Installation environnement graphique MATE :
	- Connectez-vous en root
	
	- Utilisez la commande `apt install task-mate-desktop`
	
	- Redémarrez votre machine avec la commande `reboot`
	
-	sudo : sinon la gestion sudo est inutile :
	- Pour cela vous devez être en `root` vous pouvez utiliser la commande `su -` il vous suffira de rentrer votre mot de passe root 
	
	![passer en root](https://cdn.discordapp.com/attachments/900428634664370268/1086929654151135342/image.png)

	-	Maintenant que vous êtes en `root`vous pouvez télécharger   `sudo`
	
	![installation root](https://cdn.discordapp.com/attachments/900428634664370268/1086930390247280670/image.png)


	- Maintenant vous allez pouvoir utiliser les commandes root depuis votre session utilisateur en utilisant `sudo [commande]` ( il se peut que votre mot de passe utilisateur vous soit demandé)


-	Installation logiciel en générale :
	- Maintenant que vous possédez `sudo` attribuer les droits sudo via `root`
	- Vous pouvez, alors faire `exit` et retourner sur votre compte `user`
	
	- Pour télécharger des logiciels il faut en général utiliser `sudo apt install [nom_package]`
		- Exemple avec git :
	
	![exemple installation git](https://cdn.discordapp.com/attachments/900428634664370268/1086932230871466056/image.png)	


#### Questions
1. > Qu’est-ce que le Projet Debian ? D’où vient le nom Debian ?

   *Le [projet Debian](https://www.debian.org/doc/manuals/project-history/intro.fr.html#:~:text=Le%20projet%20Debian%20est%20un,des%20milliers%20d'applications%20pr%C3%A9empaquet%C3%A9es) est une communauté internationale de bénévoles qui travaille à développer un système d'exploitation constitué uniquement de logiciels libres.*

2. > Il existe 3 durées de prise en charge (support) de ces versions : la durée minimale, la durée en support long terme (LTS) et la durée en support long terme étendue (ELTS). Quelle sont les durées de ces prises en charge ?

	- La durée minimale est de 1 ans après l'arrivée de la derniere version stable 
   - *Debian [LTS](https://wiki.debian.org/fr/LTS) (**Long Term Support**) est un projet de prise en charge a long terme, qui permet de pouvoir conserver toutes les versions stable de Debian pendant* **_5 ans_**
   - *Debian [ELTS](https://wiki.debian.org/LTS/Extended) (**Extended Long Term Support**) est un offre visant a rallonger la durée de vie en plus du LTS  est de **5 ans** ce qui nous fait une durée de vie total de* **_10 ans_** 
   
   
3. > Pendant combien de temps les mises à jour de sécurité seront-elles fournies ?

	*D’après [une personne de l’équipe Debian](https://www.debian.org/security/faq.fr.html#:~:text=Q.%20%3A%20Pendant%20combien%20de%20temps,est%20publiée%20la%20même%20année) lors question réponse :*

	*« L'équipe en charge de la sécurité essaye de prendre en charge la distribution stable environ une année après que la version stable suivante a été publiée, sauf lorsqu'une autre distribution stable est publiée la même année. Il n'est pas possible de prendre en charge trois distributions, c'est déjà bien assez difficile avec deux. »*
	
4. > Combien de version au minimum sont activement maintenues par Debian ? Donnez leur nom générique (= les types de distribution).

	*Debian a toujours au moins [trois  versions](https://www.debian.org/releases/index.fr.html#:~:text=Debian%20a%20toujours%20au%20moins,%3A%20stable%20%2C%20testing%20et%20unstable%20.) activement entretenues :* 
	- *[stable](https://www.debian.org/releases/stable/) (Il s'agit de la version de Debian destinée à la production, celle qui est  recommandons en priorité pour une utilisation.)*
	-  *[testing](https://www.debian.org/releases/testing/) (La distribution testing de Debian regroupe les paquets qui n'ont pas encore été validés pour être intégrés dans la distribution stable.)*
	- *[unstable](https://www.debian.org/releases/sid/) (La distribution unstable de Debian est celle qui est utilisée pour les activités de développement en cours.)*

5. > Chaque distribution majeur possède un nom de code différent. Par exemple, la version majeur actuelle (Debian 11) se nomme Bullseye. D’où viennent les noms de code données aux distributions ?

   *Les [versions de Debian]( https://www.dbmtechnologies.com/debian-versions) sont souvent nommées d'après les personnages du film "Toy Story" de Disney-Pixar. Cette tradition a été initiée par le fondateur de Debian, Ian Murdock, qui était un grand admirateur du film et a choisi les noms des personnages principaux pour les versions de Debian.*

6. > Première version avec un nom de code
◦ Quelle a était le premier nom de code utilisé ?
◦ Quand a-t-il été annoncé ?
◦ Quelle était le numéro de version de cette distribution ?

   *La [première version de Debian]( https://wiki.debian.org/fr/DebianBuzz)  ne voit le jour qu'en 1996 et porte le nom de code Buzz. Depuis cette première version et à ce jour, le système est constamment disponible en trois branches : stable , testing et unstable . La branche stable , comme son nom le suggère, est à privilégier pour les machines de production , Le numéro de distribution est le 1.1*

7. > Dernière nom de code attribué :
◦ Quel est le dernier nom de code annoncée à ce jour ?
◦ Quand a-t-il été annoncé ?
◦ Quelle est la version de cette distribution ?


	*La derniere version de debian est la numéro **14** sous le nom de code de **Forky** est qui voit le jour en **Octobre 2022**.*


# Git

## Questions

1. > Qu'est-ce que le logicle git-gui ? Comment se lance t'il ?

	*[Git-gui](https://git-scm.com/downloads/guis) est une interface graphique pour git, grâce à lequel on peut on créer, cloner ou ouvrir un dépôt gui. Cette interface rend l'utilisation de git plus intuitive , donc accessible et compréhensible par plus de monde.  Elle est livrée avec Git et peut être exécutée à partir de la ligne de commande.*

	*pour lancer : `git gui`*

![Image Commande git gui](https://media.discordapp.net/attachments/900428634664370268/1088157426034933880/image.png)


![Interface git gui au démarrage](https://media.discordapp.net/attachments/900428634664370268/1088157439515435058/image.png)



2. > Qu’est-ce que le logiciel gitk ? Comment se lance-t-il ?

	*`gitk` est une interface graphique pour Git qui permet de visualiser et naviguer facilement dans l'historique des commits d'un dépôt Git. Tout comme git-gui, gitk est compris dans l'installation de git.*


	![Interface gitk](https://media.discordapp.net/attachments/900428634664370268/1088157453222432838/image.png)



3. > Quelle sera la ligne de commande git pour utiliser par défaut le proxy de l’université sur tous vos projets git ?

	*Pour configurer git pour utiliser par défaut le proxy de l'iut il faudra deux commande :*
	
	- *`git config --global http.proxy http://cache.univ-lille.fr:3128`*
	- *`git config --global https.proxy http://cache.univ-lille.fr:3128`*

4. > Qu’est-ce que Gitea ? À quels logiciels bien connus dans ce domaine peut-on le comparer (en citer au moins 2) ?

	*[Gitea](https://docs.gitea.io/fr-fr/) est un service de gestion de version autohébergé. On pourrait le comparer à d'autres tels que Gitlab (utiliser par l'iut) , Github ou bien d'autres encore.*

## Installation de Gitea

Tout d'abord pour éviter de retaper quelques informations a chaque dépôt nous allons initiale (--global)  quelque information dès le départ (n'oublier de changer les information avec les votre) : 

![Initialisation Git](https://media.discordapp.net/attachments/900428634664370268/1088163660335169666/image.png)


	ouverture port 3000 pour gitea :
	
(Si vous êtes sur une machine virtuelle, allez dans les paramètres de réseau et appliquez les mêmes )

![Paramètre réseau VM ](https://media.discordapp.net/attachments/900428634664370268/1088157482658037831/image.png?width=470&height=676)


Creation d'un utilisateur GIT : (tout cela en une fois)

	`sudo adduser \`
	`--system \`
	`--shell /bin/bash \`
	`--gecos 'Git Version Control' \`
	`--group \`
	`--disabled-password \`
	`--home /home/git \`
	`git`

  
installez wget : Wget est un logiciel libre et open-source de téléchargement de fichiers depuis le web

	`sudo apt install wget`

Téléchargez le **binaire Gitea** à partir de la page de téléchargement (version 1.18.5) :

	`sudo wget -O /tmp/gitea https://dl.gitea.io/gitea/1.18.5/gitea-1.18.5-linux-amd64]`

Déplacez le fichier **binaire Gitea** vers /usr/local/bin. :`

	 sudo mv /tmp/gitea /usr/local/bin`

Rendre le binaire exécutable. :

	 `sudo chmod +x /usr/local/bin/gitea`


Créez la structure de répertoires et ajout des autorisations et la propriété requises. :

	`sudo mkdir -p /var/lib/gitea/{custom,data,indexers,public,log}`
	`sudo chown git: /var/lib/gitea/{data,indexers,log}`
	`sudo chmod 750 /var/lib/gitea/{data,indexers,log}`
	`sudo mkdir /etc/gitea`
	`sudo chown root:git /etc/gitea`
	`sudo chmod 770 /etc/gitea`
	
Pour créer un fichier d'unité Systemd. Téléchargez le fichier dans le répertoire "/etc/systemd/system/" à l'aide de la commande suivante. :

	`sudo wget https://raw.githubusercontent.com/go-gitea/gitea/main/contrib/systemd/gitea.service -P /etc/systemd/system/`

Pour recharger et activer le service Gitea :

	`sudo systemctl daemon-reload`
	`sudo systemctl enable --now gitea`
	
Pour vérifier l'état du service Gitea : 

	`sudo systemctl status gitea`


installez [ufw](https://doc.ubuntu-fr.org/ufw) 

	`sudo apt install ufw`

Si vous utilisez un pare-feu ufw sur votre serveur, autorisez le port 3000 :

	`sudo ufw allow 3000/tcp`

Si vous avez bien suivie toutes les étape votre configuration est prête 

vous pourrez alors aller sur votre machine et écrire [localhost:3000](http://localhost:3000/)
et ainsi voir :

![Image 1 de gitea lancé](https://media.discordapp.net/attachments/900428634664370268/1088180283389518006/image.png?width=707&height=296)


![Image 2 de gitea lancé](https://media.discordapp.net/attachments/900428634664370268/1088179119289815060/image.png?width=697&height=676)


si vous voulez que gitea se lance automatiquement au lancement de la machine vous devez :

- Creer un un repertoire :
			
			`sudo ufw allow 3000/tcp`
- Inclure le code suivant : 
	
		`[Unit]
		 Description=Uncomplicated firewall 
		 After=network.target `

		`[Service]
		 ExecStart=/usr/sbin/ufw --force enable
		  RemainAfterExit=yes`

		` [Install]
		 WantedBy=multi-user.target`
Vous pouvez maintenant redémarrer votre machine et gite ainsi que ufw le Lanceron automatiquement


## Creer un depot 
pour créer un depot git vous devez simplement clicker sur le bouton '+' en vert : 

![Creation Depot Git  ](https://media.discordapp.net/attachments/900428634664370268/1089271109108641802/image.png)

Vous pouvez choisir le nom du dépot et beaucoup plus d'options :

![Choix nom depot](https://media.discordapp.net/attachments/900428634664370268/1089271193242185848/image.png?width=705&height=239)

Pour pouvoir l'obtenir sur votre machine vous devez copier le lien du dépôt :

![Clone](https://media.discordapp.net/attachments/900428634664370268/1089271241833205810/image.png?width=705&height=130)

et utilisez la commande `git clone "[lien git Clone]"` :


![Commnde git clone](https://media.discordapp.net/attachments/900428634664370268/1089271433152184400/image.png?width=720&height=32)

Vous aurez alors un nouveau dossier :

![nouveau dossier](https://media.discordapp.net/attachments/900428634664370268/1089271510843281528/image.png)

Apres avoir fini de travailler dans votre dossier pour l'inclure dans votre depot git vous devrez executer la suite commande suivante :
	- `git add [vos nouveau fichier]`
	- `git commit -m "message"`
	- `git push`
	
Exemple :
	
![exemple commande](https://media.discordapp.net/attachments/900428634664370268/1089271904533225562/image.png)


![depot git](https://media.discordapp.net/attachments/900428634664370268/1089271977019187250/image.png?width=720&height=60)



# RAPORT TECHNIQUE

## Nos Difficultés

### Fichier XML

-   Nous avons eu un léger problème lorsque nous avons tenté de modifier le nombre de processeur via le fichier XML avec la commande `count = "2"` car le fichier XML se réactualiser a chaque démarrage supprimant ainsi notre commande.

### Grub

-   Nous avons oublié l’installation de GRUB dans notre première version de la VM, qui nous a empêché d’accéder au système lors de l’exécution de la machine

### Création d’une table des matières / sommaire automatique

-   Nous avons eu énormément de mal á créer automatiquement notre table des matières nous avons du y passer près d’une heure

## Résolutions

### Fichier XML

-Nous n’avons pas trouvé d’alternatives impliquant le fichier XML, cependant nous avons effectué les modifications via le panel de contrôle de VirtualBox (cf image)  

![modification cpu](https://cdn.discordapp.com/attachments/1077716382319386807/1078665235159842896/image.png)

### Grub

-Nous avons dû recommencer notre VM depuis 0 afin d’y ajouter GRUB.

### Création d’une table des matières / sommaire automatique

-   Apres avoir parcouru différentes ressources nous avons décidé de changer d’éditeur et de passer de stackEdit á Visual Studio Code afin d’avoir une extension permettant d’avoir cette fonctionnalité.


