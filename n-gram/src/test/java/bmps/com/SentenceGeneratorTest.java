package bmps.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceGeneratorTest {

    SentenceGenerator sg = new SentenceGenerator();

    @Test
    public void test() {

        System.out.println(sg.generate(7));

    }
}