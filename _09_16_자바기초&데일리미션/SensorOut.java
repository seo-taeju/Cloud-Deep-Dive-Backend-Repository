import java.util.Random;

public class SensorOut extends Thread {
    private final ParkingLot parkingLot;
    private final Random random = new Random();

    public SensorOut(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (parkingLot) {
                    // 만차 상태일 경우 입차 스레드 대기
                    if (parkingLot.getOccupied().get() > 0){
                     int currentOccupied = parkingLot.getOccupied().decrementAndGet();
                     parkingLot.printLog("출차 완료 (" + currentOccupied + "/" + parkingLot.getCapacity() + ")");
                     parkingLot.notify();
                    }else {
                        parkingLot.printLog("출차 대기 (빈 차량 없음)");
                    }
                }
                Thread.sleep(random.nextInt(601) + 300); // 300ms ~ 900ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
