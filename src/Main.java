import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        for(int i = 0; i < 3; i++)
        {
            System.out.printf("\nEntre com coordenadas X e Y do ponto %d:", i);
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }

        int[][] polygon = {x, y};

        Drawing.run(polygon, "Initial");

        Drawing.run(Behaviours.Translate(polygon, 50, 100), "Translate");

        Drawing.run(Behaviours.Scale(polygon, 2), "Scale");

        Drawing.run(Behaviours.Scale(polygon, 0.5f), "ReScale");

        Drawing.run(Behaviours.Rotate(polygon, 30), "Rotate");

        Drawing.bresenham(polygon[0][0], polygon[1][0], polygon[0][2], polygon[1][2]);
    }
}
