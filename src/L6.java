import java.util.Arrays;

public class L6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuffer[] table = new StringBuffer[numRows];
        for (int i=0; i<numRows; i++){
            table[i] = new StringBuffer();
        }

        int i=0;
        while (i<len){
            //go down
            for (int idx=0; idx<numRows && i<len; idx++){
                table[idx].append(s.charAt(i++));
            }

            //go up right
            for (int idx=numRows-2; idx>=1 && i<len; idx--){
                table[idx].append(s.charAt(i++));
            }
        }

        for (int j=1; j<numRows; j++){
            table[0].append(table[j]);
        }
        return table[0].toString();
    }
}
