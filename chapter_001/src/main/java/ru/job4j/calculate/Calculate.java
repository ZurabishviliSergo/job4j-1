package ru.job4j.calculate;

/**
 * Just Hello Word class
 *
 * @author Vladimir Mytnik(vova@mytnik.net)
 * @version 0.1
 */

public class Calculate {
  /**
   * Entry point to the class and app. Print string to console.
   * @param args - string arguments array
   */
  public static void main(String[] args) {
      char a = 'a';
      char b = 'b';
    System.out.println(a);
  }
  /**
   * Method echo.
   * @param name Your name.
   * @return Echo plus your name.
   */
  public String echo(String name) {
    return "Echo, echo, echo : " + name;
  }
}