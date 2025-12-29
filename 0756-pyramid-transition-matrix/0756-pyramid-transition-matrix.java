import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Map bottom pair -> list of possible top characters
        Map<String, List<Character>> map = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom, "", 0, map);
    }

    private boolean dfs(String current, String next, int index,
                        Map<String, List<Character>> map) {
        // If we've built the top of the pyramid
        if (current.length() == 1) {
            return true;
        }

        // Finished building the next row, move up
        if (index == current.length() - 1) {
            return dfs(next, "", 0, map);
        }

        // Get the pair of blocks
        String key = current.substring(index, index + 2);

        // If no allowed triangle for this pair
        if (!map.containsKey(key)) {
            return false;
        }

        // Try all possible blocks on top
        for (char c : map.get(key)) {
            if (dfs(current, next + c, index + 1, map)) {
                return true;
            }
        }

        return false;
    }
}