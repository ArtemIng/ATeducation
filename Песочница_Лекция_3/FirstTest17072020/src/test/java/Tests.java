import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {

    @BeforeEach
    public void befor(){
        System.out.println("befor");
    }

    @AfterEach
    public void after(){
        System.out.println("aster");
    }

    @Test
    public void firstTest(){
        System.out.println("test 1");
        Assertions.assertTrue(1==1,"Один не равен одному");
    }

    @Test
    public void secondTest(){
        System.out.println("test 2");
        Assertions.assertTrue(1==2,"Один не равен двум");
    }
}
