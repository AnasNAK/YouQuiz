package org.NAK.YouQuiz.Exception;

public class PointsException extends RuntimeException {
    public PointsException(double pointQuestion , double maxPoint, double minPoint)
    {
        super("this answer cannot have on point " +pointQuestion+ " because the min point of this question is " + minPoint+ " and the max point of this question is " + maxPoint);
    }
}
