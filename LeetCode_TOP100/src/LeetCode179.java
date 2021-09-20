import java.util.Arrays;

public class LeetCode179 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            s[i++] = String.valueOf(num);
        }
        Arrays.sort(s, (a,b)->{
            return (b + a).compareTo(a + b);});
        StringBuffer sb = new StringBuffer();
        for (String str : s) {
            sb.append(str);
        }
        String res = sb.toString();
        if (res.charAt(0) == '0') {
            return "0";
        }else{
            return res;
        }
    }
}
