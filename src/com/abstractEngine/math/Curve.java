package com.abstractEngine.math;

public interface Curve {

    Polyline toPolyline(double step);

    Polyline getGuidePolyline();
}
