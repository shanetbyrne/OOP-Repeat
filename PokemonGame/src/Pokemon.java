import java.io.*;

/**
 * Pokemon class implements the serializable interface.
 */

public class Pokemon implements Serializable {

    private String name;

    public Pokemon(){
        this.name = "Anonymous";
    }

    public Pokemon(String name) {
      setName(name);
    }

    /**
     * getters and setters
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
