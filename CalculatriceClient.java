import java.rmi.*;

import java.util.Scanner;

public class CalculatriceClient {

    public static void main(String[] args) {
        try {
            CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("//localhost/Calculatrice");

            Scanner scanner = new Scanner(System.in);
            boolean continuer = true;
            while (continuer) {
                System.out.println("Choisissez une opération:");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");
                System.out.print("Votre choix: ");
                int choix = scanner.nextInt();

                if (choix >= 1 && choix <= 4) {
                    System.out.print("Entrez le premier opérande: ");
                    int a = scanner.nextInt();
                    System.out.print("Entrez le deuxième opérande: ");
                    int b = scanner.nextInt();

                    int resultat = 0;
                    switch (choix) {
                        case 1:
                            resultat = calculatrice.addition(a, b);
                            break;
                        case 2:
                            resultat = calculatrice.soustraction(a, b);
                            break;
                        case 3:
                            resultat = calculatrice.multiplication(a, b);
                            break;
                        case 4:
                            resultat = (int) calculatrice.division(a, b);
                            break;
                    }

                    System.out.println("Résultat: " + resultat);
                } else if (choix == 5) {
                    continuer = false;
                } else {
                    System.out.println("Choix invalide.");
                }
            }
            scanner.close();
            System.out.println("Fin du programme.");
        } catch (Exception e) {
            System.out.println("Erreur: " + e);
        }
    }
}
