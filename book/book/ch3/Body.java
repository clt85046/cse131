package book.ch3;

import sedgewick.StdDraw;

/*************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 *************************************************************************/

public class Body {
    private Flugzeugspur r;      // position
    private Flugzeugspur v;      // velocity
    private double mass;   // mass

    public Body(Flugzeugspur r, Flugzeugspur v, double mass) {
        this.r = r;
        this.v = v;
        this.mass = mass;
    }

    public void move(Flugzeugspur f, double dt) {
        Flugzeugspur a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    }

    public Flugzeugspur forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Flugzeugspur delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    }

    public void draw() {
        StdDraw.setPenRadius(0.025);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

} 
