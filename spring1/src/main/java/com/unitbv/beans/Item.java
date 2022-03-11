package com.unitbv.beans;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public interface Item extends Serializable {
    String getTitle();
}
