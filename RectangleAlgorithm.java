public class RectangleAlgorithm {

/*
Алгоритмы-прямоугольники
*/

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int rectangleFound1 = getRectangleFound(a1);
        System.out.println("rectangleFound = " + rectangleFound1 + ". Должно быть 2");
        int rectangleFound2 = getRectangleFound(a2);
        System.out.println("rectangleFound = " + rectangleFound2 + ". Должно быть 4");
    }

    public static int getRectangleFound(byte[][] a) {

        int rectangleFound = 0;
        int horizontalStart;
        int verticalStart;
        int horizontalEnd;
        int verticalEnd;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[i][j] == 1) {
                    // единичка это уже прямоугольник или его часть, инкрементируем
                    rectangleFound++;
                    verticalStart = i;
                    horizontalStart = j;
                    verticalEnd = a.length - 1;
                    horizontalEnd = a.length - 1;

                    for (int k = j; k < a.length; k++) {
                        if (a[i][k] == 0) {
                            // нашли горизонт. границу прямоугольника
                            horizontalEnd = k - 1;
                            break;
                        }
                    }

                    for (int k = i; k < a.length; k++) {
                        if (a[k][j] == 0) {
                            // нашли вертик. границу прямоугольника
                            verticalEnd = k - 1;
                            break;
                        }
                    }

                    for (int k = verticalStart; k < verticalEnd + 1; k++) {
                        for (int l = horizontalStart; l < horizontalEnd + 1; l++) {
                            // закрашиваем найденный прямоугольник нуликами, чтобы пробежать циклом снова
                            a[k][l] = 0;
                        }
                    }
                }
            }
        }
        return rectangleFound;
    }

}
