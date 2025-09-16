public class Display extends Thread {
    private final ParkingLot parkingLot;
    private final Thread[] threadsToControl;
    private final int simulationDuration;

    public Display(ParkingLot parkingLot, int simulationDuration, Thread... threadsToControl) {
        this.parkingLot = parkingLot;
        this.simulationDuration = simulationDuration;
        this.threadsToControl = threadsToControl;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < simulationDuration) {
                String status = "현재 현황: " + parkingLot.getOccupied().get() + " / " + parkingLot.getCapacity();
                parkingLot.printLog(status);
                Thread.sleep(1000); // 1초 대기
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 모든 스레드에 종료 요청
            for (Thread t : threadsToControl) {
                t.interrupt();
            }
        }
    }
}