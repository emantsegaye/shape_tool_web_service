package com.shapetool.shapetool.shapesoap;


import com.example.shapetool.*;
import com.shapetool.shapetool.exception.InvalidShapeParameterException;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "circleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circleArea(@RequestPayload CircleAreaRequest request) {
        validatePositive(request.getRadius(), "Radius");
        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(Math.PI * request.getRadius() * request.getRadius());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse squareArea(@RequestPayload SquareAreaRequest request) {
        validatePositive(request.getSide(), "Side");
        SquareAreaResponse response = new SquareAreaResponse();
        response.setArea(request.getSide() * request.getSide());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangleArea(@RequestPayload RectangleAreaRequest request) {
        validatePositive(request.getLength(), "Length");
        validatePositive(request.getWidth(), "Width");
        RectangleAreaResponse response = new RectangleAreaResponse();
        response.setArea(request.getLength() * request.getWidth());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogramArea(@RequestPayload ParallelogramAreaRequest request) {
        validatePositive(request.getBase(), "Base");
        validatePositive(request.getHeight(), "Height");
        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        response.setArea(request.getBase() * request.getHeight());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangleArea(@RequestPayload TriangleAreaRequest request) {
        validatePositive(request.getBase(), "Base");
        validatePositive(request.getHeight(), "Height");
        TriangleAreaResponse response = new TriangleAreaResponse();
        response.setArea(0.5 * request.getBase() * request.getHeight());
        return response;
    }

    private void validatePositive(double value, String fieldName) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new InvalidShapeParameterException(fieldName + " must be a valid finite number.");
        }
        if (value <= 0) {
            throw new InvalidShapeParameterException(fieldName + " must be a positive number.");
        }
    }
}