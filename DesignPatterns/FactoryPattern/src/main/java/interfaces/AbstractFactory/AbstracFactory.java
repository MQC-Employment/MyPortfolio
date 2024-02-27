/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.AbstractFactory;

/**
 *
 * @author ManuelAlonso
 * @param <T>
 */
public interface AbstracFactory<T> {
    
    public T create(String whatToCreateP);
    
}
