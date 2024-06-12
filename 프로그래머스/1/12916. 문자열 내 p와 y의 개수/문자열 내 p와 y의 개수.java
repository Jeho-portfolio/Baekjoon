
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int numberP = 0;
        int numberY = 0;
        
        int length = s.length();
        
        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == 'P' || ch == 'p') {
                numberP = numberP + 1;
            } else if (ch == 'Y' || ch == 'y') {
                numberY = numberY + 1;
            }
        }
        
        if (numberP == numberY) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}