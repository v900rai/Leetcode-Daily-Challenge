class Solution {

    static class Node {

        char leftChar;
        char rightChar;

        int leftLen;
        int rightLen;

        int maxLen;
        int length;

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;

            leftLen = 1;
            rightLen = 1;

            maxLen = 1;
            length = 1;
        }

        Node() {
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();

        tree = new Node[4 * n];

        // Build segment tree
        build(1, 0, n - 1);

        int q = queryIndices.length;

        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];

            char newChar = queryCharacters.charAt(i);

            // Change character
            arr[index] = newChar;

            // Update segment tree
            update(1, 0, n - 1, index);

            // Root contains answer for entire string
            answer[i] = tree[1].maxLen;
        }

        return answer;
    }

    // ---------------- BUILD ----------------

    private void build(int node, int start, int end) {

        // Leaf node
        if (start == end) {

            tree[node] = new Node(arr[start]);

            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid);

        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // ---------------- UPDATE ----------------

    private void update(
            int node,
            int start,
            int end,
            int index) {

        // Leaf node
        if (start == end) {

            tree[node] = new Node(arr[index]);

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {

            update(
                    node * 2,
                    start,
                    mid,
                    index
            );

        } else {

            update(
                    node * 2 + 1,
                    mid + 1,
                    end,
                    index
            );
        }

        // Recalculate current node
        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]
        );
    }

    // ---------------- MERGE ----------------

    private Node merge(Node left, Node right) {

        Node result = new Node();

        // Total length
        result.length = left.length + right.length;

        // First character
        result.leftChar = left.leftChar;

        // Last character
        result.rightChar = right.rightChar;

        // ---------------- LEFT PREFIX ----------------

        result.leftLen = left.leftLen;

        if (left.leftLen == left.length
                && left.rightChar == right.leftChar) {

            result.leftLen =
                    left.length + right.leftLen;
        }

        // ---------------- RIGHT SUFFIX ----------------

        result.rightLen = right.rightLen;

        if (right.rightLen == right.length
                && left.rightChar == right.leftChar) {

            result.rightLen =
                    right.length + left.rightLen;
        }

        // ---------------- MAXIMUM ----------------

        result.maxLen =
                Math.max(left.maxLen, right.maxLen);

        // Check substring crossing middle
        if (left.rightChar == right.leftChar) {

            result.maxLen = Math.max(
                    result.maxLen,
                    left.rightLen + right.leftLen
            );
        }

        return result;
    }
}