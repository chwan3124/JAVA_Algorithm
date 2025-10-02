package baekjoon.구현.q_11723;

import java.io.IOException;
import java.util.*;

public class Main {
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String CHECK = "check";
    public static final String TOGGLE = "toggle";
    public static final String ALL = "all";
    public static final String EMPTY = "empty";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> S = new HashSet<>();
        StringBuilder result = new StringBuilder();

        String command;
        int target;
        for (int i = 0; i < n; i++) {
            command = sc.next();

            if (ADD.equals(command)) {
                target = sc.nextInt();
                S.add(target);
            } else if (REMOVE.equals(command)) {
                target = sc.nextInt();
                S.remove(target);
            } else if (CHECK.equals(command)) {
                target = sc.nextInt();
                result.append(S.contains(target) ? "1\n" : "0\n");
            } else if (TOGGLE.equals(command)) {
                target = sc.nextInt();
                if (S.contains(target)) S.remove(target);
                else S.add(target);
            } else if (ALL.equals(command)) {
                S.clear();
                for (int j = 1; j <= 20; j++) S.add(j);
            } else if (EMPTY.equals(command)) {
                S.clear();
            }
        }

        System.out.print(result);
    }
}
