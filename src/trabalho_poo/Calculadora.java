
package trabalho_poo;

import java.util.ArrayList;
import java.util.Stack;
import trabalho_poo.exceptions.InputError;
import trabalho_poo.exceptions.InvalidOperator;
import trabalho_poo.exceptions.ZeroDivision;

class Calculadora {
    
    private ArrayList<Double> resultados;
    
    private Stack<Double> stackNumeros;
    
    private Double resultadoAtual;
    
    public Calculadora() {
        this.resultadoAtual = 0D;
        this.resultados = new ArrayList();
        this.stackNumeros = new Stack();
    }
    
    public Double calcular(String input) throws ZeroDivision {
        String infix = input.replace("\n", " ").replace("=", "");
        String postfix = ShuntingYard.postfix(infix);
        System.out.println(postfix);
        
        for(String c: postfix.split(" ")) {
            if (isNumber(c)) {
                this.stackNumeros.add(Double.parseDouble(c));
            } else {
                Double v1 = this.stackNumeros.pop();
                Double v2 = this.stackNumeros.pop();

                Double resultado = 0D;
                
                switch (c) {
                    case "+":
                        resultado = v2 + v1;
                        break;
                    case "-":
                        resultado = v2 - v1;
                        break;
                    case "*":
                        resultado = v2 * v1;
                        break;
                    case "/":
                        if (v1 == 0) {
                            this.stackNumeros = new Stack();
                            throw new ZeroDivision("Divisão por zero!");
                        }
                        resultado = v2 / v1;
                        break;
                }
                
                stackNumeros.add(resultado);
            }
        }
        
        this.resultadoAtual = stackNumeros.pop();
        return this.resultadoAtual;
    }
    
    public void checkInput(String input) throws Exception {
        String[] inputSemBreakLine = input.split("\n");
        
        int ultimoIndex = inputSemBreakLine.length - 1;
        String ultimoElemento = inputSemBreakLine[ultimoIndex];
        
        if (!isNumber(ultimoElemento) && !isValidOperator(ultimoElemento)) {
            throw new InvalidOperator("Operador inválido! Possíveis operandos: +, -, *, /");
        }
        
        int penultimoIndex = inputSemBreakLine.length - 2;
        String penultimoElemento = inputSemBreakLine[penultimoIndex];
        
        if (isNumber(ultimoElemento) && !isValidOperator(penultimoElemento)) {
           throw new InputError("Depois um número deve vir um operador válido!");
        } else if (isValidOperator(ultimoElemento) && !isNumber(penultimoElemento)) {
            throw new InputError("Depois de um operador deve vir um numero!");
        }
    }
    
    public void armazenar() {
        this.resultados.add(this.resultadoAtual);
    }
    
    private Boolean isNumber(String value) {
        for(Character c: value.toCharArray()) {
            if (Character.isDigit(c) == false) return false;
        }
        return true;
    }
    
    private Boolean isValidOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("=");
    }

    public ArrayList<Double> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<Double> resultados) {
        this.resultados = resultados;
    }

    public Double getResultadoAtual() {
        return resultadoAtual;
    }

    public void setResultadoAtual(Double resultadoAtual) {
        this.resultadoAtual = resultadoAtual;
    }
    
}
