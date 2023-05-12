package com.fit.tarefas.tarefa.Exercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numeroRomano")
public class NumerosRomanosController {
	
	@GetMapping("{numero}")
	public String getNumeroRomano(@PathVariable int numero) {
		int[] valoresNumericos = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] valoresRomanos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String resposta = "";

		int i = 0;
		while (numero > 0) {
			if (numero >= valoresNumericos[i]) {
				resposta += valoresRomanos[i];
				numero -= valoresNumericos[i];
			} else {
				i++;
			}
		}

		return resposta;
	}

}
