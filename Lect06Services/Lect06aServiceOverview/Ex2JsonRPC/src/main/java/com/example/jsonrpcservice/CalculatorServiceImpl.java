package com.example.jsonrpcservice;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class CalculatorServiceImpl implements CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    @Override
    public int add(int a, int b) {
        logger.info("Adding {} and {}", a, b);
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        logger.info("Subtracting {} from {}", b, a);
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        logger.info("Multiplying {} and {}", a, b);
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        logger.info("Dividing {} by {}", a, b);
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}