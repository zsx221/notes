package SpringTest.designPatterns;

public class factoryDesignTest {
}
class animalFactory{
    Cat  getCat(){
        return new Cat();
    }
    Dog  getDog(){
        return new Dog();
    }
}

class Cat{

}
class Dog{

}