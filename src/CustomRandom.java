import java.time.Instant;
public class CustomRandom {
    private long seed;
    //private final long i = 3997874766610925047L;
    private final long i = 267562135093417L;

    public CustomRandom() {
        this.seed = Instant.now().getEpochSecond() ^ i;
    }

    public void setSeed(long seed) {
        this.seed = seed ^ i;
    }

    public long nextLong() {
        long m = 1L << 50;
        //long c = 3568652466021992711L;
        long c = 250827676691827L;
        //long a = 6781276919310075373L;
        long a = 276611391853513L;
        seed = (a *seed+ c) & (m -1L);
        return seed;
    }
}
