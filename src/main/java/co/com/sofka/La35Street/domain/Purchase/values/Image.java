package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class Image implements ValueObject<String> {
    private final String Image;

    public Image(String Telephone){
        this.Image = Telephone;
    }

    @Override
    public String value(){
        return Image;
    }
}

