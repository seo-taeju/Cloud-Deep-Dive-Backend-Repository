import java.util.Random;
//입차 스레드
public class SensorIn extends Thread {
    private final ParkingLot parkingLot;
    private final Random random = new Random();

    public SensorIn(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (parkingLot) {
                    // 만차 상태일 경우 입차 스레드 대기
                    while (parkingLot.getOccupied().get() >= parkingLot.getCapacity()){
                        parkingLot.printLog("만차, 입차 대기");
                        parkingLot.wait();
                    }
                    int currentOccupied = parkingLot.getOccupied().incrementAndGet();
                    parkingLot.printLog("입차 성공 (" + currentOccupied + "/" + parkingLot.getCapacity() + ")");
                }
                Thread.sleep(random.nextInt(501) + 200); // 200ms ~ 700ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
