package TrainTickets;

public class TrainTickets1 implements Runnable{
    //属性
    private static int ticketNum = 100;
    //设置线程（窗口）的名字

    @Override
    public void run() {

        for(int i = 1; i<=100; i++){
            buyTicket();
        }
    }

    //同步方法锁的这个方法发， 谁调用就锁谁
    public synchronized  void buyTicket(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //同步代码块
        if(ticketNum>0){
            System.out.println("I bought tickets from "+Thread.currentThread().getName()+", 并且还剩"+(--ticketNum));
        }

    }
    public void run2() throws InterruptedException {
        for(int i= 1; i<100; i++){
            //锁必须是共享的， 唯一的， 类型都是引用数据类型
            //synchronized ("abc")字符串再常量池， 所以是唯一的， 所以可以用来当锁
            synchronized (TrainTickets1.class){
                //这里用这个类的字节码信息， 确保这个锁是唯一的， 所以这个锁是这些线程的唯一标准
                Thread.sleep(1000);
            }
            if(ticketNum>0){
                System.out.println("I bought tickets from "+Thread.currentThread().getName()+", 并且还剩"+(--ticketNum));
            }
        }
    }

}
