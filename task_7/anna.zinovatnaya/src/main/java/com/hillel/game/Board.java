package com.hillel.game;

public class Board {

  private char[][] array = new char[3][3];

  private char winner;

  public Board() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        array[i][j] = ' '; // Заносим пробел в каждую ячейку массива
      }
    }
  }

  public void print() {
    for (int i = 0; i < 3; i++) {
      System.out.println("-------");
      for (int j = 0; j < 3; j++) {
        System.out.print("|");
        System.out.print(array[i][j]);
      }
      System.out.println("|");
    }
    System.out.println("-------");
  }

  public void fillCell(int row, int column, char currentPlayer) {
    array[row][column] = currentPlayer;
  }

  // Метод работает только для первой строки нашего поля.
  // Подумайте как можно его доделать для всех горизонталей,
  // вертикалей и диагоналей.
  // Может быть его как-то можно упростить? Например, с помощью циклов.
  public boolean isGameFinished() {
    // проверка горизонталей
    for (int i = 0; i < 3; ++i) {
      if (array[i][0] == array[i][1]
          && array[i][1] == array[i][2]
          && array[i][2] == 'X') {
        winner = 'X'; // Здесь побеждают крестики
        return true;
      }

      if (array[i][0] == array[i][1]
          && array[i][1] == array[i][2]
          && array[i][2] == 'O') {
        winner = 'O'; // Здесь побеждают нолики
        return true;
      }
    }

    // проверка вертикатей
    for (int i = 0; i < 3; ++i) {
      if (array[0][i] == array[1][i]
          && array[1][i] == array[2][i]
          && array[2][i] == 'X') {
        winner = 'X'; // Здесь побеждают крестики
        return true;
      }

      if (array[0][i] == array[1][i]
          && array[1][i] == array[2][i]
          && array[2][i] == 'O') {
        winner = 'O'; // Здесь побеждают нолики
        return true;
      }
    }

    // проверка диагоналей
    if (array[0][0] == array[1][1]
        && array[1][1] == array[2][2]
        && array[2][2] == 'X') {
      winner = 'X'; // Здесь побеждают крестики
      return true;
    }

    if (array[0][0] == array[1][1]
        && array[1][1] == array[2][2]
        && array[2][2] == 'O') {
      winner = 'O'; // Здесь побеждают нолики
      return true;
    }

    if (array[0][2] == array[1][1]
        && array[1][1] == array[2][0]
        && array[2][0] == 'X') {
      winner = 'X'; // Здесь побеждают крестики
      return true;
    }

    if (array[0][2] == array[1][1]
        && array[1][1] == array[2][0]
        && array[2][0] == 'O') {
      winner = 'O'; // Здесь побеждают нолики
      return true;
    }

    return false;
  }

  public String getWinner() {
    if (winner == 'X') {
      return "Крестики одержали победу";
    } else {
      return "Нолики одержали победу";
    }
  }
}
