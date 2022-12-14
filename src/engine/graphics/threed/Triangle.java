package engine.graphics.threed;

import engine.math.Matrix;

public final class Triangle
{
    //triangle vertecies
    public final Vertex a;
    public final Vertex b;
    public final Vertex c;

    public Triangle(final Vertex a, final Vertex b, final Vertex c) { this.a = a; this.b = b; this.c = c; }

    public String toString()
    {
        return "Polygon(" + a + " \n        " + b + " \n        " + c + ")";
    }

    public void transformed(final Matrix matrix)
    {
        a.transform(matrix);
        b.transform(matrix);
        c.transform(matrix);
    }

    public Triangle sortedForY()
    {
        final Vertex _a = a.y() < b.y() && a.y() < c.y() ? a : 
                          b.y() < c.y() ? b : 
                          c;
            
        final Vertex _b = _a == a ? (b.y() < c.y() ? b : c) :
                          _a == b ? (a.y() < c.y() ? a : c) :
                                    (a.y() < b.y() ? a : b) ; 
                          
        final Vertex _c = _a == a ? _b == b ? c : b :
                          _a == b ? _b == a ? c : a :
                                    _b == a ? b : a ;

        return new Triangle(_a, _b, _c);
    }

    public Triangle clone()
    {
        return new Triangle
        (
            a.clone(),
            b.clone(),
            c.clone()    
        );
    }
}
