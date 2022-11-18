package SpringTest.designPatterns;

public class singleTonTest {
    public static void main(String[] args) {
        MyService myService1= MyService.getMyService();
        MyService myService2= MyService.getMyService();
        myService1.say();
        myService2.say();
        System.out.println(myService1+":"+myService2);
    }
}
class MyService{
    private static MyService  myService;
     public static MyService getMyService() {
        if (myService==null){
            synchronized (MyService.class){
                if (myService==null){
                    myService=new MyService();
                }
            }
        }
        return myService;
    }
    public void say(){
        System.out.println("讲话");
    }
}
