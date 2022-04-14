import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ConcurrentLinkedQueue;
import lists.LockFreeList;

public class presents{
    Random rand = new Random();
    static ConcurrentLinkedQueue<Integer> presentsList;
    static ConcurrentLinkedQueue<Integer> thanksList;
    static LockFreeList<Integer> list;
    public static void main(String[] args) {
        int numPresents = 500000;
        ArrayList<Integer> initialKey = new ArrayList<>();
        thanksList = new ConcurrentLinkedQueue<>();
        for (int i = 1; i <= numPresents; i++) initialKey.add(i);
        Collections.shuffle(initialKey);
        presentsList = new ConcurrentLinkedQueue(initialKey);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        list = new LockFreeList<Integer>();
        while (thanksList.size() != 0 || presentsList.size() !=0){
            threadPool.execute(new presents().new Servant());
        }
        threadPool.shutdown();
    }

    class Servant implements Runnable{

        @Override
        public void run() {
            int choice = ThreadLocalRandom.current().nextInt(100);
            if (choice <= 44){
                if (presentsList.size() != 0){
                    list.add(addPresent());
                }
                    
            }
            else if(choice <= 89){
                if (thanksList.size() != 0){
                    list.remove(writeThanks());
                }
            }
            else{
                list.contains(ThreadLocalRandom.current().nextInt(1000));
            }
        }

        synchronized int writeThanks(){
            if (!thanksList.isEmpty()){
                int i = thanksList.poll();
                return i;
            }
            return 0;
        }

        synchronized int addPresent(){
            if (!presentsList.isEmpty()){
                int i = presentsList.poll();
                thanksList.add(i);
                return i;
            }
            return 0;
        }


        
    
    }
}

