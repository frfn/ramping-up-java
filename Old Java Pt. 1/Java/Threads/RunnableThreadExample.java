package Threads;

public class RunnableThreadExample implements Runnable{
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Thread is starting... ");

        try{
            while(count < 5){
                Thread.sleep(500);
                count++;
            }
        }
        catch (InterruptedException exc){
            System.out.println("Thread interrupted...");
        }
        finally {
            System.out.println("Thread terminating");
        }
    }

    public static void main(String[] args) {

        RunnableThreadExample ex = new RunnableThreadExample();
        Thread threadEx = new Thread(ex);

        threadEx.start();

        while(ex.count != 5){
            try{
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
