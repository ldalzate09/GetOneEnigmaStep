package co.com.bancolombia.microservice.getOneEnigmaStep.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.bancolombia.microservice.getOneEnigmaStep.model.ErrorDetail;
import co.com.bancolombia.microservice.getOneEnigmaStep.model.GetEnigmaStepResponse;
import co.com.bancolombia.microservice.getOneEnigmaStep.model.JsonApiBodyRequest;
import co.com.bancolombia.microservice.getOneEnigmaStep.model.JsonApiBodyResponseErrors;
import co.com.bancolombia.microservice.getOneEnigmaStep.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-08-15T15:00:12.799-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> getOneEnigmaStep(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {

        System.out.println("Request: " + body.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JsonApiBodyResponseSuccess response = new JsonApiBodyResponseSuccess();
        List<GetEnigmaStepResponse> dataResponse =  new ArrayList<GetEnigmaStepResponse>();
        GetEnigmaStepResponse reponseAttributes = new GetEnigmaStepResponse();
        reponseAttributes.setHeader(body.getData().get(0).getHeader());
        reponseAttributes.setStep(body.getData().get(0).getStep());

        if (body.getData().get(0).getStep().equalsIgnoreCase("1"))
        {
            reponseAttributes.setStepDescription("Step1: Open the regrigerator");
            dataResponse.add(reponseAttributes);
            response.setData(dataResponse);
            return new ResponseEntity<JsonApiBodyResponseSuccess>(response, HttpStatus.OK);

        }else if(body.getData().get(0).getStep().equalsIgnoreCase("2"))
        {
            reponseAttributes.setStepDescription("Step2: Put the giraffe in");
            dataResponse.add(reponseAttributes);
            response.setData(dataResponse);
            return new ResponseEntity<JsonApiBodyResponseSuccess>(response, HttpStatus.OK);

        }else if(body.getData().get(0).getStep().equalsIgnoreCase("3"))
        {
            reponseAttributes.setStepDescription("Step3: Close de door");
            dataResponse.add(reponseAttributes);
            response.setData(dataResponse);
            return new ResponseEntity<JsonApiBodyResponseSuccess>(response, HttpStatus.OK);
        }

        JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
        List<ErrorDetail> errorsResponse =  new ArrayList<ErrorDetail>();
        ErrorDetail errorDetail = new ErrorDetail();

        errorDetail.setCode("0001");
        errorDetail.setDetail("Ivalid Step");
        errorDetail.setId(body.getData().get(0).getHeader().getId());
        errorDetail.setSource("/getStep");
        errorDetail.setStatus(HttpStatus.FAILED_DEPENDENCY.toString());
        errorDetail.setTitle("Invalid Step");

        errorsResponse.add(errorDetail);
        responseError.setErrors(errorsResponse);

        return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.FAILED_DEPENDENCY);
    }
}
