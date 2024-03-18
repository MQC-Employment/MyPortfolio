/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author ManuelAlonso
 */
public class Person implements Comparable<Person>{

    private long id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(long id, String firstName, String lastName, int age) {
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        
    }

    public long getId() {
        
        return id;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        
        return "{" 
                + "\"id\":" + id + "," 
                + "\"firstName\":" + "\"" + firstName + "\"," 
                + "\"lastName\":" + "\"" + lastName + "\"," 
                + "\"age\":" + age
                + "}";
        
    } //End of toString.

    @Override
    public int compareTo(Person personaP){
        
        if(this.id > personaP.id){
            
            return 1;
            
        } else if(this.id < personaP.id){
            
            return -1;
            
        } else {
            
            return 0;
            
        }
        
    }

} //End of Person class.
