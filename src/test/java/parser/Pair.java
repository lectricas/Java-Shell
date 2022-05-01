package parser;

public class Pair<FST, SND> {
    private FST fst;
    private SND snd;

    public Pair(FST fst, SND snd) {
        this.fst = fst;
        this.snd = snd;
    }

    FST fst() {
        return fst;
    }

    SND snd() {
        return snd;
    }

}
