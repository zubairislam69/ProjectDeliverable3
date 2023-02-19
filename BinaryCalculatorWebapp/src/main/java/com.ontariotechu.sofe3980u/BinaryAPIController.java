package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
        // http://localhost:8080/add?operand1=111&operand2=1010
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
        // http://localhost:8080/add_json?operand1=111&operand2=1010
    }


    @GetMapping("/logicalOR")
    public String logicalORString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  Binary.bitwiseLogicalOR(number1,number2).getValue();
        // http://localhost:8080/logicalOR?operand1=111&operand2=1010
    }

    @GetMapping("/logicalOR_json")
    public BinaryAPIResult logicalORJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"logicalOR",number2,Binary.bitwiseLogicalOR(number1,number2));
        // http://localhost:8080/logicalOR_json?operand1=111&operand2=1010
    }



    @GetMapping("/logicalAND")
    public String logicalANDString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                           @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  Binary.bitwiseLogicalAND(number1,number2).getValue();
        // http://localhost:8080/logicalAND?operand1=111&operand2=1010
    }

    @GetMapping("/logicalAND_json")
    public BinaryAPIResult logicalANDJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                         @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"logicalAND",number2,Binary.bitwiseLogicalAND(number1,number2));
        // http://localhost:8080/logicalAND_json?operand1=111&operand2=1010
    }

    @GetMapping("/multiply")
    public String multplyString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  Binary.binaryMultiply(number1,number2).getValue();
        // http://localhost:8080/multply?operand1=111&operand2=1010
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                                          @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
        Binary number1=new Binary (operand1);
        Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"multiply",number2,Binary.binaryMultiply(number1,number2));
        // http://localhost:8080/multply_json?operand1=111&operand2=1010
    }

}
