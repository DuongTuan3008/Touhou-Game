public class Employee extends Human {
    // name
    // age
    // gender

    // ham tao rong

    @Override
    public void eat() {
        super.eat(); // Human.eat()
        System.out.println(name + " eating done!");
    }
    // sleep
}
