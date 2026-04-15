📌 ShapeTool SOAP Web Service
📖 Overview

ShapeTool is a SOAP-based web service built with Spring Boot that calculates the area of geometric shapes (circle, square, rectangle, triangle, and parallelogram). It uses XML-based SOAP communication with XSD validation and auto-generated WSDL.

⚙️ Technologies
Java (Spring Boot)
Spring Web Services (SOAP)
XML, XSD, WSDL
Maven

## Project Structure

```
shapetool/
├── document/
│   └── shapetool_doc.pdf               # Project documentation
├── sample soap req & res/              # Sample SOAP XML request and response files
├── static wsdl/
│   └── shapetool.wsdl                  # Static WSDL definition
├── src/
│   ├── main/
│   │   ├── java/com/shapetool/shapetool/
│   │   │   ├── ShapetoolApplication.java           # Spring Boot entry point
│   │   │   ├── config/
│   │   │   │   └── WebServiceConfig.java           # SOAP servlet, WSDL, and validation config
│   │   │   ├── shapesoap/
│   │   │   │   └── ShapeEndpoint.java              # SOAP endpoint handlers for all shapes
│   │   │   └── exception/
│   │   │       └── InvalidShapeParameterException.java  # Custom SOAP fault exception
│   │   └── resources/
│   │       ├── application.properties              # Application configuration
│   │       └── shapetool.xsd                       # XSD contract defining all request/response types
│   └── test/
│       └── java/com/shapetool/shapetool/
│           └── ShapetoolApplicationTests.java      # Spring Boot context load test
│
├── pom.xml                             # Maven build configuration and dependencies
└── README.md
```

## Supported Operations

| Shape         | Input Parameters     | Formula                  |
|---------------|----------------------|--------------------------|
| Circle        | `radius`             | π × r²                   |
| Square        | `side`               | side²                    |
| Rectangle     | `length`, `width`    | length × width           |
| Triangle      | `base`, `height`     | 0.5 × base × height      |
| Parallelogram | `base`, `height`     | base × height            |

📌 WSDL URL
http://localhost:8080/ws/shapetool.wsdl
📌 SOAP Endpoint URL
http://localhost:8080/ws


### Example — Circle Area Request

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:sh="http://example.com/shapetool">
    <soapenv:Header/>
    <soapenv:Body>
        <sh:circleAreaRequest>
            <sh:radius>5</sh:radius>
        </sh:circleAreaRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

### Example — Circle Area Response

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:circleAreaResponse xmlns:ns2="http://example.com/shapetool">
            <ns2:area>78.53981633974483</ns2:area>
        </ns2:circleAreaResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

More sample requests and responses for all shapes are available in the `sample soap req & res/` directory.

---

## Validation & Error Handling

- All incoming SOAP requests are validated against `shapetool.xsd` via `PayloadValidatingInterceptor`.
- If a parameter is zero, negative, `NaN`, or infinite, the service returns a SOAP fault with `faultCode = CLIENT`.
- Invalid XML structure or missing required fields are rejected at the schema validation level before reaching the endpoint.



