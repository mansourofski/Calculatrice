package com.example.springboot.Operation;

import com.example.springboot.Operation.Operation;
import com.example.springboot.Operation.OperationDTO;
import com.example.springboot.Operation.OperationImpl;
import com.example.springboot.Operation.OperationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@RestController
public class CalculController {

    /**
     * Exemple d’entrée :
     * {
     * 	“operation”: “addition”,
     * 	“left” : 5,
     * 	“right” 3,
     * }
     Sortie attendue :
     {
     “operationId”: “fghf5gg7”
     “operation”: “addition”,
     “left” : 5,
     “right” : 3,
     “result” : 8,
     “executionDate” : “2022-03-19T15:33:12Z”
     }
     * @return
     */


    @PostMapping(path = "/operations", consumes = "application/json", produces = "application/json")
    public OperationDTO addOperation(@RequestBody OperationDTO operation) {


        System.out.println(operation);
        String operationID=Long.toHexString(Double.doubleToLongBits(Math.random()));
        operation.setOperationId(operationID);
        int result =OperationService.doOperation(operation);
        operation.setResult(result);
        operation.setExecutionDate(new Date());
        return operation;

    }
}
