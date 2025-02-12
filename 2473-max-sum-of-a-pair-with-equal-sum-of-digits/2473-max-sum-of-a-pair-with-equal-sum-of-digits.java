class Solution {
	public int maximumSum(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = getSum(arr[i]);
			map.putIfAbsent(temp, new ArrayList<Integer>());
			map.get(temp).add(arr[i]);
		}
		int ans = -1;
		for (Map.Entry<Integer, ArrayList<Integer>> i : map.entrySet()) {
			ArrayList<Integer> list = i.getValue();
			Collections.sort(list);
			if (list.size() >= 2) {
				ans = Math.max(ans, list.get(list.size() - 1)+ list.get(list.size() - 2));
			}
		}
		return ans;

	}

	public int getSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}
		return sum;
	}
}