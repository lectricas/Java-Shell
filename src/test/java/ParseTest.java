import org.junit.jupiter.api.Test;
import parser.*;

import java.util.List;


public class ParseTest {

    AstPrinter p = new AstPrinter();

    @Test
    void test01() {
        Scanner actual3 = new Scanner("\"$a\"a");
        List<Token> tokens = actual3.scanTokens();
        System.out.println(tokens);
        Parser parser3 = new Parser(tokens);
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));
    }

    @Test
    void test1() {
        Scanner actual3 = new Scanner("\"$a\"");
        List<Token> tokens = actual3.scanTokens();
        System.out.println(tokens);
        Parser parser3 = new Parser(tokens);
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));
    }

    @Test
    void test15() {
        Scanner actual3 = new Scanner("$a");
        List<Token> tokens = actual3.scanTokens();
        System.out.println(tokens);
        Parser parser3 = new Parser(tokens);
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));
    }

    @Test
    void test16() {
        Scanner actual3 = new Scanner("'$a'");
        List<Token> tokens = actual3.scanTokens();
        System.out.println(tokens);
        Parser parser3 = new Parser(tokens);
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));
    }

    @Test
    void test4() {
        Scanner actual3 = new Scanner("asdf");
        Parser parser3 = new Parser(actual3.scanTokens());
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));
    }

    @Test
    void testParser1() {
        Scanner actual1 = new Scanner("echo -la");
        System.out.println(actual1.scanTokens());
        Parser parser = new Parser(actual1.scanTokens());
        Expr s1 = parser.parse();
        System.out.println(p.print(s1));

        Scanner actual2 = new Scanner("a=4 echo 123");
        System.out.println(actual2.scanTokens());
        Parser parser2 = new Parser(actual2.scanTokens());
        Expr s2 = parser2.parse();
        System.out.println(p.print(s2));

        Scanner actual3 = new Scanner("wc -e -a a=4");
        System.out.println(actual3.scanTokens());
        Parser parser3 = new Parser(actual3.scanTokens());
        Expr s3 = parser3.parse();
        System.out.println(p.print(s3));

        Scanner actual4 = new Scanner("a=4 | wc 123 abd | echo 4");
        System.out.println(actual4.scanTokens());
        Parser parser4 = new Parser(actual4.scanTokens());
        Expr s4 = parser4.parse();
        System.out.println(p.print(s4));

        Scanner actual5 = new Scanner("a=4 b=5 e=6");
        System.out.println(actual5.scanTokens());
        Parser parser5 = new Parser(actual5.scanTokens());
        Expr s5 = parser5.parse();
        System.out.println(p.print(s5));

        Scanner actual6 = new Scanner("a=4 echo 123 432 -ls | wc 33");
        System.out.println(actual6.scanTokens());
        Parser parser6 = new Parser(actual6.scanTokens());
        Expr s6 = parser6.parse();
        System.out.println(p.print(s6));

        Scanner actual7 = new Scanner("echo $a");
        System.out.println(actual7.scanTokens());
        Parser parser7 = new Parser(actual7.scanTokens());
        Expr s7 = parser7.parse();
        System.out.println(p.print(s7));

        Scanner actual8 = new Scanner("echo a 34 $a $ a");
        System.out.println(actual8.scanTokens());
        Parser parser8 = new Parser(actual8.scanTokens());
        Expr s8 = parser8.parse();
        System.out.println(p.print(s8));
    }

    @Test
    void test2() {
        Scanner actual9 = new Scanner("echo '\"$a\"'");
        System.out.println(actual9.scanTokens());
        Parser parser9 = new Parser(actual9.scanTokens());
        Expr s9 = parser9.parse();
        System.out.println(p.print(s9));
    }

    @Test
    void test3() {
        Scanner actual9 = new Scanner("echo \"$a\"");
        System.out.println(actual9.scanTokens());
        Parser parser9 = new Parser(actual9.scanTokens());
        Expr s9 = parser9.parse();
        System.out.println(p.print(s9));
    }
}
