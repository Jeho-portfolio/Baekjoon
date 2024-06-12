class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int hp = health;
        
        int casting = bandage[0];
        int healSec =  bandage[1];
        int healAddition =  bandage[2];
        
        int time = attacks[attacks.length - 1][0];
        
        int attackIndex = 0;
        int healIndex = 0;
        
        for (int i = 0; i <= time; i++) {
            if (i == attacks[attackIndex][0]) {
                hp = hp - attacks[attackIndex][1];
                if (hp <= 0) {
                    answer = -1;
                    break;
                }
                attackIndex = attackIndex + 1;
                healIndex = 0;
            } else {
                hp = hp + healSec;
                healIndex = healIndex + 1;
                if (healIndex == casting) {
                    hp = hp + healAddition;
                    healIndex = 0;
                }
                if (hp > health) {
                    hp = health;
                }
            }
        }
        
        if (answer != -1) {
            answer = hp;
        }
        
        return answer;
    }
}