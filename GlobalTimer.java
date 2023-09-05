class GlobalTimer {
    private int time;

    public GlobalTimer() {
        this.time = 0;
    }

    public int getTime() {
        return time;
    }

    public void incrementTime() {
        time++;
    }
}