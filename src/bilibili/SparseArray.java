package bilibili;

/**
 * @ClassName SparseArray
 * @Description 二维数组与稀疏数组之间互相转换
 * @Author audience
 * @Date 2021/4/18
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //稀疏数组
        int[][] sparseArray = chessToSparse();
        //二维数组
        int[][] chessArray = sparseTochess();
        //输出二维数组
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }

    /***
     * @Description 二维数组转稀疏数组
     * @Date 2021/4/18
     * @Param []
     * @return void
     */
    private static int[][] chessToSparse(){
        //初始化二维数组(棋盘)
        int[][] chessArray= new int[11][11];
        //初始化数据
        //1代表白字，2代表黑子
        chessArray[1][1] = 1;
        chessArray[2][2] = 2;
        chessArray[3][2] = 2;
        //二维数组转稀疏数组
        //稀疏数组第一行存二维数组的总行、总列
        //稀疏数组的总行等于二维数组的棋子个数+1
        int sum = 0;
        //先遍历二维数组,得到二维数组的棋子总数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        //稀疏数组的行数为sum+1,列数为3
        int[][] sparseArray = new int[sum+1][3];
        //为稀疏数组赋值
        //第一行,第一列,值为二维数组的行数
        sparseArray[0][0] = 11;
        //第一行,第二列,值为二维数组的列数
        sparseArray[0][1] = 11;
        //第一行,第三列,值为二维数组的棋子总数
        sparseArray[0][2] = sum;
        //遍历二维数组,拿到棋子
        //line为第几次遍历二维数组,并且棋子不为0次数
        //也是稀疏数组除去第一行之后的行数
        int line = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j]!=0){
                    line++;
                    //稀疏数组第line行,第一列
                    sparseArray[line][0] = i;
                    //稀疏数组第line行,第二列
                    sparseArray[line][1] = j;
                    //稀疏数组第line行,第三列
                    sparseArray[line][2] = chessArray[i][j];
                }
            }
        }

        return sparseArray;
    }

    private static int[][] sparseTochess(){
        //调用方法得到稀疏数组
        int[][] sparseArray = chessToSparse();
        //创建二维数组
        //稀疏数组的第一行第一列为二维数组的行数
        //稀疏数组的第一行第二列为二维数组的列数
        //稀疏数组的第一行第三列为二维数组的棋子总数
        int cow = sparseArray[0][0];
        int line = sparseArray[0][1];
        //创建一个二维数组并初始化大小
        int[][] chessArray = new int[cow][line];
        //从第二行遍历稀疏数组
        for (int i = 1; i < sparseArray.length; i++) {
            //稀疏数组的i行第一列
            int chessCow = sparseArray[i][0];
            //稀疏数组的i行第二列
            int chessLine = sparseArray[i][1];
            //稀疏数组的i行第三列
            int chessValue = sparseArray[i][2];
            //二维数组的行列,并赋值
            chessArray[chessCow][chessLine] = chessValue;
        }

        return chessArray;
    }
}
