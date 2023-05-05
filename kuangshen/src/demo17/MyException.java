package demo17;

public class MyException extends Exception {
    //异常此层出现了可以直接捕获 也可以抛出 留给上级让调用这个方法的捕获
    private int value;
    public MyException(int a) {
        this.value=a;
    }
    @Override
    public String toString() {
        return "MyException{ "+value+" }";
    }
}
