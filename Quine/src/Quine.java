/* David Zheng Extra Credit: Quine Modified from Wikipedia */
public class Quine {
 public static char quote = 34, space = 32, comma = 44;
 public static String[] str = {"/* David Zheng Extra Credit: Quine Modified from Wikipedia */", "public class Quine {", " public static char quote = 34, space = 32, comma = 44;", " public static String[] str = {", "};", "  public static void main(String[] args) {", "   for(int i = 0; i < 3; i++) {", "    System.out.println(str[i]);", "   }", "   System.out.print(str[3]);", "   for(int i = 0; i < str.length - 1; i++) {", "    System.out.print(quote + str[i] + quote + comma + space);", "   }", "   System.out.println(quote + str[str.length - 1] + quote + str[4]);", "   for(int i = 5; i < str.length - 1; i++) {", "    System.out.println(str[i]);", "   }", "   System.out.print(str[str.length - 1]);", " }", "}"};
  public static void main(String[] args) {
   for(int i = 0; i < 3; i++) {
    System.out.println(str[i]);
   }
   System.out.print(str[3]);
   for(int i = 0; i < str.length - 1; i++) {
    System.out.print(quote + str[i] + quote + comma + space);
   }
   System.out.println(quote + str[str.length - 1] + quote + str[4]);
   for(int i = 5; i < str.length - 1; i++) {
    System.out.println(str[i]);
   }
   System.out.print(str[str.length - 1]);
 }
}