public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 시뮬레이션 파라미터
        final int capacity = 10;
        final int simulationDurationMs = 10000; // 10초

        // 공유 자원 객체 생성
        ParkingLot parkingLot = new ParkingLot(capacity);

        // 스레드 객체 생성
        SensorIn sensorIn = new SensorIn(parkingLot);
        SensorOut sensorOut = new SensorOut(parkingLot);
        Display display = new Display(parkingLot, simulationDurationMs, sensorIn, sensorOut);

        // 스레드 시작
        sensorIn.start();
        sensorOut.start();
        display.start();

        // 모든 스레드가 종료될 때까지 main 스레드 대기
        sensorIn.join();
        sensorOut.join();
        display.join();

        // 최종 상태 출력
        parkingLot.printLog("영업 종료 (최종 점유: " + parkingLot.getOccupied().get() + "/" + parkingLot.getCapacity() + ")");
    }
}