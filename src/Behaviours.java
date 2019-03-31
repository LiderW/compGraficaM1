import java.lang.Math;

public class Behaviours {

    public static int[][] Translate(int[][] polygon, int ammountX, int ammountY)
    {
        for(int i = 0; i < polygon[0].length; i++)
        {
            polygon[0][i] += ammountX;
        }

        for(int i = 0; i < polygon[1].length; i++)
        {
            polygon[1][i] += ammountY;
        }

        return polygon;
    }

    public static int[][] Scale(int[][] polygon, float ammount)
    {
        for(int i = 0; i < polygon.length; i++)
        {
            for(int j = 0; j < polygon[i].length; j++)
            {
                polygon[i][j] *= ammount;
            }
        }

        return polygon;
    }

    public static int[][] Rotate(int[][] polygon, int ammount)
    {
        double grau = Math.toRadians(ammount);
        int originX = polygon[0][0];
        int originY = polygon[1][0];

        polygon = Translate(polygon, -originX, -originY);

        for(int i = 0; i < polygon[0].length; i++)
        {
            int auxX = polygon[0][i];
            int auxY = polygon[1][i];

            polygon[0][i] = (int)(auxX * Math.cos(grau) - auxY * Math.sin(grau));
            polygon[1][i] = (int)(auxY * Math.cos(grau) + auxX * Math.sin(grau));
        }

        polygon = Translate(polygon, originX, originY);

        return polygon;
    }
}