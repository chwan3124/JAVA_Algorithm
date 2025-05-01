/*
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public int solution(int[] A) {
        int len = A.length;

        if(len < 2) return 1;

        Stack<Integer> evenStack = new Stack<>();
        Stack<Integer> oddStack = new Stack<>();

        int totalSwitchCnt = 1;
        int switchCnt = 0;
        for(int i=0; i<len; i++){
            if((i % 2 == 0 && !evenStack.isEmpty() && evenStack.peek() != A[i]) || (i % 2 == 1 && !oddStack.isEmpty() && oddStack.peek() != A[i])){
                switchCnt = 1;

                if(i % 2 == 0){
                    evenStack.clear();
                    evenStack.push(A[i]);
                }else{
                    oddStack.clear();
                    oddStack.push(A[i]);
                }
            }else if(i % 2 == 0 && evenStack.isEmpty()){
                switchCnt = 1;
                evenStack.push(A[i]);
            }else if(i % 2 == 1 && oddStack.isEmpty()){
                switchCnt = 1;
                oddStack.push(A[i]);
            }

            switchCnt++;
            totalSwitchCnt = Math.max(totalSwitchCnt, switchCnt);
        }

        return totalSwitchCnt;
    }
}

 */

/*

import java.util.*;

class Solution {
    public int solution(int[] T, int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int tech : A){
            while(tech != T[tech]){
                set.add(tech);
                tech = T[tech];
            }
            set.add(tech);
        }

        return set.size();
    }
}

 */

/*
import java.util.*;

class Solution {
    public String solution(String S, String C) {
        String[] names = S.split(", ");
        Map<String, String> emailMap = generateEmails(names, C);

        StringBuilder emails = new StringBuilder();
        for(String key : emailMap.keySet()){
            if(!emails.toString().isEmpty()){
                emails.append(", ");
            }

            emails.append(key).append(" ").append("<").append(emailMap.get(key)).append(">");
        }

        return emails.toString();
    }

    public Map<String, String> generateEmails(String[] names, String company){
        Map<String, String> emailMap = new LinkedHashMap<>();
        Map<String, Integer> emailCntMap = new HashMap<>();

        for(String n : names){
            String[] name = n.split(" ");

            String firstName = name[0].substring(0, 1);
            String lastName = name[name.length - 1].replaceAll("-", "");

            String middleName = "";
            if(name.length > 2){
                middleName = name[1].substring(0, 1);
            }

            if(lastName.length() > 8){
                lastName = lastName.substring(0, 8);
            }

            StringBuilder emailBuilder = new StringBuilder();
            String emailName = emailBuilder.append(firstName).append(middleName).append(lastName).toString();

            emailCntMap.put(emailName, emailCntMap.getOrDefault(emailName, 0) + 1);

            if(emailCntMap.getOrDefault(emailName, 0) > 1){
                emailBuilder.append(emailCntMap.get(emailName));
            }

            String fullEmail = emailBuilder.append("@").append(company).append(".com").toString();
            emailMap.put(n, fullEmail.toLowerCase());
        }

        return emailMap;
    }
}

 */