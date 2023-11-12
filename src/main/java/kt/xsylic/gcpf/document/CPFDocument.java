package kt.xsylic.gcpf.document;

import java.util.Random;

public class CPFDocument {

    public static CPF generateCPF() {
        return new CPF(generateRawCPF());
    }

    private static String generateRawCPF() {
        var random = new Random();
        var cpf = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            cpf.append(random.nextInt(10));
        }

        int[] digits = cpf.chars().map(Character::getNumericValue).toArray();
        int n1 = digits[0], n2 = digits[1], n3 = digits[2], n4 = digits[3], n5 = digits[4],
                n6 = digits[5], n7 = digits[6], n8 = digits[7], n9 = digits[8];

        int d1 = 11 - mod(n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10);
        if (d1 >= 10) d1 = 0;

        int d2 = 11 - mod(d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11);
        if (d2 >= 10) d2 = 0;

        cpf.append(d1).append(d2);

        return cpf.toString();
    }

    public static boolean isValid(String cpf) {
        cpf = cpf.replaceAll("\\.", "").replaceAll("-", "");

        if (cpf.length() != 11) {
            return false;
        }

        var sum = 0;
        for (int i = 0; i < cpf.length(); i++) {
            sum += Character.getNumericValue(cpf.charAt(i));
        }

        return String.valueOf(sum).charAt(0) == String.valueOf(sum).charAt(1);
    }

    private static int mod(int dividend) {
        return Math.floorMod(dividend, 11);
    }

    public static class CPF {
        private final String cpf;

        public CPF(String cpf) {
            this.cpf = cpf;
        }

        public String getFormattedCPF() {
            return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6),
                    cpf.substring(6, 9), cpf.substring(9));
        }
    }
}