package academy.devdojo.springboot2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//apesar de não ter dado o mesmo erro do curso
//vou implementar a notação de componente e transformar essa classe numa bean
@Component
public class DateUtil {
    public String formatLocalDateTimeToDatebaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}

