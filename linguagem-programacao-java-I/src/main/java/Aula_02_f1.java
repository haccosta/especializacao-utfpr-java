import java.util.Scanner;

public class Aula_02_f1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe um primeiro valor inteiro: ");
        int a = in.nextInt();

        System.out.print("Informe um segundo valor inteiro: ");
        int b = in.nextInt();

        if (a > b) {
            System.out.println("O primeiro valor informado é MAIOR que o segundo valor");

        } else if (a == b) {
            System.out.println("O primeiro valor informado é IGUAL que o segundo valor");

        } else {
            System.out.println("O primeiro valor informado é MENOR que o segundo valor");
        }

    }
}
