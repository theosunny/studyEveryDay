package chapter10;


import java.util.concurrent.*;

public class ConcurrentTask {

    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); //1.1,2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        System.out.println("c纯洁对象");
                        return taskName;
                    }
                };
                //1.2创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); //1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); //1.4执行任务
                }
            }

            try {
                System.out.println("sss");
                return future.get(); //1.5,2.2线程在此等待任务执行完成
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }
public static void main(String[] args){
    ExecutorService  threadPoolExecutor = Executors.newFixedThreadPool(1);
    ConcurrentTask s = new ConcurrentTask();
    threadPoolExecutor.submit(new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            String ss = null;
            System.out.println((ss=s.executionTask("A")));
            return ss;
        }
    }));
    threadPoolExecutor.submit(new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            String ss = null;
            System.out.println((ss=s.executionTask("B")));
            return ss;
        }
    }));
    threadPoolExecutor.shutdown();
}
}
