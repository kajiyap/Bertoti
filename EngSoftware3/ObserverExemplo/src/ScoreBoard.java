import java.util.ArrayList;
import java.util.List;

public class ScoreBoard implements Subject {
    private List<Observer> observers;
    private int homeTeamScore;
    private int awayTeamScore;

    public ScoreBoard() {
        observers = new ArrayList<>();
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(homeTeamScore, awayTeamScore);
        }
    }
}
