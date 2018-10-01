/**
*Just Hello Word class
*
*@author Vladimir Mytnik(vova@mytnik.net)
*@version 0.1
*/

package ru.job4j.calculate;

public class Calculate {
  /**
  *Entry point to the class and app. Print string to console.
  *@param args - string arguments array
  */
  public static void main(String[] args) {
    System.out.println("Hello Word!");
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