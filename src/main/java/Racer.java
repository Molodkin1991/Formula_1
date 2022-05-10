import java.util.Objects;

public class Racer {
    private String name;
    private String team;

    public Racer(String name, String team) {
        this.name = name;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Racer)) return false;
        Racer racer = (Racer) o;
        return Objects.equals(name, racer.name) && Objects.equals(team, racer.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team);
    }

    @Override
    public String toString() {
        return "Racer{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
