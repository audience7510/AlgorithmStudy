package ˫ָ��.������������֮��;

public class Application {
    public static void main(String[] args) {
       int[] number = {2,7,11,15};
       int target = 13;
        int[] ints = twoSum(number, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] numbers, int target){
        if (numbers == null){
            return null;
        }
        int i = 0;
        int j = numbers.length-1;
        //ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)
        while (i<j){
            if (target == numbers[i]+numbers[j]){
                //��������+1
                return  new int[]{i,j};
            }else if (target > numbers[i]+numbers[j]){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}

