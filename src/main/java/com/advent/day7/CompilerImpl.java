package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.input.Input;
import com.advent.day7.operator.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class CompilerImpl implements Compiler{
    private final Map<String, Input> variables = new HashMap<>();


    @Override
    public void compile(List<String> commands) {
        Map<String, Operator> operatorsPerVariables = new HashMap<>();
        for (String command : commands){
            compile(command, operatorsPerVariables);
        }
    }

    @Override
    public UInt16 getValue(String variableName) {
        return variables.get(variableName).getValue();
    }

    private void compile(String command, Map<String, Operator> operatorsPerVariables){
        String[] splitCommand = command.split("->");
        if (splitCommand.length != 2){
            throw new IllegalArgumentException("Wrong format");
        }
        String operatorText = splitCommand[0].strip();
        String resultVariableName = splitCommand[1].strip();
        createAbsentVariables(operatorText, resultVariableName);
        operatorsPerVariables.put(resultVariableName, createOperator(operatorText));
    }

    private Operator createOperator(String operatorText){
        String[] splitOperator = operatorText.split(" ");
        if (splitOperator.length == 1){
            return new Initialise(createInput(operatorText));
        }
        if (splitOperator.length == 2){
            if ("NOT".equals(splitOperator[0])){
                return new Not(createInput(splitOperator[1]));
            }
            throw new IllegalArgumentException("Unknown operator");
        }
        if (splitOperator.length == 3){
            return switch (splitOperator[1]) {
                case "OR" -> new Or(createInput(splitOperator[0]), createInput(splitOperator[2]));
                case "AND" -> new And(createInput(splitOperator[0]), createInput(splitOperator[2]));
                case "RSHIFT" -> new RightShift(createInput(splitOperator[0]), createInput(splitOperator[2]));
                case "LSHIFT" -> new LeftShift(createInput(splitOperator[0]), createInput(splitOperator[2]));
                default -> throw new IllegalArgumentException("Unknown operator");
            };
        }
        throw new IllegalArgumentException("Wrong format");
    }

    private Input createInput(String input){
        if (isVariableName(input)){
            return variables.get(input);
        }
        if (StringUtils.isNumeric(input)){
            return new ConstantInput(Integer.parseInt(input));
        }
        throw new IllegalArgumentException("Wrong input format");
    }

    private void createVariableIfNotExist(String variableName){
        if (!variables.containsKey(variableName)){
            variables.put(variableName, new ComputableInput(variableName));
        }
    }

    private void createAbsentVariables(String operatorText, String resultVariableName){
        createVariableIfNotExist(resultVariableName);

        for (String variable : extractVariables(operatorText)){
            createVariableIfNotExist(variable);
        }
    }

    private Set<String> extractVariables(String operator){
        Set<String> names = new HashSet<>();
        String[] splitOperator = operator.split(" ");
        for (String str : splitOperator){
            if (isVariableName(str)){
                names.add(str);
            }
        }
        return names;
    }

    private static boolean isVariableName(String operator) {
        return StringUtils.isAlpha(operator) && StringUtils.isAllLowerCase(operator);
    }
}
