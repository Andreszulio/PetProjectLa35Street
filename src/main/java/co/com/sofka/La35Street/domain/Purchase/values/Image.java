package co.com.sofka.La35Street.domain.Purchase.values;

import co.com.sofka.domain.generic.ValueObject;

public class Image implements ValueObject<String> {
    private final String image;

    public Image(String image){
        this.image = image;
    }

    @Override
    public String value(){
        return image;
    }

}

