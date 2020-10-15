package seventh;

class Sample implements Comparable<Sample>{
    private int id;

    Sample(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id:" + id + " ";
    }

    @Override
    public int compareTo(Sample sample) {
        return this.id - sample.id;
    }

    @Override
    public boolean equals (Object object) {
        Sample sample = (Sample) object;
        return this.id == sample.id;
    }
}