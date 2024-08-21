public class MobileDevice implements Observer {
    private String deviceName;

    public MobileDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(int homeTeamScore, int awayTeamScore) {
        System.out.println(deviceName + " - Placar atualizado: " + homeTeamScore + " x " + awayTeamScore);
    }
}
