public class AddBinary_67 {
    class Solution1 {
        public String addBinary(String a, String b) {
            int num = a.length() - b.length();
            String result = "";
            if (num > 0) {
                for (int i = 0; i < num; i++) {
                    b = 0 + b;
                }
            } else if (num < 0) {
                for (int i = 0; i < -num; i++) {
                    a = 0 + a;
                }
            }
            int flag = 0;
            for (int j = a.length() - 1; j >= 0; j--) {
                if (flag == 1) {
                    if (a.charAt(j) != b.charAt(j)) {
                        //result.charAt[j] = 0;
                        result = 0 + result;
                    } else if (a.charAt(j) == '0') {
                        //result.charAt[j] = 1;
                        result = 1 + result;
                        flag = 0;
                    } else {
                        //result.charAt[j] = 1;
                        result = 1 + result;
                    }
                } else {
                    if (a.charAt(j) != b.charAt(j)) {
                        //result.charAt[j] = 1;
                        result = 1 + result;
                    } else if (a.charAt(j) == '0') {
                        //result.charAt[j] = 0;
                        result = 0 + result;
                    } else {
                        //result.charAt[j] = 0;
                        result = 0 + result;
                        flag = 1;
                    }
                }

            }
            if (flag == 1) result = 1 + result;
            return result;
        }
    }

    class Solution2 {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();//stringbuilder 不用限定长度
            int i = a.length() - 1, j = b.length() -1, carry = 0;
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (j >= 0) sum += b.charAt(j--) - '0';//转换为数字
                if (i >= 0) sum += a.charAt(i--) - '0';
                sb.append(sum % 2);//取余算当前位
                carry = sum / 2;//除2算进位
            }
            if (carry != 0) sb.append(carry);
            return sb.reverse().toString();//reverse转换位置
        }
    }
}




