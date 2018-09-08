package concurrent.art.chapter4.thredPoolDemo;



import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DeafultThreadPool<Job extends  Runnable> implements ThreadPool <Job>{
    //最多线程数量
    private  static final  int MAX_WORKER_NUMBERS = 10 ;
    //默认线程数量
    private  static final  int DEFAULT_WORKER_NUMBERS = 5 ;
  //最小线程数量
    private  static final  int MIN_WORKER_NUMBERS = 1 ;

    //工作列表，将会向里面插入工作

    private  final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作者表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    //工作者的数量

    private int workerNum = DEFAULT_WORKER_NUMBERS;

    //线程编号生成

    private AtomicInteger threadNum = new AtomicInteger();

    public DeafultThreadPool() {
       initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DeafultThreadPool(int num) {
        workerNum =num>MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWorkers(workerNum);
    }

    //初始化线程工作者
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"thread-worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job!=null){
            //添加一个工作，然后进行通知
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        workers.forEach(Worker::shutdown);
    }

    @Override
    public void addWorker(int num) {
            synchronized (jobs){
                //限制新增的worker数量不能超过最大值
                if (num+this.workerNum>MAX_WORKER_NUMBERS){
                    num = MAX_WORKER_NUMBERS-this.workerNum;
                }
                initializeWorkers(num);
                this.workerNum=num;
            }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num>this.workerNum) throw new IllegalArgumentException("beyond worknum");
            //按照原定 的数量停止worker
            int  count = 0 ;
            while (count<num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
    //工作者负责消费业务 消费者
     class Worker implements Runnable{
    private volatile boolean running = true;
        @Override
        public void run() {
            while (running){
                Job job =null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job!=null){
                    job.run();
                }
            }
        }
        public  void shutdown(){
            running = false;
        }
    }
}
