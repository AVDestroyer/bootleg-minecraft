import java.time.Instant;
public class CustomRandom {
    private long seed;


    public CustomRandom() {
        long i = 3997874766610925047L;
        this.seed = Instant.now().getEpochSecond() ^ i;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public long nextLong() {
        long m = 1L << 50;
        long c = 3568652466021992711L;
        long a = 6781276919310075373L;
        seed = (a *seed+ c) & (m -1L);
        return seed;
    }
}
