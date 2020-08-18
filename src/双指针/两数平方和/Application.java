package 双指针.两数平方和;

public class Application {
    public static void main(String[] args) {
        boolean b = judgeSquareSum(26);
        System.out.println(b);
    }

    /**
     * 判断一个非负整数是否为两个整数的平方和
     */
    public static boolean judgeSquareSum(int target){
        if(target<0){
            return false;
        }
        //取target的平方根
        double sqrt = Math.sqrt(target);
        System.out.println("sqrt："+sqrt);
        int i = 0;
        int j = (int)sqrt;
        while (i<=j){
            int sum = i*i + j*j;
            if (sum == target){
                System.out.println("i："+ i);
                System.out.println("j："+ j);
                return true;
            }else if (sum>target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}

