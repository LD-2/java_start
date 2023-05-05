package demo17;

public class Test {
    public static void main(String[] args) {
        try {
            new Test().test(20);
        } catch (MyException e) {
            //这里默认输出了吗
            System.out.println(e.toString());
        } finally {
            System.out.println("finally");
        }
    }
    public void test(int x) throws MyException{
        if(x>10){
            throw new MyException(x);
        }
    }
}
