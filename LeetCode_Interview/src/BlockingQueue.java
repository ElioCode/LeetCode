import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BlockingQueue {
    Condition notFull;
    Condition notEmpty;
    Lock lock;
    int capacity;
    int count;

    BlockingQueue(int capacity, Lock lock) {
        this.capacity = capacity;
        this.lock = lock;
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    void put(Integer e) throws InterruptedException {
        Lock lock = this.lock;
        lock.lockInterruptibly();
        while (count == capacity) {
            notFull.await();
        }
        insert();
        lock.unlock();
    }

    private void insert() {
        System.out.println("insert");
        count++;
        notEmpty.signal();
    }

    Integer take() throws InterruptedException {
        Lock lock = this.lock;
        lock.lockInterruptibly();
        while (count == 0) {
            notEmpty.await();
        }
        Integer i = extract();
        lock.unlock();
        return i;
    }

    private Integer extract() {
        System.out.println("extract");
        notFull.signal();
        return -1;
    }
}
