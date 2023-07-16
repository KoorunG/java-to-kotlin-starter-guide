package com.lannstark.lec07;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Lec07Main {

  public static void main(String[] args) throws IOException {
    Lec07Main.parseIntOrThrow("3");
//    Lec07Main.parseIntOrThrow("테스트");
  }

  private static int parseIntOrThrow(@NotNull String str) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(String.format("주어진 %s는 정수가 아닙니다.", str));
    }
  }
}
