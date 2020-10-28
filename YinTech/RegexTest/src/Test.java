public class Test {
    public static void main(String[] args) {
        //http://tool.chinaz.com/regex/
        /**
         * A,B
         * ------------------------------------------------------------
         * 1. A.class                      -> B.class
         * 2. [A class]                    -> [B class]
         * 3. NSStringFromClass(A.class)   -> NSStringFromClass(B.class)
         * 4. NSStringFromClass([A class]) -> NSStringFromClass([B class])
         * 5. @interface A                 -> @interface B
         * 6. @implementation A            -> @implementation B
         * 7. @interface A (xxx)           -> @interface B (xxx)
         * 8. @implementation A (xxx)      -> @implementation B (xxx)
         * 9. #import "A.h"                -> #import "B.h"
         * 10. #import <xxx/A.h>           -> #import <xxx/B.h>
         * 11. A.xxx                       -> B.xxx
         * 12. [A xxx]                     -> [B xxx]
         * 13. A *                         -> B *
         * 14. : A                         -> : B
         *
         * TODO://@"A" ??
         *
         * PersonViewController
         * CustomPersonViewController
         */
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
    }

    //1. A.class -> B.class
    public static void test1() {
        System.out.println("1");
        String str = replaceInLine1("NSString *s = AAA.class; BAAA.class ", "AAA", "BBB");
        System.out.println(str);
    }
    // 2. [A class] -> [B class]
    public static void test2() {
        System.out.println("2");
        String str = replaceInLine2("NSString *s = [AAA class]; [AAA class]", "AAA", "BBB");
        System.out.println(str);
    }
    // 3. NSStringFromClass(A.class) -> NSStringFromClass(B.class)
    public static void test3() {
        System.out.println("3");
        String str = replaceInLine3("NSString *s = NSStringFromClass(AAA.class); NSStringFromClass(AAA.class)", "AAA", "BBB");
        System.out.println(str);
    }
    // 4. NSStringFromClass([A class]) -> NSStringFromClass([B class])
    public static void test4() {
        System.out.println("4");
        String str = replaceInLine4("NSString *s = NSStringFromClass([AAA class]); NSStringFromClass([AAA class])", "AAA", "BBB");
        System.out.println(str);
    }
    // 5. @interface A -> @interface B
    public static void test5() {
        System.out.println("5");
        String str = replaceInLine5("  @interface AAA{  @interface AAAB { @interface AAA<UITableViewDelegate, NSObject>", "AAA", "BBB");
        System.out.println(str);
    }
    // 6. @implementation A -> @implementation B
    public static void test6() {
        System.out.println("6");
        String str = replaceInLine6("  @implementation AAA{  @implementation AAAB @implementation BAAA { @implementation AAA<UITableViewDelegate, NSObject>", "AAA", "BBB");
        System.out.println(str);
    }
    // 7. @interface A (xxx) -> @interface B (xxx)
    public static void test7() {
        System.out.println("7");
        String str = replaceInLine7("  @interface AAA    (xxx) @interface AAA (xxx)<UITableViewDelegate> @interface AAA(xxx)  @interface BAAA(xxx)  @interface AAAB(xxx)", "AAA", "BBB");
        System.out.println(str);
    }
    // 8. @implementation A (xxx) -> @implementation B (xxx)
    public static void test8() {
        System.out.println("8");
        String str = replaceInLine8("  @implementation AAA    (xxx) @implementation AAA (xxx)<UITableViewDelegate> @implementation AAA(xxx)  @implementation BAAA(xxx)  @implementation AAAB(xxx)", "AAA", "BBB");
        System.out.println(str);
    }
    // 9. #import "A.h" -> #import "B.h"
    public static void test9() {
        System.out.println("9");
        String str = replaceInLine9("#import \"AAA.h\" #import \"BAAA.h\" #import \"AAAB.h\"", "AAA", "BBB");
        System.out.println(str);
    }
    // 10. #import <XXX/A.h> -> #import <XXX/B.h>
    public static void test10() {
        System.out.println("10");
        String str = replaceInLine10("#import <XXX/AAA.h> #import <XXX/AAAA.h>", "AAA", "BBB");
        System.out.println(str);
    }
    // 11. A.xxx -> B.xxx
    public static void test11() {
        System.out.println("11");
        String str = replaceInLine11("BAAA.name = AAA.name= BAAA.name = AAAB.block = ", "AAA", "BBB");
        System.out.println(str);
    }
    //12. [A xxx] -> [B xxx]
    public static void test12() {
        System.out.println("12");
        String str = replaceInLine12("[BAAA setName [AAA name [AAA name [AAAB block:", "AAA", "BBB");
        System.out.println(str);
    }
    //13. 13. A * -> B *
    public static void test13() {
        System.out.println("13");
        String str = replaceInLine13("AAA* a = AAA.new AAA * AAA  ** BAAA * AAAB* CC", "AAA", "BBB");
        System.out.println(str);
    }

    //14.14. : A -> : B
    public static void test14() {
        System.out.println("14");
        //String str = replaceInLine14(" Hello:AAA Hello:AAA  Pe Hello:AAAAAA Person : AAA Cat:BAAA Dog:AAAB", "AAA", "BBB");
        String str = replaceInLine14("@interface Hello:AAA", "AAA", "BBB");
        System.out.println(str);
    }

    public static String replaceInLine(String line, String oldClsName, String newClsName) {
        if (line == null ||  oldClsName == null ||  newClsName == null || line.trim().length() == 0) {
            return null;
        }

        String newLine = line;
        newLine = replaceInLine1(line, oldClsName, newClsName);
        newLine = replaceInLine2(line, oldClsName, newClsName);

        return newLine;
    }
    // NSString *s = AAA.class; BAAA.class "
    public static String replaceInLine1(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "\\s" + oldClsName + "\\.class";
        newLine = newLine.replaceAll(regex, " " + newClsName + ".class");
        regex = "[^\\w]" + oldClsName + "\\.class"; // [^\w]NAME\.class
        newLine = newLine.replaceAll(regex, newClsName + ".class");
        return newLine;
    }
    public static String replaceInLine2(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "\\[" + oldClsName + " class\\]";
        newLine = newLine.replaceAll(regex, "[" + newClsName + " class]");
        return newLine;
    }
    public static String replaceInLine3(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "NSStringFromClass" + "\\(" + oldClsName + ".class\\)";
        newLine = newLine.replaceAll(regex, "NSStringFromClass(" + newClsName + ".class)");
        return newLine;
    }
    public static String replaceInLine4(String line, String oldClsName, String newClsName) {
        String newLine = line;
        // NSStringFromClass\(\[AAA\s+class\]\)
        String regex = "NSStringFromClass" + "\\(\\[" + oldClsName + "\\s+class\\]\\)";
        newLine = newLine.replaceAll(regex, "NSStringFromClass([" + newClsName + " class])");
        return newLine;
    }
    public static String replaceInLine5(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "@interface\\s+" + oldClsName + "([^A-Za-z_])";
        //分组替换 https://blog.csdn.net/jiaobuchong/article/details/81257570
        //@interface AAA{  @interface AAAB { @interface AAA<UITableViewDelegate, NSObject>
        newLine = newLine.replaceAll(regex, "@interface " + newClsName + "$1");
        return newLine;
    }
    public static String replaceInLine6(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "@implementation\\s+" + oldClsName + "([^A-Za-z_])";
        newLine = newLine.replaceAll(regex, "@implementation " + newClsName + "$1");
        return newLine;
    }
    //@interface AAA    (xxx) @interface AAA (xxx)<UITableViewDelegate> @interface AAA(xxx)  @interface BAAA(xxx)  @interface AAAB(xxx)
    public static String replaceInLine7(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "@interface\\s+" + oldClsName + "\\s*\\(";
        newLine = newLine.replaceAll(regex, "@interface " + newClsName + " (");
        return newLine;
    }
    //@implementation A (xxx)  -> @implementation B (xxx)
    public static String replaceInLine8(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "@implementation\\s+" + oldClsName + "\\s*\\(";
        newLine = newLine.replaceAll(regex, "@implementation " + newClsName + " (");
        return newLine;
    }
    //#import "A.h" -> #import "B.h"
    public static String replaceInLine9(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "#import\\s+\"" + oldClsName + "\\.h\"";
        newLine = newLine.replaceAll(regex, "#import \"" + newClsName + ".h\"");
        return newLine;
    }
    //#import <xxx/A.h> -> #import <xxx/B.h>
    //需要分组替换
    public static String replaceInLine10(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "#import\\s+<(\\w+)/" + oldClsName + "\\.h>";
        newLine = newLine.replaceAll(regex, "#import <" + "$1/" + newClsName + ".h>");
        return newLine;
    }
    //BAAA.name = AAA.name= BAAA.name = AAAB.block =  // TO:
    //BAAA.name = BBB.name= BAAA.name = AAAB.block =
    public static String replaceInLine11(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "([^A-Za-z_])" + oldClsName + "\\.";
        newLine = newLine.replaceAll(regex, "$1" + newClsName + ".");
        return newLine;
    }
    //[BAAA setName [AAA name [BAAA name [AAAB block
    public static String replaceInLine12(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = "\\[" + oldClsName + "\\s+";
        newLine = newLine.replaceAll(regex, "[" + newClsName + " ");
        return newLine;
    }
    //AAA* a = AAA.new AAA * AAA  * BAAA * AAAB* CC
    public static String replaceInLine13(String line, String oldClsName, String newClsName) {
        String newLine = line;
        //[^A-Za-z_](AAA\s*\*)
        String regex = "([^A-Za-z_])*" + oldClsName + "\\s*\\*";
        newLine = newLine.replaceAll(regex,  "$1" + newClsName + " *");
        return newLine;
    }
    //replaceInLine14
    // Hello:AAA Hello:AAA  Pe Hello:AAAAAA Person : AAA Cat:BAAA Dog:AAAB
    public static String replaceInLine14(String line, String oldClsName, String newClsName) {
        String newLine = line;
        String regex = ":\\s*" + oldClsName + "([^A-Aa-z_0123456789])*";
        newLine = newLine.replaceAll(regex,  ": " + newClsName + "$1");
        return newLine;
    }
}
