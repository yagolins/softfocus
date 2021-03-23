package com.yago.softfocus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoriaEnum {

	POP("pop"), CLASSICA("classical"), FESTA("party"), ROCK("rock");

	private final String descricao;

}
