package concurrent.art.chapter4.thredPoolDemo;

public interface ThreadPool<Job extends Runnable> {
    //执行一个job，这个job需要实现runnable
    void execute(Job job);
    void shutdown();
    //增加工资线程
    void addWorker(int num);
    //减少工资线程
    void removeWorker(int num);
    //得到正在等待执行的任务数量
    int getJobSize();
}
