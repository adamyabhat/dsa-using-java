public class spiralMatrix {
    public static void spiral(int[][] matrix){
        int rows = matrix.length , cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, down = rows-1;
        int dir = 0;
        while (left <= right && top <= down) {
            switch (dir) {
                case 0:

                    for (int i = left; i <= right; i++) {
                        System.out.println(matrix[top][i]);
                    }
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= down; i++) {
                        System.out.println(matrix[i][right]);
                    }
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--) {
                        System.out.println(matrix[down][i]);
                    }
                    down--;
                    break;
                case 3:
                    for (int i = down; i >= top; i--) {
                        System.out.println(matrix[i][left]);
                    }
                    left++;
                    break;
                default:
                    break;
            }
            dir = (dir + 1) % 4;
        }
    }
    public static void main(String args[]){
        int[][] matrix = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100},
        };
        spiral(matrix);
    }
}
