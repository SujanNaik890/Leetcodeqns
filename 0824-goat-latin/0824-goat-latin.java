class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String word : words) {
            char first = word.charAt(0);
            switch (first) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    sb.append(word); break;
                default:
                    sb.append(word.substring(1));
                    sb.append(first);
            }
            sb.append("ma");
            for (int i = 0; i < count; i++) sb.append("a");
            sb.append(" ");
            count++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}