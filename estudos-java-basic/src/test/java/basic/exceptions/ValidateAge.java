package basic.exceptions;

public class ValidateAge {

    //Here I declare one validation to age
    public String canEnter(Integer age) throws  MyExceptionValidateAge {
        if (age >= 18)
            return "You can Enter";
        else
            throw new MyExceptionValidateAge("You cannot enter");
    }


}
