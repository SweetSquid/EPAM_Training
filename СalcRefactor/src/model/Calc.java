package model;

public interface Calc<T> {
    T add(T a, T b);

    T subtract(T a, T b) ;

    T divide(T a, T b) ;

    T multiply(T a, T b) ;
}