package ˫ָ��.������������֮��;

public class Application {
    public static void main(String[] args) {
       int[] number = {2,7,11,15};
       int target = 9;
        int[] ints = twoSum(number, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //��������number = {2,7,11,15}  target = 9
    //������������֮��Ϊ9��Ԫ������

    public static int[] twoSum(int[] numbers, int target){
        if (numbers == null){
            return null;
        }
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            if (target == numbers[i]+numbers[j]){
                return  new int[]{i+1,j+1};
            }else if (target > numbers[i]+numbers[j]){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}

