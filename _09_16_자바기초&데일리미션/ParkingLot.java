import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private final int capacity; //주차장 용량(capacity)
    private final AtomicInteger occupied; //현재 점유 상태(AtomicInteger occupied)

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupied = new AtomicInteger(0);
    }

    public int getCapacity() {
        return capacity;
    }

    public AtomicInteger getOccupied() {
        return occupied;
    }
    //동시 접근
    public void printLog(String message) {
        synchronized (this) {
            System.out.println(message);
        }
    }
}
