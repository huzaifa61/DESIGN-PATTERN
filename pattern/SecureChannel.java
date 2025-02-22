public class SecureChannel {

        static final String NEG_RESPONSE = "-1";

        // Main secureChannel function
        static String secureChannel(int op, String msg, String key) {
            switch (op) {
                case 1:
                    return encode(msg, key);
                case 2:
                    return decode(msg, key);
                default:
                    return NEG_RESPONSE;
            }
        }

        // Check for corner cases
        private static String validate(String msg, String key) {
            if (msg == null || key == null) return NEG_RESPONSE;
            if (msg.isEmpty() && key.isEmpty()) return msg;
            if (!msg.isEmpty() && key.isEmpty()) return msg;
            if (msg.isEmpty() && !key.isEmpty()) return NEG_RESPONSE;
            return null;
        }

        // Decode logic
        private static String decode(String msg, String key) {
            String res = validate(msg, key);
            if (res != null) return res;

            if (key.equals("0")) return msg;

            StringBuilder sb = new StringBuilder();
            int idx = 0;
            char[] keys = key.toCharArray();

            for (char k : keys) {
                if (idx >= msg.length()) break;
                if (!Character.isDigit(k)) return NEG_RESPONSE;

                int repeat = k - '0';
                char curr = msg.charAt(idx);
                int count = 0;

                while (idx + count < msg.length() && msg.charAt(idx + count) == curr) {
                    count++;
                }

                if (count == repeat) {
                    sb.append(curr);
                    idx += count;
                } else {
                    return NEG_RESPONSE;
                }
            }

            if (idx < msg.length()) sb.append(msg.substring(idx));
            return sb.toString();
        }

        // Encode logic
        private static String encode(String msg, String key) {
            String res = validate(msg, key);
            if (res != null) return res;

            StringBuilder sb = new StringBuilder();
            int idx = 0;
            char[] keys = key.toCharArray();

            for (char k : keys) {
                if (idx >= msg.length()) break;
                if (!Character.isDigit(k)) return NEG_RESPONSE;

                int repeat = k - '0';
                char curr = msg.charAt(idx);

                sb.append(String.valueOf(curr).repeat(repeat));
                idx++;
            }

            if (idx < msg.length()) sb.append(msg.substring(idx));
            return sb.toString();
        }

        public static void main(String[] args) {
            System.out.println(secureChannel(2, "open", "aad"));
            System.out.println(secureChannel(2, "", ""));
            System.out.println(secureChannel(2, "Oppeeennnn", "1234"));
            System.out.println(secureChannel(1, "abcdefgh", ""));
            System.out.println(secureChannel(2, "aaabbbcccdddeeefffggghhh", ""));
            System.out.println(secureChannel(1, "abcdefgh", "0"));
            System.out.println(secureChannel(2, "bcdefgh", "0"));
            System.out.println(secureChannel(1, "abcdefgh", ""));
            System.out.println(secureChannel(2, "aaabbbcccdddeeefffggghhh", ""));
            System.out.println(secureChannel(1, "abcdefgh", "33333333333"));
            System.out.println(secureChannel(2, "aaabbbcccdddeeefffggghhh", "33333333333"));
            System.out.println(secureChannel(1, null, "9999"));
            System.out.println(secureChannel(2, null, "9999"));
            System.out.println(secureChannel(1, "", "9999"));
            System.out.println(secureChannel(2, "", "9999"));
            System.out.println(secureChannel(1, "Ope", "12345"));
            System.out.println(secureChannel(2, "Oppeee", "12345"));
            System.out.println(secureChannel(1, "open", "123"));
            System.out.println(secureChannel(2, "Oppeeen", "123"));
            System.out.println(secureChannel(1, "open", "1234"));
            System.out.println(secureChannel(2, "oppeeennnn", "123"));
            System.out.println(secureChannel(1, "o", "1234"));
            System.out.println(secureChannel(2, "opp", "123"));
            System.out.println(secureChannel(2, "Oppeeened", "12"));
            System.out.println(secureChannel(1, "", "99999"));
        }

    }
