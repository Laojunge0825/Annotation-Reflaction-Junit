import com.yc.biz.Calculator;
import org.junit.*;

public class CalculatorTest {

    private Calculator cal; //待测试的单元
    @BeforeClass
    public  static  void bc(){
        System.out.println("beforeClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        cal =new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void add() {
        System.out.println("add测试");


    }

    @Test
    public void sub() {
        System.out.println("sub测试");

    }
    @AfterClass
    public static  void ac(){
        System.out.println("afterClass");
    }
}