/**
 * Created by jackiezero on 2016/12/26.
 */
public class Test {
    class CustomerException extends RuntimeException {

        private String retCd ;  //异常对应的返回码
        private String msgDes;  //异常对应的描述信息

        public CustomerException() {
            super();
        }

        public CustomerException(String message) {
            super(message);
            msgDes = message;
        }

        public CustomerException(String retCd, String msgDes) {
            super();
            this.retCd = retCd;
            this.msgDes = msgDes;
        }

        public String getRetCd() {
            return retCd;
        }

        public String getMsgDes() {
            return msgDes;
        }
    }

    class TestClass {

        public void testException() throws CustomerException {
            try {
//..some code that throws CustomerException

            } catch (Exception e) { throw new CustomerException("飒沓");}}}
public String aa(int a){
    String bb="这是对的";
    String cc="sasas";
    for (int i=0;i<=a;i++){
        try {
            bb="这是对的try{}catch{}";/*
            System.out.println(i);
            String ab = "abc";
            int b = Integer.parseInt(ab);*/


          return  bb;
        }catch (Exception e){
            System.out.println("不对1");
            e.printStackTrace();
            System.out.println("不对2");
            continue;
        }
    }
    return cc;
}
    public static void main(String[] args) {
//        Test t = new Test();
//        System.out.println(t.aa(5));
//        System.out.printf("cannot find %s in %s seconds","ss","ss");
        int i=1;
        int b=0;
        while (b<=10){
            b=1+i;
            i++;
            System.out.println(i);

//            break;
        }
        System.out.println(b);
    }
}
