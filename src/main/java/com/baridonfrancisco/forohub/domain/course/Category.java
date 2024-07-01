package com.baridonfrancisco.forohub.domain.course;

import java.util.Arrays;

public enum Category {
    FRONTEND,BACKEND,LOGICA_PROGRAMACION;



    public static boolean validCategory(String category){
        for(Category c:Category.values()){
            if(c.name().equalsIgnoreCase(category)){
                return true;
            }
        }
        return false;
    }

    public static Category getCategory(String strCategory) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name().equalsIgnoreCase(strCategory))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }


}
