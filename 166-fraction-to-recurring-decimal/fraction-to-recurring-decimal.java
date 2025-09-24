class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if ((num < 0) ^ (den < 0)) sb.append("-");

        long n = Math.abs((long) num);
        long d = Math.abs((long) den);

        sb.append(n / d);
        long rem = n % d;
        if (rem == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int idx = seen.get(rem);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            seen.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / d);
            rem %= d;
        }

        return sb.toString();
    }
}