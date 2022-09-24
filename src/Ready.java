import java.util.Arrays;
import java.util.Scanner;

//两数之和
//2022.9.24
public class Ready {
    public static int[] twoSum(int[] numbers, int target){
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
//[1,23,53] 54
//[1,53]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String[] str = sc.next().split(",");
        String[] str = sc.nextLine().split(" ");
        String[] string = str[0].substring(1, str[0].length() - 1).split(",");
        int[] ls = new int[string.length];
        for (int k = 0; k < string.length; k++){
            ls[k] = Integer.parseInt(string[k]);
//            System.out.println(ls[k] + " ");
        }
//        int tar = sc.nextInt();
        int[] in = twoSum(ls, Integer.parseInt(str[1]));
        System.out.println(Arrays.toString(in));
//        System.out.println("what?");
    }
}
