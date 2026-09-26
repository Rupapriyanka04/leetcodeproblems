class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        // Store knowledge in HashMap
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {

                int j = i + 1;

                // Find ')'
                while (s.charAt(j) != ')') {
                    j++;
                }

                // Get key
                String key = s.substring(i + 1, j);

                // Replace key with value
                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append("?");
                }

                // Move after ')'
                i = j + 1;

            } else {

                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}