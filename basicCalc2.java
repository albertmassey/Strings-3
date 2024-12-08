//time O(n) where n is the length of string
//space O(1)

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int i = 0;
        char lastX = '+';
        int calc = 0;
        int curr = 0;
        int tail = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            //number
            if(Character.isDigit(c)) {
                curr = curr*10 + c - '0';
                if(i == s.length()-1) {
                    if(lastX == '+') calc += curr;
                    if(lastX == '-') calc -= curr;
                    if(lastX == '*') calc = calc - tail + (tail * curr);
                    if(lastX == '/') calc = calc - tail + (tail / curr);
                }
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/') {
                if(lastX == '+') {                
                    calc += curr;
                    tail = curr;
                } else if(lastX == '-') {
                    calc -= curr;
                    tail = -curr;
                } else if(lastX == '*') {
                    calc  = calc - tail + (tail * curr);
                    tail = tail * curr;
                } else if(lastX == '/') {
                    calc  = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastX = c;
            }
            i++;
        }
       return calc; 
    }
}
