
/**
 * @author Michel Buffa + modification Philippe Lahire
 * Inspir� par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publi�e dans le livre Core Java, Sun Press
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.io.*;


public class AnalyseurDeClasse {
    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // R�cup�ration d'un objet de type Class correspondant au nom pass� en param�tres
        Class cl = getClasse(nomClasse);

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheInnerClasses(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        System.out.println();
        afficheAnnotation(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /**
     * Retourne la classe dont le nom est pass� en param�tre
     */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }

    /**
     * Cette m�thode affiche par ex "public class C1 extends C2 implements I1, I2 {"
     */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        // CODE A ECRIRE
        System.out.print("Modifier : " + Modifier.toString(cl.getModifiers())+ ", Nom de classe : " + cl.getSimpleName());

        // R�cup�ration de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = null;
        if (cl.getSuperclass() != null) {
            supercl = cl.getSuperclass();
        }
        // System.out.println(cl.getSuperclass());

        // On ecrit le "extends " que si la superclasse est non nulle et diff�rente de Object
        if (supercl != null) System.out.print(", extends " + supercl.getSimpleName());

        // Affichage des interfaces que la classe implemente

        Class[] interfaces = cl.getInterfaces();
        System.out.print(", implements ");
        for (int i = 0; i < interfaces.length; i++) {
            System.out.print(interfaces[i].getSimpleName());
        }

        // Accolade ouvrante de d�but de classe
        System.out.print(" {\n");
    }

    /**
     * Cette m�thode affiche les classes imbriqu�es statiques ou pas
     * A faire apr�s avoir fait fonctionner le reste
     */
    public static void afficheInnerClasses(Class cl) {
        Class[] declaredClasses = cl.getDeclaredClasses();
        System.out.print("Inner classes : ");
        for (int i = 0; i < declaredClasses.length; i++){
            System.out.print(declaredClasses[i].getSimpleName());
            if( i - 1 < declaredClasses.length) System.out.print(", ");
        }
        System.out.println();
    }

    public static void afficheAttributs(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        System.out.print("Class attributes : ");
        for(int i = 0; i < fields.length; i++){
            System.out.print(fields[i].getType()+ " " + fields[i].getName());
            if( i - 1 < fields.length) System.out.print(", ");
        }
        System.out.println();
    }

    public static void afficheConstructeurs(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        System.out.print("Class constructors : ");
        for(int i = 0; i < constructors.length; i++ ){
            System.out.print(constructors[i].getName());
            if( i < constructors.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void afficheMethodes(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        System.out.print("Class methods : ");
        for(int i = 0; i < methods.length; i++ ){
            System.out.print(methods[i].getName());
            if( i < methods.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void afficheAnnotation(Class cl) {
        Annotation[] annotations = cl.getDeclaredAnnotations();

        System.out.print("Class annotations : ");
        for(int i = 0; i < annotations.length; i++ ){
            System.out.print(annotations[i]);
            if( i < annotations.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    /* Facultatif au moins dans un premier temps */
/* tester le programme en passant un nom de classe complet en param�tre
     Modifier la m�thode "main" en cons�quence
*/
    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();

                analyseClasse(nomClasse);
                ok = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouv�e.");
            } catch (IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}
