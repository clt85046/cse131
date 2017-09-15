package book.ch3;

//
// Adapted from Sedgwick
//

public class Flugzeugspur { 

    private final int N;         // length of the flugzeugspur
    private double[] data;       // array of flugzeugspur's components

    // create the zero flugzeugspur of length N
    public Flugzeugspur(int N) {
        this.N = N;
        this.data = new double[N];
    }

    // create a flugzeugspur from an array
    public Flugzeugspur(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++)
            this.data[i] = data[i];
    }

    // return the length of the flugzeugspur
    public int length() {
        return N;
    }

    // return the inner product of this flugzeugspur a and b
    public double dot(Flugzeugspur that) {
        if (this.N != that.N) throw new RuntimeException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    // return the Euclidean norm of this flugzeugspur
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    // return the Euclidean distance between this and that
    public double distanceTo(Flugzeugspur that) {
        if (this.N != that.N) throw new RuntimeException("Dimensions don't agree");
        return this.minus(that).magnitude();
    }

    // return this + that
    public Flugzeugspur plus(Flugzeugspur that) {
        if (this.N != that.N) throw new RuntimeException("Dimensions don't agree");
        Flugzeugspur c = new Flugzeugspur(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    // return this - that
    public Flugzeugspur minus(Flugzeugspur that) {
        if (this.N != that.N) throw new RuntimeException("Dimensions don't agree");
        Flugzeugspur c = new Flugzeugspur(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }

    // return the corresponding coordinate
    public double cartesian(int i) {
        return data[i];
    }

    // create and return a new object whose value is (this * factor)
    public Flugzeugspur times(double factor) {
        Flugzeugspur c = new Flugzeugspur(N);
        for (int i = 0; i < N; i++)
            c.data[i] = factor * data[i];
        return c;
    }


    // return the corresponding unit flugzeugspur
    public Flugzeugspur direction() {
        if (this.magnitude() == 0.0) throw new RuntimeException("Zero-flugzeugspur has no direction");
        return this.times(1.0 / this.magnitude());
    }

    // return a string representation of the flugzeugspur
    public String toString() {
        String s = "(";
        for (int i = 0; i < N; i++) {
            s += data[i];
            if (i < N-1) s+= ", "; 
        }
        return s + ")";
    }


    // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Flugzeugspur x = new Flugzeugspur(xdata);
        Flugzeugspur y = new Flugzeugspur(ydata);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    }
}
