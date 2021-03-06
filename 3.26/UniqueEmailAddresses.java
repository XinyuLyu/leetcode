import java.util.HashSet;

public class UniqueEmailAddresses {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            for(int i=0;i<emails.length;i++){
                StringBuilder sb = new StringBuilder(emails[i]);
                int at1 = sb.indexOf("@");
                int plus1 = sb.indexOf("+");
                if(at1>plus1 && plus1!=-1){
                    sb.delete(plus1,at1);
                }
                at1=sb.indexOf("@");
                for(int j=0;j<at1;j++){
                    if(sb.charAt(j)=='.') {
                        sb.deleteCharAt(j);
                        --at1;
                        --j;
                    }
                }
                emails[i]=sb.toString();
            }
            HashSet<String> res = new HashSet<String>();
            for(int i=0;i<emails.length;i++){
                res.add(emails[i]);
            }
            return res.size();
        }
    }
}
