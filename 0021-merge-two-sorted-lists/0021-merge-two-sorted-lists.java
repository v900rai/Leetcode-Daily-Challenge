class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        // Agar first list khali hai,
        // to second list return kar do
        if (a == null)
            return b;
            
        // Agar second list khali hai,
        // to first list return kar do
        if (b == null)
            return a;

        // Agar a ka value chhota hai
        if (a.val < b.val) {

            // a ke next me merged list attach karo
            a.next = mergeTwoLists(a.next, b);

            // a ko return karo
            return a;
        }

        // Agar b ka value chhota ya equal hai
        else {

            // b ke next me merged list attach karo
            b.next = mergeTwoLists(a, b.next);

            // b ko return karo
            return b;
        }
    }
}